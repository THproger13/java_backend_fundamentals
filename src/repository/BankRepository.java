package repository;

import dto.ClientDTO;

import java.util.ArrayList;
import java.util.List;

public class BankRepository {
    List<ClientDTO> clientDTOList = new ArrayList<>();
    //List<AccountDTO> accountDTOList = new ArrayList<>();

    //계좌 생성시 계좌번호 중복 체크
    public boolean duplicateaccount(String accountNumber) {
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

}
