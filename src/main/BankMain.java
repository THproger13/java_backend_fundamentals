package main;
import service.BankService;

import java.util.Scanner;

public class BankMain {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while(run) {
            System.out.println("======은행 프로젝트=======\n");
            System.out.println("1. 신규 계좌 등록 메뉴 2. 잔액 조회 메뉴 3. 입금 메뉴" +
                    " 4. 출금 메뉴 5. 입출금 내역 조회 메뉴 6. 고객 정보 샘플 데이터 저장 7. 거래 내역 샘플 데이터 저장 0. 은행 프로그램 종료\n");
            System.out.println("=================\n");
            System.out.println("메뉴를 입력해 주세요 : \n");
            int menu = sc.nextInt();
            switch (menu){
                // 신규 계좌 등록 메뉴
                case 1:
                    System.out.println("신규 계좌 등록 메뉴");
                    bankService.accountsave();
                    break;
                //잔액 조회 메뉴
                case 2:
                    System.out.println("잔액 조회 메뉴");
                    bankService.showbalance();
                    break;

                //입금 메뉴
                case 3:
                    System.out.println("입금 메뉴");
                    //boardService.check();
                    break;

                //출금 메뉴
                case 4:
                    System.out.println("출금 메뉴");
                    //boardService.update();
                    break;

                //입출금 내역 조회 메뉴
                case 5:
                    System.out.println("입출금 내역 조회 메뉴");
                    //boardService.delete();
                    break;
                    //샘플 데이터 저장
                case 6:
                    System.out.println("고객정보 샘플데이터 저장");
                    //boardService.saveclientsample();
                    break;

                case 7:
                    System.out.println("거래내역 샘플데이터 저장");
                    //boardService.saveaccountsample();
                    break;

                //게시판 종료
                case 0:
                    System.out.println("게시판을 종료합니다.");
                    run = false;
            }

        }
    }
}
