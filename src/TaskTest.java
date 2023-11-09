import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class TaskTest {

    private Task task;
    private User user;
    private Comment comment;

    @BeforeEach
    public void setUp() {
        // Initialize a Task, User, and Comment for testing
        task = new Task("Sample Task", "Description", 1);
        user = new User("sds","asdd","asdsas","asdasd");
        comment = new Comment(user, "Test Comment");
    }

    @Test
    public void testAssignUser() {
        assertTrue(task.assignUser(user), "User should be assigned to the task");
        assertTrue(task.getUsers().contains(user), "User should be in the assigned users list");
    }

    @Test
    public void testRemoveUser() {
        task.assignUser(user);
        User removedUser = task.removeUser(user);
        assertNull(task.getComment(user.getUsername(), comment.getDescription()), "User should be removed from the task");
        assertEquals(user, removedUser, "Removed user should be the same as the assigned user");
    }

    @Test
    public void testAddComment() {
        assertTrue(task.addComment(user, comment.getDescription()), "Comment should be added to the task");
        Comment addedComment = task.getComment(user.getUsername(), comment.getDescription());
        assertNotNull(addedComment, "Comment should be found in the task's comments");
        assertEquals(user, addedComment.getAuthor(), "Author of the comment should match the user");
    }

    @Test
    public void testSetTaskName() {
        assertTrue(task.setTaskName("Updated Task Name"), "Task name should be updated");
        assertEquals("Updated Task Name", task.getTaskName(), "Task name should be changed");
        assertFalse(task.setTaskName(""), "Empty task name should not be set");
        assertEquals("Updated Task Name", task.getTaskName(), "Task name should remain unchanged");
    }

    @Test
    public void testSetPriority() {
        assertTrue(task.setPriority(2), "Priority should be updated");
        assertEquals(2, task.getPriority(), "Priority should be changed");
        assertFalse(task.setPriority(-1), "Negative priority should not be set");
        assertEquals(2, task.getPriority(), "Priority should remain unchanged");
    }

    @Test
    public void testSetDescription() {
        assertTrue(task.setDescription("Updated Description"), "Description should be updated");
        assertEquals("Updated Description", task.getDescription(), "Description should be changed");
        assertFalse(task.setDescription(""), "Empty description should not be set");
        assertEquals("Updated Description", task.getDescription(), "Description should remain unchanged");
    }

    @Test
    public void testGetComment() {
        task.addComment(user, comment.getDescription());
        Comment foundComment = task.getComment(user.getUsername(), comment.getDescription());
        assertNotNull(foundComment, "Comment should be found in the task's comments");
        assertEquals(user.getUsername(), foundComment.getAuthor().getUsername(), "Author of the comment should match the user's username");
        assertEquals(comment.getDescription(), foundComment.getDescription(), "Description of the comment should match");
    }
}

