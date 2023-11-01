import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Represents a comment made by a user.
 *
 * @author Cocky 4
 * @since 2023
 */
public class Comment {

    private User author;
    private String description;
    private String date;
    private ArrayList<Comment> replies;

    /**
     * Constructs a comment with the given author and description. Date is set to the current date and time.
     *
     * @param author      The user who created the comment.
     * @param description The content of the comment.
     */
    public Comment(User author, String description) {
        this.author = author;
        this.description = description;
        this.date = getCurrentDate();
        this.replies = new ArrayList<Comment>();
    }

    // Constructor called by DataLoader
    /**
     * Constructs a comment with specified details.
     *
     * @param author      The user who created the comment.
     * @param description The content of the comment.
     * @param date        The date and time the comment was created.
     * @param replies     The list of replies to this comment.
     */
    public Comment(User author, String description, String date, ArrayList<Comment> replies) {
        this.author = author;
        this.description = description;
        this.date = date;
        this.replies = replies;
    }

    /**
     * Adds a reply to this comment.
     *
     * @param comment The reply to be added.
     * @return True if the reply was added successfully.
     */
    public boolean addReply(Comment comment) {
        return replies.add(comment);
    }

    /**
     * Retrieves the author of the comment.
     *
     * @return The user who created the comment.
     */
    public User getAuthor() {
        return author;
    }

    /**
     * Retrieves the description of the comment.
     *
     * @return The content of the comment.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the current date and time.
     *
     * @return The current date and time in "yyyy/MM/dd HH:mm:ss" format.
     */
    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date currentDate = new Date();
        return dateFormat.format(currentDate);
    }

    /**
     * Retrieves the date and time the comment was created.
     *
     * @return The date and time of comment creation.
     */
    public String getDate() {
        return date;
    }

    /**
     * Retrieves the list of replies to this comment.
     *
     * @return The list of replies to this comment.
     */
    public ArrayList<Comment> getReplies() {
        return replies;
    }

    public String toString() {
        String ret =  author + " " + date + "\n" + description;
        return ret;
    }
}