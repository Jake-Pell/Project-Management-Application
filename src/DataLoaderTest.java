import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class DataLoaderTest {
    private ArrayList<User> userList;

    @BeforeEach
    public void setup() {
        userList = DataLoader.getUsers();
        userList.add(new User("asmith", "Amy", "Smith", "19", "803-454-3344"));
        userList.add(new User("bwhite", "Bob", "White", "23", "803-333-3544"));
        DataWriter.saveUsers();
    }

    @AfterEach
    public void tearDown() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
    }

    @Test
    void testGetUsersSize() {
        userList = DataLoader.getUsers();
        assertEquals(2, userList.size());
    }

    @Test
    void testGetUsersSizeZero() {
        Users.getInstance().getUsers().clear();
        DataWriter.saveUsers();
        assertEquals(0, userList.size());
    }

    @Test
    void testGetUserFirstUserName() {
        userList = DataLoader.getUsers();
        assertEquals("asmith", userList.get(0).getUserName());
    }
}
