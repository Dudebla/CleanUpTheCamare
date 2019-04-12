package domain;

public class User {
    private String userName;
    private String passWord;
    private String Id;
    private String Phone;
    private String Email;
    private int flag;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getId() {
        return Id;
    }

    public String getPhone() {
        return Phone;
    }

    public String getEmail() {
        return Email;
    }

    public int getFlag(){
        return flag;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setFlag(int flag){
        this.flag = flag;
    }
}
