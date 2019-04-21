package com.example.front_end_of_clean_up_the_camera_app.MessageCalss;

/*HotelMessage: class for hotel message showing at hotel_around_list_layout.xml
*   hotelName:  String
*   hotelAddress:   String
*   checkedTimes:   int --  times of platform checked the hotel
*   checkedOutTimes:    int --  times of platform checked out illegal cameras in the hotel
*   checkedRate:    double  --  checkedTimes/checkedOutTimes    */

import java.text.DecimalFormat;

public class HotelMessage {

    private String hotelName;
    private String hotelAddress;
    private int checkedTimes;
    private int checkedOutTimes;
    private double checkedRate;


    public HotelMessage(String hotelName, String hotelAddress, int checkedTimes, int checkedOutTimes){
        this.hotelName = hotelName;
        this.hotelAddress = hotelAddress;
        this.checkedTimes = checkedTimes;
        this.checkedOutTimes = checkedOutTimes;

        if (this.checkedTimes != 0) {
            DecimalFormat decimalFormat = new DecimalFormat("#.00");
            this.checkedRate = Double.valueOf(decimalFormat.format((double) checkedOutTimes / checkedTimes * 100));
        }else{
            this.checkedRate = 0.00;
        }
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getCheckedTimes() {
        return checkedTimes;
    }

    public void setCheckedTimes(int checkedTimes) {
        this.checkedTimes = checkedTimes;
    }

    public int getCheckedOutTimes() {
        return checkedOutTimes;
    }

    public void setCheckedOutTimes(int checkedOutTimes) {
        this.checkedOutTimes = checkedOutTimes;
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    public double getCheckedRate() {
        return checkedRate;
    }

    public void setCheckedRate(double checkedRate) {
        this.checkedRate = checkedRate;
    }

}
