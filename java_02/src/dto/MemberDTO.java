package dto;

public class MemberDTO {
    private long id;
    private String memberName;
    private String memberEmail;
    private String memberPassword;
    private String memberMobile;

    // 증가값을 유지하기 위해 static으로 선언
    private static long num = 1L;
    // 기본생성자
    public MemberDTO(){

    }

    public MemberDTO(String memberName, String memberEmail, String memberPassword, String memberMobile) {
        // 객체를 생성하면서 num 값을 하나 증가시킨 결과를 id에 저장
        this.id = num++;
        this.memberName = memberName;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberMobile = memberMobile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberMobile() {
        return memberMobile;
    }

    public void setMemberMobile(String memberMobile) {
        this.memberMobile = memberMobile;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", memberEmail='" + memberEmail + '\'' +
                ", memberPassword='" + memberPassword + '\'' +
                ", memberMobile='" + memberMobile + '\'' +
                '}';
    }
}