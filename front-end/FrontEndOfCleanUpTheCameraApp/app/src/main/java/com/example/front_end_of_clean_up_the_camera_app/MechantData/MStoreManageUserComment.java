package com.example.front_end_of_clean_up_the_camera_app.MechantData;

public class MStoreManageUserComment {

    private String userName;

    private String commentDate;

    private String commentContent;

    private String commentGrade;


    public MStoreManageUserComment(String userName,String commentGrade,String commentContent,String commentDate) {
        this.userName=userName;
        this.commentGrade=commentGrade;
        this.commentContent=commentContent;
        this.commentDate=commentDate;
    }


    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName=userName;
    }


    public String getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate=commentDate;
    }


    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent=commentContent;
    }


    public String getCommentGrade() {
        return commentGrade;
    }
    public void setCommentGrade(String commentGrade) {
        this.commentGrade=commentGrade;
    }



}
