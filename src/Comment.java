// Copyright 2023 Cocky 4

import java.util.Date;
import java.util.ArrayList;

public class Comment {
   
    private User author;
    private String description;
    private Date date;
    private ArrayList<Comment> replies;

    public Comment(User author, String description){

        
    }
    public boolean addReply(Comment comment){


        return true;
    }


}
