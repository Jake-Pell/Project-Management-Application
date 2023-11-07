import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ProjectListTest {
    private ProjectList projectList = ProjectList.getInstance();
    private ArrayList<Project> projects = projectList.getProjects();
    private User testUser = new User("Test", "User", "uname", "password123#");
    private User testUser2 = new User("Test", "User", "uname2", "password123#");

    @BeforeEach
    public void setup() {
        projects.clear();
        projects.add(new Project("New Project 1", testUser));
        projects.add(new Project("New Project 2", testUser));
        projects.add(new Project("New Project 1", testUser2));
        DataWriter.saveProjects();
    }

    @AfterEach
    public void tearDown() {
        ProjectList.getInstance().getProjects().clear();
        DataWriter.saveProjects();
    }

    // tests for getProject
    @Test
    public void testGetProjectValidFirstItem() {
        Project p = projectList.getProject("New Project 2");
        assertNotNull(p);
    }

    @Test
    public void testGetProjectInvaidName() {
        Project p = projectList.getProject("Incorrect Name");
        assertNull(p);
    }

    @Test
    public void testGetProjectEmptyName() {
        Project p = projectList.getProject("");
        assertNull(p);
    }

    @Test 
    public void testGetProjectNullName() {
        Project p = projectList.getProject(null);
        assertNull(p);
    }

    @Test
    public void testGetProjectDuplicateName() {
        Project p = projectList.getProject("New Project 1");
        assertEquals(p, projects.get(2));
    }

    // tests for addProject
    @Test
    public void testAddProjectValid() {
        boolean projectAdded = projectList.addProject("New Project 3", testUser);
        assertTrue(projectAdded);
    }

    @Test
    public void testAddProjectNullAuthor() {
        boolean projectAdded = projectList.addProject("New Project 3", null);
        assertFalse(projectAdded);
    }

    @Test
    public void testAddProjectEmptyProjectName() {
        boolean projectAdded = projectList.addProject("", testUser);
        assertFalse(projectAdded);
    }

    @Test
    public void testAddProjectNullProjectName() {
        boolean projectAdded = projectList.addProject(null, testUser);
        assertFalse(projectAdded);
    }

    @Test
    public void testAddProjectDuplicateNameSameAuthor() {
        boolean projectAdded = projectList.addProject("New Project 2", testUser);
        assertFalse(projectAdded);
    }

    @Test
    public void testAddProjectDuplicateNameDifferentAuthor() {
        boolean projectAdded = projectList.addProject("New Project 2", testUser2);
        assertTrue(projectAdded);
    }


}