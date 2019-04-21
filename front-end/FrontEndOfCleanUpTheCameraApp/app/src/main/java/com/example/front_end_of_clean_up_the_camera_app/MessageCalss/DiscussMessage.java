package com.example.front_end_of_clean_up_the_camera_app.MessageCalss;

import java.util.Date;

//  DiscussMessage: message class of discuss of user for seller
//      discuss_username:   String
//      discuss_time:   date
//      discuss_score:  String
//      discuss_content:    String
public class DiscussMessage {

    private String discuss_username;
    private Date discuss_time;
    private String discuss_score;
    private String discuss_content;

    public String getDiscuss_username() {
        return discuss_username;
    }

    public Date getDiscuss_time() {
        return discuss_time;
    }

    public String getDiscuss_score() {
        return discuss_score;
    }

    public String getDiscuss_content() {
        return discuss_content;
    }


    public DiscussMessage(String discuss_username, Date discuss_time, String discuss_score, String discuss_content){

        this.discuss_username = discuss_username;
        this.discuss_time = discuss_time;
        this.discuss_score = discuss_score;
        this.discuss_content = discuss_content;
    }


}
