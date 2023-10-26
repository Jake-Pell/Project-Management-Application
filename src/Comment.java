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
        this.date = date;
    }
    public boolean addReply(Comment comment){
        return true;
    }

    public User getAuthor() {
        return author;
    }

    public String getDescription() {
        return description;
    }

    public String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public ArrayList<Comment> getReplies() {
        return replies;
    }
}