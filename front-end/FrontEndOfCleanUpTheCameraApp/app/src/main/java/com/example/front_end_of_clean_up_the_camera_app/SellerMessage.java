package com.example.front_end_of_clean_up_the_camera_app;
//  SellerMessage:
//      sellerId: String
//      sellerName: String
//      sellerAddress: String
//      sellerScore: double   (n.m)
//      sellerDistance: double (km) distance between user and seller
//      sellerCost: cost of server (￥n.mm)
public class SellerMessage {

    private String sellerId;
    private String sellerName;
    private String sellerAddress;
    private double sellerScore;
    private double sellerDistance;
    private double sellerCost;




    public SellerMessage(String sellerId, String sellerName, String sellerAddress, Double sellerDistance,
                         double sellerScore, double sellerCost){
        this.sellerId = sellerId;
        this.sellerName = sellerName;
        this.sellerAddress = sellerAddress;
        this.sellerDistance = sellerDistance;
        this.sellerScore = sellerScore;
        this.sellerCost = sellerCost;

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

    public double getSellerScore() {
        return sellerScore;
    }

    public double getSellerDistance() {
        return sellerDistance;
    }

    public double getSellerCost() {
        return sellerCost;
    }


}
