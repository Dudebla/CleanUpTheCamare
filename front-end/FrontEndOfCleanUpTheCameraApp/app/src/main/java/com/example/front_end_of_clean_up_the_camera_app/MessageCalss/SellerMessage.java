package com.example.front_end_of_clean_up_the_camera_app.MessageCalss;
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
    private String sellerScore;
    private String sellerDistance;
    private String sellerCost;




    public SellerMessage(String sellerId, String sellerName, String sellerAddress, String sellerDistance,
                         String sellerScore, String sellerCost){
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

    public String getSellerScore() {
        return sellerScore;
    }

    public String getSellerDistance() {
        return sellerDistance;
    }

    public String getSellerCost() {
        return sellerCost;
    }


}
