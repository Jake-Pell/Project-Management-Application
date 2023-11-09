import org.junit.jupiter.api.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProjectApplicationTest {
    private ProjectApplication projectApp;
    private User user;
    private Project project;

    @BeforeEach
    void setUp() {
        projectApp = new ProjectApplication();
        user = new User("JohnDoe", "password", "John", "Doe");
        project = new Project("Sample Project", user);
    }

    @Test
    void testLogin() {
        assertTrue(projectApp.signUp("John", "Doe", "JohnDoe", "password"));
        assertTrue(projectApp.login("JohnDoe", "password"));
    }

    @Test
    void testSignUp() {
        assertTrue(projectApp.signUp("John", "Doe", "JohnDoe", "password"));
    }

    @Test
    void testAddProject() {
        projectApp.setCurrentUser(user);
        assertTrue(projectApp.addProject("New Project"));
        assertEquals("New Project", projectApp.getCurrentProject().getName());
    }

    @Test
    void testEditProjectName() {
        projectApp.setCurrentUser(user);
        projectApp.addProject("New Project");
        assertTrue(projectApp.editProjectName("Updated Project"));
        assertEquals("Updated Project", projectApp.getCurrentProject().getName());
    }

    // Add more test cases for other methods in ProjectApplication class...
}

