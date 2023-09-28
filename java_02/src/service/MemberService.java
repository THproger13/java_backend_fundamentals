package service;

import dto.MemberDTO;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {

    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    private List<MemberDTO> memberDTOList = new ArrayList<>();

    //로그인 여부를 판단하는 static 필드
    private static String loginEmail = null;
    boolean islogin = false;
    /*
    회원가입

    이메일(memberEmail), 비밀번호(memberPassword), 이름(memberName), 전화번호(memberMobile)를 입력받음
    관리번호(id)는 회원가입시 자동으로 부여됨

    */
    public void signin(){
        System.out.println("회원 가입할 이메일 입력 : ");
        String memberEmail = scanner.next();
        boolean isduplicateemail = MemberRepository.isduplicateemail(memberEmail);
        if(isduplicateemail){
            System.out.println("사용 중인 이메일 입니다.");
        }else {
            System.out.println("사용 가능한 이메일 입니다. ");
            System.out.println("회원 가입할 비밀 번호 입력 : ");
            String memberPassword = scanner.next();
            System.out.println("회원 가입할 이름 입력 : ");
            String memberName = scanner.next();
            System.out.println("회원 가입할 전화 번호 입력 : ");
            String memberMobile = scanner.next();

            MemberDTO memberDTO = new MemberDTO(memberName, memberEmail, memberPassword, memberMobile);

            boolean result = MemberRepository.signin(memberDTO);
            System.out.println(result ? "회원가입 성공" : "회원가입 실패");

        }

    }

    //회원 전체 목록
    public void findAll() {
        List<MemberDTO> members = memberRepository.findAll();
        for (MemberDTO member : members) {
            System.out.println(member.toString());
        }
    }

    //회원 전화 번호 수정
    public void update(){
        System.out.println("이메일을 입력해 주세요! : ");
        String confirmEmail = scanner.next();
        System.out.println("비밀 번호를 입력해 주세요! : ");
        String confirmPassword = scanner.next();
        if(memberRepository.confirmmember(confirmEmail,confirmPassword)){
            System.out.println(confirmEmail + "님 확인 되었습니다.");
            System.out.println("수정할 전화 번호를 입력해 주세요! : ");
            String updatedMobile = scanner.next();
            if(memberRepository.update(updatedMobile,confirmEmail)) {
                System.out.println(confirmEmail + "님 전화 번호가 수정 되었습니다.");
                //System.out.println(memeberDTO.toString());
            }else{
                System.out.println(confirmEmail + "님 전화 번호 수정을 실패하였습니다.");
            }
            //loginEmail = confirmEmail;
        }else {
            System.out.println("회원 확인 실패");
        }
    }
    //회원 탈퇴
    public void delete() {
        if(!loginEmail.isEmpty()){
            System.out.println("탈퇴 전 비밀 번호를 입력해 주세요! : ");
            String confirmDeletePassword = scanner.next();
            if(memberRepository.confirmDeletePassword(confirmDeletePassword)){
                memberRepository.delete(confirmDeletePassword);
            }else{
                System.out.println("비밀번호가 틀렸습니다.");
            }
        }else{
            System.out.println("로그인을 먼저 해주세요!");
        }
    }

    //로그인 기능
    public void login() {
        System.out.println("로그인 할 이메일을 입력해 주세요! : ");
        String memberEmail = scanner.next();
        System.out.println("로그인 할 비밀 번호를 입력해 주세요! : ");
        String memberPassword = scanner.next();
        if(memberRepository.login(memberEmail,memberPassword)){
            System.out.println("로그인 성공");
            loginEmail = memberEmail;
            islogin = true;
        }else {
            System.out.println("로그인 실패");
        }
    }

    //로그 아웃
    public void logout() {
        if(islogin) {
            memberRepository.logout();
            System.out.println("로그 아웃 되었습니다.");
            islogin = false;
       }else{
            System.out.println("로그인 해주세요!");
        }
    }


}