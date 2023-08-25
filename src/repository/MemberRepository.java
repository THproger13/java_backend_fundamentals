package repository;

import dto.MemberDTO;
import service.MemberService;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    static List<MemberDTO> memberDTOList = new ArrayList<>();

    //회원 가입
    public static boolean signin(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }
    //회원가입시 이메일 중복체크
    public static boolean isduplicateemail(String memberemail) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberEmail().equals(memberemail) ) {
                return true;
            }
        }
        //일치하지 않으므로 이메일 사용 가능
        return false;
    }


    //회원 전화 번호 수정
    public boolean update(String updatedMobile, String confirmEmail){
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberEmail().equals(confirmEmail)) {
                memberDTO.setMemberMobile(updatedMobile);
                return true;
            }
        }
        return false;
    }

    //회원 전화번호 수정전 회원의 이메일,비번 확인
    public boolean confirmmember(String confirmEmail, String confirmPassword) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberEmail().equals(confirmEmail) && memberDTO.getMemberPassword().equals(confirmPassword)) {
                return true;
            }
        }
        return false;
    }

    //회원목록 출력
    public List<MemberDTO> findAll() {
        return new ArrayList<>(memberDTOList);
    }

    //탈퇴할 회원의 비밀번호 확인
    public boolean confirmDeletePassword(String confirmDeletePassword) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberPassword().equals(confirmDeletePassword)) {
                return true;
            }
        }
        return false;
    }
    //회원 탈퇴
    public boolean delete(String confirmDeletePassword){
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberPassword().equals(confirmDeletePassword)) {
                memberDTOList.remove(memberDTO);
            return true;
            }
        }
        return false;
    }
    //로그인
    public boolean login(String memberEmail, String memberPassword) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberEmail().equals(memberEmail) && memberDTO.getMemberPassword().equals(memberPassword)) {
                return true;
            }
        }
        return false;
    }
    //로그 아웃
    public boolean logout() {
        return true;
    }
}