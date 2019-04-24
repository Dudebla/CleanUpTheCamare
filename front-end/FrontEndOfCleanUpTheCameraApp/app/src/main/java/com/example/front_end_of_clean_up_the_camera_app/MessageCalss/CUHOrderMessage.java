package com.example.front_end_of_clean_up_the_camera_app.MessageCalss;

/*CUHOrderMessage:  class   --for order message show at content_user_home_order_layout
*   ID: int --id of the order
*   orderStatu: int --situation of order
        *       ORDER_CANCELED = -1 //  user canceled the order
                ORDER_WAITING_PAYING = 0    //  user has not payed the cost
                ORDER_WAITING_SERVER = 1    //  seller has not take order
                ORDER_SENDING = 2   //  seller has taken order and send server
                ORDER_FINISHED = 3  //  order finished
*
*   userID: int --  id of user
*   sellerID:   int --  id of seller
*   orderTime:  java.sql.Date   --  time of user make order
*   cost:   double  --  cost of this order
*   location:   String  --  location of user needing server
*   userTip:    String  --  message of user left for seller
*   spaceType:  String  --  type of space, hotel/let/...
*   spaceArea:  double  --  area of space user need server(m2)
*   checkedStatu:   int --  situation of checked result*/
import java.sql.Date;

public class CUHOrderMessage {

    //  set order situation
    public static final int ORDER_CANCELED = -1;
    public static final int ORDER_WAITING_PAYING = 0;
    public static final int ORDER_WAITING_SERVER = 1;
    public static final int ORDER_SENDING = 2;
    public static final int ORDER_FINISHED = 3;
    //  set checked result situation
    public static final int NOT_FOUND_CAMERA = 0;
    public static final int FOUND_CAMERA = 1;

    private String ID;
    private int orderStatu;
    private String userID;
    private String sellerID;
    private Date orderTime;
    private double cost;
    private String location;
    private String userTip;
    private String spaceType;
    private double spaceArea;
    private int checkStatu;

    public CUHOrderMessage(String ID, int orderStatu, String userID, String sellerID, Date orderTime,
                           double cost, String location, String userTip, String spaceType,
                           double spaceArea, int checkStatu){
        this.ID = ID;
        this.orderStatu = orderStatu;
        this.userID = userID;
        this.sellerID = sellerID;
        this.orderTime = orderTime;
        this.cost = cost;
        this.location = location;
        this.userTip = userTip;
        this.spaceType = spaceType;
        this.spaceArea = spaceArea;
        this.checkStatu = checkStatu;

    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public int getOrderStatu() {
        return orderStatu;
    }

    public void setOrderStatu(int orderStatu) {
        this.orderStatu = orderStatu;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getSellerID() {
        return sellerID;
    }

    public void setSellerID(String sellerID) {
        this.sellerID = sellerID;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUserTip() {
        return userTip;
    }

    public void setUserTip(String userTip) {
        this.userTip = userTip;
    }

    public String getSpaceType() {
        return spaceType;
    }

    public void setSpaceType(String spaceType) {
        this.spaceType = spaceType;
    }

    public double getSpaceArea() {
        return spaceArea;
    }

    public void setSpaceArea(double spaceArea) {
        this.spaceArea = spaceArea;
    }

    public int getCheckStatu() {
        return checkStatu;
    }

    public void setCheckStatu(int checkStatu) {
        this.checkStatu = checkStatu;
    }



}
