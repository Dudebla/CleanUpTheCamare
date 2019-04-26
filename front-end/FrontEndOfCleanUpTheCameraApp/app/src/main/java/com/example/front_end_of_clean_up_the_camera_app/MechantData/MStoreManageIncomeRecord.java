package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MStoreManageIncomeRecord {

    private String userName;

    private String incomeDate;

    private String incomeMoney;

    private String incomeOrderNumer;


    public MStoreManageIncomeRecord(String userName,String incomeDate,String incomeMoney,String incomeOrderNumer) {
        this.userName=userName;
        this.incomeDate=incomeDate;
        this.incomeMoney=incomeMoney;
        this.incomeOrderNumer=incomeOrderNumer;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }


    public String getIncomeDate() {
        return incomeDate;
    }
    public void setIncomeDate(String incomeDate) {
        this.incomeDate=incomeDate;
    }


    public String getIncomeMoney() {
        return incomeMoney;
    }
    public void setIncomeMoney(String incomeMoney) {
        this.incomeMoney=incomeMoney;
    }


    public String getIncomeOrderNumer() {
        return incomeOrderNumer;
    }
    public void setIncomeOrderNumer(String incomeOrderNumer) {
        this.incomeOrderNumer=incomeOrderNumer;
    }



}
