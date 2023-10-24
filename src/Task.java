import java.util.ArrayList;
import java.util.UUID;

public class Task {
    private UUID id;
    private String taskName;
    private int priority;
    private String description;
    private ArrayList<User> users;
    private ArrayList<History> columns;
    private ArrayList<Comment> comments;

  public Task(String taskname, String description, int priority){
    id = UUID.randomUUID();
  }
  

  public boolean changeName(String taskName){
    if(!taskName.isEmpty()){
      this.taskName = taskName;
      return true;
    }else{
      return false;
    }
  }

  public UUID getID() {
    return id;
  }
 
  public ArrayList<User> setAssignedUsers(){
      return null;
  }
  public boolean addComment(Comment comment){
    return comments.add(comment);
  }
  
  // Setters 
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }
  public void setPriority(int newPriority){
    this.priority = newPriority;
  }

  public void setDescription(String description) {
    this.description = description;
  }



  
}
