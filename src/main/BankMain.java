package main;

import repository.BankRepository;
import service.BankService;

import java.util.Scanner;


public class BankMain {
    public static void main(String[] args) {
        BankRepository bankRepository = new BankRepository();

        BankService bankService = new BankService(bankRepository);

        Scanner sc = new Scanner(System.in);
        boolean runMainProgram = true;
        while (runMainProgram) {
            System.out.println("======은행 프로젝트=======\n");
            System.out.println("1. 신규 계좌 등록 메뉴 2. 잔액 조회 메뉴 3. 입금 메뉴" +
                    " 4. 출금 메뉴 5. 입출금 내역 조회 메뉴 0. 은행 프로그램 종료\n");
            System.out.println("=================\n");
            System.out.println("메뉴를 입력해 주세요 : \n");
            int menuMain = sc.nextInt();
            switch (menuMain) {
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
                    bankService.deposit();
                    break;

                //출금 메뉴
                case 4:
                    System.out.println("출금 메뉴");
                    bankService.withdraw();
                    break;
                //게시판 종료
                case 0:
                    System.out.println("게시판을 종료합니다.");
                    runMainProgram = false;
                    break;

                //입출금 내역 조회 메뉴
                case 5:
                    boolean runDepositWithdrawProgram = true;

                    while (runDepositWithdrawProgram) {
                        System.out.println("입출금 내역 조회 메뉴");
                        System.out.println("1. 계좌 전체 내역 메뉴 2. 입금 내역 메뉴 3. 출금 내역 메뉴" +
                                "4. 입출금 내역 조회 프로그램 종료\n");
                        System.out.println("=================\n");
                        System.out.println("조회하려는 계좌를 입력해주세요! : ");
                        String accountNumber = sc.next();

                        boolean checkaccountresult = bankRepository.checkaccount(accountNumber);
                        if (checkaccountresult) {
                            System.out.println("메뉴를 입력해 주세요 : \n");
                            int DepositWithdrawProgram = sc.nextInt();

                            switch (DepositWithdrawProgram) {
                                // 계좌 전체 내역 메뉴
                                case 1:
                                    System.out.println("계좌 전체 내역 메뉴");
                                    bankService.showAccountHistory();
                                    break;
                                //입금 내역 메뉴
                                case 2:
                                    System.out.println("입금 내역 메뉴");
                                    bankService.showDepositHistory(accountNumber); // 수정 필요
                                    break;

                                //출금 내역 메뉴
                                case 3:
                                    System.out.println("출금 내역 메뉴");
                                    bankService.showWithdrawHistory(accountNumber); // 수정 필요
                                    break;

                                //입출금 내역 프로그램 종료
                                case 4:
                                    System.out.println("입출금 내역 프로그램을 종료합니다.");
                                    runDepositWithdrawProgram = false;
                            }
                        } else {
                            System.out.println("없는 계좌 입니다.");
                        }
                    }
            }
        }
    }
}

