import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class ColumnTest {

    private Column column;
    private User user;
    private Task task;

    @BeforeEach
    public void setUp() {
        // Initialize a Task, User, and Comment for testing
        task = new Task("Sample Task", "Description", 1);
        user = new User("sds","asdd","asdsas","asdasd");
    }

    @Test
    void testAddTask() {
        Column column = new Column("To Do");
        assertTrue(column.addTask("Task 1", "Description for Task 1", 3));
        assertEquals(1, column.getTasks().size());
    }

    @Test
    void testAddTask2() {

        Column column = new Column("task2") ;

    }

  

    @Test
    void testGetTask() {
    column.addTask(task);
    assertEquals(task,column.getTasks());
    }

    @Test
    void testGetTasks() {

    }

    @Test
    void testHasTask() {
        column.addTask(task);
        assertTrue(column.hasTask(task));

    }

    @Test
    void testRemoveTask() {
       
   
    column.addTask(task);
    assertEquals(task,column.removeTask(task));
    assertEquals(0,column.getTasks().size());
    }

    

    @Test
    void testSetName() {

    }

    @Test
    void testToString() {
 Column column = new Column("To Do");
        Task task1 = new Task("Task 1", "Description for Task 1", 3);
        Task task2 = new Task("Task 2", "Description for Task 2", 2);

        column.addTask(task1);
        column.addTask(task2);

        String expectedString = "To Do:\n\nTask 1 (Priority: 3)\nAssigned Users: \nDescription: Description for Task 1\n\nTask 2 (Priority: 2)\nAssigned Users: \nDescription: Description for Task 2\n\n";

        assertEquals(expectedString, column.toString());
    }
}
