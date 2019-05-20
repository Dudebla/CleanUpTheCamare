package com.example.front_end_of_clean_up_the_camera_app.MessageCalss;

public class UserMeaasge {
    private String userName;
    private int userType;
    private String userLocation;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public UserMeaasge(String userName, int userType, String userLocation){

        this.userName = userName;
        this.userType = userType;
        this.userLocation = userLocation;

    }


}
