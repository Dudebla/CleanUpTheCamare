package com.example.front_end_of_clean_up_the_camera_app.MessageCalss;

import java.io.Serializable;

//  SellerMessage:
//      sellerId: String
//      sellerName: String
//      sellerAddress: String
//      sellerScore: double   (n.m)
//      sellerDistance: double (km) distance between user and seller
//      sellerCost: cost of server (￥n.mm)
public class SellerMessage implements Serializable {

    private String sellerId;
    private String sellerName;

    public String getSellerIntro() {
        return sellerIntro;
    }

    public void setSellerIntro(String sellerIntro) {
        this.sellerIntro = sellerIntro;
    }

    private String sellerIntro;
    private String sellerAddress;
    private String sellerScore;
    private String sellerDistance;
    private String sellerCost;

    private String status;




    public SellerMessage(String sellerId, String sellerName, String sellerIntro, String sellerAddress, String sellerDistance,
                         String sellerScore, String sellerCost, String status){
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerIntro = sellerIntro;
        this.sellerAddress = sellerAddress;
        this.sellerDistance = sellerDistance;
        this.sellerScore = sellerScore;
        this.sellerCost = sellerCost;
        this.status = status;

    }

    public String getSellerId() {
        return sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public String getSellerAddress() {
        return sellerAddress;
    }

    public String getSellerScore() {
        return sellerScore;
    }

    public String getSellerDistance() {
        return sellerDistance;
    }

    public String getSellerCost() {
        return sellerCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
