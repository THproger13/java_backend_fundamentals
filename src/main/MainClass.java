package main;

import service.MemberService;

import java.util.Scanner;

public class MainClass {
    // 스캐너를 이용하여
    // 1. 회원가입
    // 2. 로그인
    // 3. 회원 목록 조회
    // 4. 회원 정보 수정
    // 5. 회원 삭제
    // 0. 종료
    // 를 선택하는 코드를 작성합시다.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MemberService memberService = new MemberService();
        boolean run = true;
        while (run) {
            System.out.println("====== 회원관리 ======");
            System.out.println("1.회원 가입 2.로그인 3.회원 목록 조회 4.회원 정보 수정 5.회원 삭제 0.종료");
            System.out.println("선택>  ");
            int sel = scanner.nextInt();
            if (sel == 1) {
                System.out.println("회원 가입 메뉴");
                memberService.save();
            } else if (sel == 2) {
                System.out.println("로그인");
                memberService.findById();
            } else if (sel == 3) {
                System.out.println("회원 목록 조회");
                memberService.findAll();
            } else if (sel == 4) {
                System.out.println("회원 정보 수정");
                //memberService.update();
            } else if (sel == 5) {
                System.out.println("회원 삭제");
//              memberService.delete();
            } else if (sel == 0) {
                System.out.println("종료");
                run = false;
            }
        }
    }
}