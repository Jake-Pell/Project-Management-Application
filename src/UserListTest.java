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
        users.add(new User("Jake", "Pell", "pellj", "p@ssword123"));
        users.add(new User("John", "Smith", "jimmyjohn", "hello82741*"));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    // tests for getUser(String username)
    @Test
    void testGetUserValidUsernameFirstItem() {
        User jake = userList.getUser("pellj");
        assertNotNull(jake);
    }

    @Test
    void testGetUserValidUsernameSecondItem() {
        User john = userList.getUser("jimmyjohn");
        assertNotNull(john);
    }

    @Test
    void testGetUserInvalidUsername() {
        User user = userList.getUser("steve");
        assertNull(user);
    }

    @Test
    void testGetUserEmptyUsername() {
        User user = userList.getUser("");
        assertNull(user);
    }

    @Test
    void testGetUserNullUsername() {
        User user = userList.getUser(null);
        assertNull(user);
    }

    // tests for getUser(String username, String password)
    @Test
    void testGetUserValidUsernameAndPasswordFirstItem() {
        User jake = userList.getUser("pellj");
        assertNotNull(jake);
    }

    @Test
    void testGetUserValidUsernameAndPasswordSecondItem() {
        User john = userList.getUser("jimmyjohn");
        assertNotNull(john);
    }

    @Test
    void testGetUserInvalidUsernameAndPassword() {
        User user = userList.getUser("steve", "pass");
        assertNull(user);
    }

    @Test
    void testGetUserInvalidPassword() {
        User user = userList.getUser("pellj", "123");
        assertNull(user);
    }

    @Test
    void testGetUserEmptyPassword() {
        User user = userList.getUser("pellj", "");
        assertNull(user);
    }

    @Test
    void testGetUserNullPassword() {
        User user = userList.getUser("pellj", null);
        assertNull(user);
    }

    // tests for addUser()
    @Test
    void testAddUserValid() {
        boolean userAdded = userList.addUser("Steve", "Stevenson", "stevesteven", "SecurePassword123*");
        assertTrue(userAdded);
    }

    @Test 
    void testAddUserUsernameTaken() {
        boolean userAdded = userList.addUser("Steve", "Stevenson", "pellj", "SecurePassword123*");
        assertFalse(userAdded);
    }

    @Test 
    void testAddUserUsernameTooShort() {
        boolean userAdded = userList.addUser("Steve", "Stevenson", "s", "SecurePassword123*");
        assertFalse(userAdded);
    }

    @Test 
    void testAddUserParametersEmpty() {
        boolean userAdded = userList.addUser("", "", "", "");
        assertFalse(userAdded);
    }

    @Test 
    void testAddUserParametersNull() {
        boolean userAdded = userList.addUser(null, null, null, null);
        assertFalse(userAdded);
    }

    @Test 
    void testAddUserPasswordTooShort() {
        boolean userAdded = userList.addUser("Steve", "Stevenson", "stevesteven", "a1*");
        assertFalse(userAdded);
    }

    @Test 
    void testAddUserPasswordNoNumber() {
        boolean userAdded = userList.addUser("Steve", "Stevenson", "stevesteven", "password!");
        assertFalse(userAdded);
    }

    @Test 
    void testAddUserPasswordNoSpecialCharacter() {
        boolean userAdded = userList.addUser("Steve", "Stevenson", "stevesteven", "password123");
        assertFalse(userAdded);
    }

}