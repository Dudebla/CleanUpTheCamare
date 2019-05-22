package domain;

public class Merchant {
    private String ID;
    private String Name;
    private String Address;
    private String Status;
    private String Introduction;
    private double score;

    public String getName() {
        return Name;
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

    public String getID() { return ID; }

    public double getScore() {
        return score;
    }

    public void setID(String ID) { this.ID = ID; }

    public void setName(String Name) {
        this.Name = Name;
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
}
