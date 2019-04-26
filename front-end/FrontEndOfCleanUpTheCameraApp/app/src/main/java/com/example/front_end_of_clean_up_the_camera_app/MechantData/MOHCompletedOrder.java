package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MOHCompletedOrder {

    private String orderNumber;
    private String orderTime;
    private String userName;
    private String userPhone;
    private String incomeMoney;

    public MOHCompletedOrder(String orderTime,String userName,String userPhone,String orderNumber,String incomeMoney) {
        this.orderTime=orderTime;
        this.userName=userName;
        this.userPhone=userPhone;
        this.orderNumber=orderNumber;
        this.incomeMoney=incomeMoney;
    }

    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String animal) {
        this.orderTime=orderTime;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }

    public String getUserPhone(){
        return userPhone;
    }
    public void setUserPhone(String userPhone){
        this.userPhone=userPhone;
    }

    public String getorderNumber(){return orderNumber;}
    public void setOrderNumber(String orderNumber){this.orderNumber=orderNumber;}

    public String getIncomeMoney(){return incomeMoney;}
    public void  setIncomeMoney(String incomeMoney){this.incomeMoney=incomeMoney;}



}
