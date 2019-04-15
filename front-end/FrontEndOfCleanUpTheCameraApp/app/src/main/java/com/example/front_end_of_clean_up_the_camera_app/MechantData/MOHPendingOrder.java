package com.example.front_end_of_clean_up_the_camera_app.MechantData;

//封装商家订单处理待处理子页的数据（用户订单信息）
public class MOHPendingOrder {

    private String orderTime;
    private String userName;
    private String userPhone;
    private String userAddress;
    private String userRemarks;
    private String estimatedAmount;
    private int userImage;

    public MOHPendingOrder(String orderTime,String userName,String userPhone,String userAddress,String userRemarks,String estimatedAmount,int userImage) {
        this.orderTime=orderTime;
        this.userName=userName;
        this.userPhone=userPhone;
        this.userAddress=userAddress;
        this.userRemarks=userRemarks;
        this.estimatedAmount=estimatedAmount;
        this.userImage=userImage;
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

    public int getUserImage(){
        return userImage;
    }
    public void setUserImage(int userImage){
        this.userImage=userImage;
    }


}
