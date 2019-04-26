package com.example.front_end_of_clean_up_the_camera_app.MechantData;


//商家店铺管理信息类
public class MStoreManageMessage {

    private int MechantImage;

    private String MechantName;

    private String MechantAddress;

    private String MechantStoreCondition;

    private String MechantServiceGrade;

    private String MechantServicePrice;


    MStoreManageMessage(int MechantImage,String MechantName,String MechantAddress,String MechantStoreCondition,String MechantServiceGrade,String MechantServicePrice){

        this.MechantImage=MechantImage;

        this.MechantAddress=MechantAddress;

        this.MechantName=MechantName;

        this.MechantServiceGrade=MechantServiceGrade;

        this.MechantServicePrice=MechantServicePrice;

        this.MechantStoreCondition=MechantStoreCondition;

    }


    public String getMechantName() {
        return MechantName;
    }
    public void setMechantName(String MechantName) {
        this.MechantName=MechantName;
    }

    public String getMechantAddress() {
        return MechantAddress;
    }
    public void setMechantAddress(String MechantAddress) {
        this.MechantAddress=MechantAddress;
    }

    public String getMechantStoreCondition(){
        return MechantStoreCondition;
    }
    public void setMechantStoreCondition(String MechantStoreCondition){
        this.MechantStoreCondition=MechantStoreCondition;
    }

    public int getMechantImage(){
        return MechantImage;
    }
    public void setMechantImage(int MechantImage){
        this.MechantImage=MechantImage;
    }

    public String getMechantServiceGrade(){return MechantServiceGrade;}
    public void setMechantServiceGrade(String MechantServiceGrade){this.MechantServiceGrade=MechantServiceGrade;}

    public String getMechantServicePrice(){return MechantServicePrice;}
    public void setMechantServicePrice(String MechantServicePrice){this.MechantServicePrice=MechantServicePrice;}


}
