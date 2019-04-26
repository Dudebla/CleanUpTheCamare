package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MOHCanceledOrder {

    private String orderTime;
    private String userName;
    private String userPhone;

    public MOHCanceledOrder(String orderTime,String userName,String userPhone) {
        this.orderTime=orderTime;
        this.userName=userName;
        this.userPhone=userPhone;

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


}
