package dto;

public class ClientDTO {
    private long cid;
    private String clientName;
    private String accountNumber;
    private int clientPass;
    private String clientCreatedAt;
    private long balance;

    private static long numCid = 1L;


    //기본생성자
    public ClientDTO(){

    }

    public ClientDTO(String clientName, String accountNumber, int clientPass, String clientCreatedAt, long balance){
        this.cid = numCid++;
        this.clientName = clientName;
        this.accountNumber = accountNumber;
        this.clientPass = clientPass;
        this.clientCreatedAt = clientCreatedAt;
        this.balance = balance;
    }

//    public ClientDTO(String accountNumber, String clientName, int clientPass, long balance) {
//    }


    public long getCid() {
        return cid;
    }

    public void setCid(long cid) {
        this.cid = cid;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getClientPass() {
        return clientPass;
    }

    public void setClientPass(int clientPass) {
        this.clientPass = clientPass;
    }

    public String getClientCreatedAt() {
        return clientCreatedAt;
    }

    public void setClientCreatedAt(String clientCreatedAt) {
        this.clientCreatedAt = clientCreatedAt;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "cid=" + cid +
                ", clientName='" + clientName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", clientPass=" + clientPass +
                ", clientCreatedAt='" + clientCreatedAt + '\'' +
                ", balance=" + balance +
                '}';
    }
}
