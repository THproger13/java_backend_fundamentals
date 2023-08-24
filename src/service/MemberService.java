package service;

import dto.MemberDTO;
import repository.MemberRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MemberService {

    Scanner scanner = new Scanner(System.in);
    MemberRepository memberRepository = new MemberRepository();
    MemberDTO memberDTO = new MemberDTO();
    private List<MemberDTO> memberDTOList = new ArrayList<>();
    private static String loginEmail = null;
    /*
    회원가입

    이메일(memberEmail), 비밀번호(memberPassword), 이름(memberName), 전화번호(memberMobile)를 입력받음
    관리번호(id)는 회원가입시 자동으로 부여됨

    */
    public void save(){
        System.out.println("회원 가입할 이름 입력 : ");
        String membername = scanner.next();
        System.out.println("회원 가입할 이메일 입력 : ");
        String memberemail = scanner.next();
        System.out.println("회원 가입할 비밀 번호 입력 : ");
        String memberpassword = scanner.next();
        System.out.println("회원 가입할 전화 번호 입력 : ");
        String memberMobile = scanner.next();

        MemberDTO memberDTO = new MemberDTO(membername, memberemail, memberpassword, memberMobile);

        boolean result = MemberRepository.save(memberDTO);
        if (result) {
            System.out.println("회원가입 성공");
            System.out.println(memberDTO.toString());
            //System.out.println(memberRepository.findAll());
        } else {
            System.out.println("회원가입 실패");
        }

    }
//로그인 기능
    public void findById() {
        System.out.println("로그인 할 이메일을 입력해 주세요! : ");
        String memberemail = scanner.next();
        System.out.println("로그인 할 비밀 번호를 입력해 주세요! : ");
        String memberpassword = scanner.next();
        if(memberRepository.findById(memberemail,memberpassword)){
            loginEmail = memberemail;
            System.out.println("로그인 성공");
        }else {
            System.out.println("로그인 실패");
        }
    }
//회원 전체 목록을 출력
    public void findAll() {

        memberRepository.findAll();

    }

    //회원 정보 수정

    //회원 삭제
}
