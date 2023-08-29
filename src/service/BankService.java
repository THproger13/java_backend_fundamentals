package service;

import dto.AccountDTO;
import dto.ClientDTO;
import repository.BankRepository;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankService {
    ClientDTO clientDTO = new ClientDTO();
    AccountDTO accountDTO = new AccountDTO();

    BankRepository bankRepository = new BankRepository();
    Scanner sc = new Scanner(System.in);
    public void accountsave() {
            System.out.println("사용할 계좌번호를 입력해주세요! : ");
            String accountNumber = sc.next();

            boolean result = bankRepository.duplicateaccount(accountNumber);
            if (result) {
                System.out.println("중복된 계좌번호 입니다.");
            }else {
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

                bankRepository.accountsave(clientDTO);
                //ClientDTO clientDTO = new ClientDTO(clientName, accountNumber, clientPass, balance, clientCreatedAt);
                //System.out.println("createdAt = " + createdAt);
                System.out.println( bankRepository.accountsave(clientDTO) ? "계좌가 개설되었습니다." : "계좌 개시를 실패 하였습니다.");
                //findAll();
               ;
            }

        }

    public void showbalance() {
        System.out.println("잔액 조회할 계좌 번호를 입력해주세요! : ");
        String accountNumber = sc.next();

        Long result = bankRepository.showbalance(accountNumber);
        if(result != null){
            System.out.println(accountNumber + " 계좌를 찾았습니다.\n");
            System.out.println(accountNumber + " 의 잔액 : " + result);
        }else{
            System.out.println(accountNumber + " 는 없는 계좌입니다.\n");
        }
    }
}

