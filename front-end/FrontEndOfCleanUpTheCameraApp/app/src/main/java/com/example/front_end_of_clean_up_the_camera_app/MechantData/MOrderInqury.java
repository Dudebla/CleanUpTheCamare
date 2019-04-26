package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MOrderInqury {

    //订单时间，记录为接单时间？？
    private String orderTime;
    private String userName;
    private String userPhone;
    //用户评论
    private String userComment;
    //交易金额
    private String TransactionAmount;
    private String orderNumber;

    public MOrderInqury(String orderTime,String userName,String userPhone,String userComment,String TransactionAmount,String orderNumber) {
        this.orderTime=orderTime;
        this.userName=userName;
        this.userPhone=userPhone;
        this.orderNumber = orderNumber;
        this.userComment=userComment;
        this.TransactionAmount=TransactionAmount;
    }

    public String getOrderTime() {
        return orderTime;
    }
    public void setOrderTime(String orderTime) {
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

    public String getUserComment(){
        return userComment;
    }
    public void setUserAddress(String userAddress){
        this.userComment=userAddress;
    }

    public String getTransactionAmount(){
        return TransactionAmount;
    }
    public void setTransactionAmount(String TransactionAmount){
        this.TransactionAmount=TransactionAmount;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }



}
