package repository;

import dto.ClientDTO;
import dto.AccountDTO;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankRepository {

    List<ClientDTO> clientDTOList = new ArrayList<>();
    List<AccountDTO> accountDTOList = new ArrayList<>();

    //계좌번호 중복 체크(여러 기능에서 중복 사용)
    public boolean checkaccount(String accountNumber) {

        System.out.println(accountNumber);

        for(ClientDTO clientDTO : clientDTOList){
            if(accountNumber.equals(clientDTO.getAccountNumber())){
                return true;
            }
        }
        return false;
    }
    //생성된 계좌 저장
    public boolean accountsave(ClientDTO clientDTO){

        return clientDTOList.add(clientDTO);
    }

    //계좌 일치 여부 확인후 계좌 잔액 반환
    public Long showbalance(String accountNumber) {
        for(ClientDTO clientDTO : clientDTOList){
            if(accountNumber.equals(clientDTO.getAccountNumber())){
                return clientDTO.getBalance();
            }
        }
        return null;
    }

    //특정 계좌에 입금하기
    public void deposit(long deposit, String accountNumber, String bankingAt) {
        //System.out.println("deposit = " + deposit + ", accountNumber = " + accountNumber + ", bankingAt = " + bankingAt);
        for(ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                //System.out.println(clientDTO.getBalance());

                clientDTO.setBalance(clientDTO.getBalance() + deposit) ;
                //System.out.println(clientDTO.getBalance());

                AccountDTO accountDTO = new AccountDTO();
                accountDTO.setDeposit(deposit);
                accountDTO.setAccountNumber(accountNumber);
                accountDTO.setBankingAt(bankingAt);
                accountDTOList.add(accountDTO);
                break;
            }
        }
    }

    public boolean checkclientpass(int clientPass) {
        for(ClientDTO clientDTO : clientDTOList){
            if(clientPass == clientDTO.getClientPass()){
                return true;
            }
        }
        return false;
    }

    public void withdraw(long withdraw, String accountNumber, String bankingAt) {
        for(ClientDTO clientDTO : clientDTOList) {
            if (accountNumber.equals(clientDTO.getAccountNumber())) {
                //System.out.println(clientDTO.getBalance());
                if(clientDTO.getBalance() >= withdraw) {
                    clientDTO.setBalance(clientDTO.getBalance() - withdraw);
                    //System.out.println(clientDTO.getBalance());
                    AccountDTO accountDTO = new AccountDTO();
                    accountDTO.setWithdraw(withdraw);
                    accountDTO.setAccountNumber(accountNumber);
                    accountDTO.setBankingAt(bankingAt);
                    System.out.println(accountNumber + "에서 " + withdraw + "원이 출금되었습니다. ");
                    accountDTOList.add(accountDTO);
                }else{
                    System.out.println("잔액이 부족합니다.");
                }
                break;
            }
        }
    }
    public List<AccountDTO> showAccountHistory(){
        return new ArrayList<>(accountDTOList);
    }

    // BankRepository 클래스의 showDepositHistory 메서드 수정
    public List<AccountDTO> showDepositHistory(String accountNumber) {
        List<AccountDTO> accountDeposits = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber()) && accountDTO.getDeposit() > 0) {
                accountDeposits.add(accountDTO);
            }
        }
        return accountDeposits.isEmpty() ? null : accountDeposits;
    }


    // BankRepository 클래스의 showWithdrawHistory 메서드 수정
    public List<AccountDTO> showWithdrawHistory(String accountNumber) {
        List<AccountDTO> accountWithdraws = new ArrayList<>();
        for (AccountDTO accountDTO : accountDTOList) {
            if (accountNumber.equals(accountDTO.getAccountNumber()) && accountDTO.getWithdraw() > 0) {
                accountWithdraws.add(accountDTO);
            }
        }
        return accountWithdraws.isEmpty() ? null : accountWithdraws;
    }
}
