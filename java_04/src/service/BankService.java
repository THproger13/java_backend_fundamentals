package service;

import dto.AccountDTO;
import dto.ClientDTO;
import repository.BankRepository;

import java.util.List;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankService {
    private BankRepository bankRepository; // 인스턴스 생성
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }


    ClientDTO clientDTO = new ClientDTO();
        AccountDTO accountDTO = new AccountDTO();

        //BankRepository bankRepository = new BankRepository();
        Scanner sc = new Scanner(System.in);
        public void accountsave() {
            System.out.println("사용할 계좌번호를 입력해주세요! : ");
            String accountNumber = sc.next();

            boolean result = bankRepository.checkaccount(accountNumber);
            if (result) {
                System.out.println("중복된 계좌번호 입니다.");
            } else {
                clientDTO.setAccountNumber(accountNumber);

                System.out.println("가입자 성명을 입력해주세요! : ");
                String clientName = sc.next();
                clientDTO.setClientName(clientName);

                System.out.println("사용할 비밀번호를 입력해주세요");
                int clientPass = Integer.parseInt(sc.next());
                clientDTO.setClientPass(clientPass);

                System.out.println("해당 계좌의 잔액을 입력해주세요! : ");
                long balance = sc.nextLong();
                clientDTO.setBalance(balance);

                LocalDateTime now = LocalDateTime.now();
                String createdAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
                clientDTO.setClientCreatedAt(createdAt);

                boolean issaved = bankRepository.accountsave(clientDTO);
                //System.out.println(clientDTOList);

                //ClientDTO clientDTO = new ClientDTO(clientName, accountNumber, clientPass, balance, clientCreatedAt);
                //System.out.println("createdAt = " + createdAt);
                if (issaved) {
                    System.out.println("계좌가 개설되었습니다.");
                } else {
                    System.out.println("계좌 개시를 실패 하였습니다.");
                }
            }
        }

        public void showbalance () {
            System.out.println("잔액 조회할 계좌 번호를 입력해주세요! : ");
            String accountNumber = sc.next();

            Long result = bankRepository.showbalance(accountNumber);
            if (result != null) {

                System.out.println(accountNumber + " 의 잔액 : " + result);
            } else {
                System.out.println(accountNumber + " 는 없는 계좌입니다.\n");
            }
        }

        public void deposit () {
            System.out.println("입금하려는 계좌를 입력해주세요! : ");
            String accountNumber = sc.next();

            boolean result = bankRepository.checkaccount(accountNumber);
            if (result) {
                System.out.println("계좌번호를 찾았습니다.\n");
                System.out.println("입금 금액을 입력해주세요! : ");
                long deposit = sc.nextLong();
                LocalDateTime now = LocalDateTime.now();

                String bankingAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
                //System.out.println( "잔액 : " + deposit);
                bankRepository.deposit(deposit, accountNumber, bankingAt);

                System.out.println(accountNumber + "에 " + deposit + "원이 입금되었습니다. ");

            } else {
                System.out.println("없는 계좌번호 입니다. ");
            }
        }

        public void withdraw () {
            System.out.println("출금하려는 계좌를 입력해주세요! : ");
            String accountNumber = sc.next();

            boolean checkaccountresult = bankRepository.checkaccount(accountNumber);
            if (checkaccountresult) {
                System.out.println("계좌번호를 찾았습니다.\n");
                System.out.println("출금할 계좌의 비밀번호를 입력해주세요! : ");
                int clientPass = Integer.parseInt(sc.next());
                boolean checkclientpass = bankRepository.checkclientpass(clientPass);
                if (checkclientpass) {
                    System.out.println("출금 금액을 입력해주세요! : ");
                    long withdraw = sc.nextLong();
                    LocalDateTime now = LocalDateTime.now();
                    String bankingAt = now.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분ss초"));
                    //System.out.println( "잔액 : " + deposit);
                    bankRepository.withdraw(withdraw, accountNumber, bankingAt);
                } else {
                    System.out.println("비밀번호가 틀렸습니다.");
                }
            } else {
                System.out.println("없는 계좌번호 입니다. ");
            }

        }
//account의 전체 거래내역을 출력
        public void showAccountHistory () {
            List<AccountDTO> accounts = bankRepository.showAccountHistory();
            for (AccountDTO account : accounts) {
                System.out.println(account.toString());
            }
        }

        public void showDepositHistory (String accountNumber){
            List<AccountDTO> accountDeposits = bankRepository.showDepositHistory(accountNumber);
            if (accountDeposits != null) {
                for (AccountDTO accountDeposit : accountDeposits) {
                    System.out.println(accountDeposit.toString());
                }
            } else {
                System.out.println("입금 내역이 없습니다.");
            }
        }

        // BankService 클래스의 showWithdrawHistory 메서드 수정
        public void showWithdrawHistory (String accountNumber){
            List<AccountDTO> accountWithdraws = bankRepository.showWithdrawHistory(accountNumber);
            if (accountWithdraws != null) {
                for (AccountDTO accountWithdraw : accountWithdraws) {
                    System.out.println(accountWithdraw.toString());
                }
            } else {
                System.out.println("출금 내역이 없습니다.");
            }
        }
    }


