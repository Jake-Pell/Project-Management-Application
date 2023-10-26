import java.util.ArrayList;
import java.util.UUID;

public class Task {
    private UUID id;
    private String taskName;
    private int priority;
    private String description;
    private ArrayList<User> users;
    private ArrayList<Comment> comments;

  public Task(String taskName, String description, int priority){
    id = UUID.randomUUID();
    this.taskName = taskName;
    this.description = description;
    this.priority = priority;
  }
  

  public UUID getID() {
    return id;
  }
 
  public ArrayList<User> setAssignedUsers(){
      return null;
  }
  public boolean addComment(User user, String description){
    Comment comment = new Comment(user, description);
    return comments.add(comment);
  }
  
  // Setters 
  public boolean setTaskName(String taskName) {
    if(!taskName.isEmpty()){
      this.taskName = taskName;
      return true;
    }else{
      return false;
    }
  }
  public boolean setPriority(int newPriority){
    if(priority >= 0){
      this.priority = newPriority;
      return true;
    }else {
      return false;
    }
  }

  public boolean setDescription(String description) {
    if(!description.isEmpty()){
      this.description = description;
      return true;
    }else {
      return false;
    }
  }

  // getters
  public String getName() {
    return taskName;
  }



  
}
