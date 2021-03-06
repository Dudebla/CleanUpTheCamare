package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MOHGoingOrder {

    private String orderTime;
    private String reciveTime;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userRemarks;
    private String estimatedAmount;

    public String getOrderNumber() {
        return orderNumber;
    }

    private String orderNumber;

    private int userImage;

    public MOHGoingOrder(String orderTime,String reciveTime,String userName,String userPhone,String userAddress,String userRemarks,String estimatedAmount,String orderNumber, int userImage) {
        this.reciveTime=reciveTime;
        this.orderTime=orderTime;
        this.userName=userName;
        this.userPhone=userPhone;
        this.userAddress=userAddress;
        this.userRemarks=userRemarks;
        this.estimatedAmount=estimatedAmount;
        this.orderNumber = orderNumber;
        this.userImage=userImage;
    }

    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String orderTime) {
        this.orderTime=orderTime;
    }

    public String getReciveTime(){
        return reciveTime;
    }
    public void setReciveTime(String reciveTime){
        this.reciveTime=reciveTime;
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

    public String getUserAddress(){
        return userAddress;
    }
    public void setUserAddress(String userAddress){
        this.userAddress=userAddress;
    }

    public String getUserRemarks(){
        return userRemarks;
    }
    public void setUserRemarks(String userRemarks){
        this.userRemarks=userRemarks;
    }

    public String getEstimatedAmount(){
        return estimatedAmount;
    }
    public void setEstimatedAmount(String estimatedAmount){
        this.estimatedAmount=estimatedAmount;
    }

    public int getUserImage() {
        return userImage;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public void setUserImage(int userImage) {
        this.userImage = userImage;
    }
}
