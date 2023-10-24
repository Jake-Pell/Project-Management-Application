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
  
  public void setDescription(String description){
  
  }
  public boolean changeName(String taskName){
    if(!taskName.isEmpty()){
      this.taskName = taskName;
      return true;
    }else{
      return false;
    }
  }
  public void setPriority(int newPriority){
  
  }
  public ArrayList<User> setAssignedUsers(){
      return null;
  }
  public void addComment(User author, String description)
  {
    
  }

  public UUID getID() {
    return id;
  }
  
}
