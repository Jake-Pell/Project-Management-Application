import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class CommentTest {

    private Column column;
    private User user;
    private Comment comment;
    
    @BeforeEach
    public void setUp() {
        // Initialize a Task, User, and Comment for testing
        comment = new Comment(user, "asd");
        user = new User("sds","asdd","asdsas","asdasd");
    @Test
    void testAddReply() {
        assertEquals("To Do", column.getName());
        assertEquals(0, column.getTasks().size());

    }

    @Test
    void testGetAuthor() {

    }

    @Test
    void testGetCurrentDate() {
        a

    }

    @Test
    void testGetDate() {

    }

    @Test
    void testGetDescription() {

    }

    @Test
    void testGetReplies() {

    }

    @Test
    void testToString() {

    }
}
}