package com.example.myapplication.models;

public class Comment {
    private String commentText;
    private String date;
    private String pic;
    private String time;
    private String userId;

    public Comment() {
    }

    public Comment(String commentText, String date, String pic, String time, String userId) {
        this.commentText = commentText;
        this.date = date;
        this.pic = pic;
        this.time = time;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentText='" + commentText + '\'' +
                ", date='" + date + '\'' +
                ", pic='" + pic + '\'' +
                ", time='" + time + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

}



