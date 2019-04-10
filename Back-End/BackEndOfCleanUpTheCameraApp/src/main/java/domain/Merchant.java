package domain;

public class Merchant {
    private String userName;
    private String passWord;
    private String Id;
    private String Phone;
    private String Email;
    private String Address;
    private String Status;
    private String Introduction;
    private double score;
    private String path;            //图片存储路径

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

    public String getAddress() {
        return Address;
    }

    public String getStatus() {
        return Status;
    }

    public String getIntroduction() {
        return Introduction;
    }

    public double getScore() {
        return score;
    }

    public String getPath() {
        return path;
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

    public void setAddress(String address) {
        Address = address;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public void setIntroduction(String introduction) {
        Introduction = introduction;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
