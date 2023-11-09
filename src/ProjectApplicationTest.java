import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProjectApplicationTest {
    private ProjectApplication projectApp;
    private User user;
    private Project project;



    @Test
   public void testLogin() {
        assertTrue(projectApp.signUp("John", "Doe", "JohnDoe", "password"));
        assertTrue(projectApp.login("JohnDoe", "password"));
    }

    @Test
    void testSignUp() {
        assertTrue(projectApp.signUp("John", "Doe", "JohnDoe", "password"));
    }

 

    // Add more test cases for other methods in ProjectApplication class...
}