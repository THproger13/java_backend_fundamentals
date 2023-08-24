package repository;

import dto.MemberDTO;
import service.MemberService;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    MemberDTO memberDTO = new MemberDTO();
    MemberService memberService = new MemberService();


    static List<MemberDTO> memberDTOList = new ArrayList<>();
    //회원 가입
    public static boolean save(MemberDTO memberDTO) {
        return memberDTOList.add(memberDTO);
    }
    //로그인
    public boolean findById(String memberemail, String memberpassword) {
        for (MemberDTO memberDTO : memberDTOList) {
            if (memberDTO.getMemberEmail().equals(memberemail) && memberDTO.getMemberPassword().equals(memberpassword)) {
                return true;
            }
        }
        return false;
    }

    //회원목록 출력
    public List<MemberDTO> findAll() {

        return memberDTOList;
    }
}
