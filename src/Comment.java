// Copyright 2023 Cocky 4


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class Comment {
   
    private User author;
    private String description;
    private String date;
    private ArrayList<Comment> replies;


    public Comment(User author, String description){
        this.author = author;
        this.description = description;
        this.date = getCurrentDate();
        this.replies = new ArrayList<Comment>();
    }

    // constructor called by DataLoader
    public Comment(User author, String description, String date, ArrayList<Comment> replies) {
        this.author = author;
        this.description = description;
        this.date = date;
        this.replies = replies;
    }



    public boolean addReply(Comment comment){
        return replies.add(comment);
    }

    public User getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Comment> getReplies() {
        return replies;
    }
}