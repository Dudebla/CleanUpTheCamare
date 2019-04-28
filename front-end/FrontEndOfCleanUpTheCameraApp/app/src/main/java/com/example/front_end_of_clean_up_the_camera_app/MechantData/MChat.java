package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MChat {

    private String chatName;
    private String chatDate;
    private String chatLatestMessage;
    private int chatImage;

    public MChat(String chatName,String chatDate,String chatLatestMessage,int chatImage) {
        this.chatName=chatName;
        this.chatDate=chatDate;
        this.chatLatestMessage=chatLatestMessage;
        this.chatImage=chatImage;

    }

    public String getChatName() {
        return chatName;
    }
    public void setChatName(String name) {
        this.chatName=chatName;
    }

    public String getChatDate() {
        return chatDate;
    }
    public void setChatDate(String chatDate) {
        this.chatDate=chatDate;
    }

    public String getChatLatestMessage(){
        return chatLatestMessage;
    }
    public void setChatLatestMessage(String chatLatestMessage){
        this.chatLatestMessage=chatLatestMessage;
    }

    public int getChatImage(){return chatImage;}
    public void setChatImage(int chatImage){
        this.chatImage=chatImage;
    }



}
