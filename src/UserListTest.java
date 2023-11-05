import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class UserListTest {
    private UserList userList = UserList.getInstance();
    private ArrayList<User> users = userList.getUsers();

    @BeforeEach
    public void setup() {
        users.clear();
        users.add(new User("Jake", "Pell", "pellj", "password123"));
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }
    @Test
    public void addingUser(){
        // Checking for null, empty and space
        String[] falseArray= {null, "","Name With space"};

        for ( String name : falseArray){
            assertEquals(false, userList.addUser(
            name, "goodLast", "newUser", "legitpass"));
        }
        
        String[] trueArray = {"goodName", "SpaceFree"};
        for (String name: trueArray){
            assertEquals(true, userList.addUser(name, "sdf" ,"sdfd" ,"sdf"));
        }
    } 
}