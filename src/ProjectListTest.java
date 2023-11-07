import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ProjectListTest {
    private ProjectList projectList = ProjectList.getInstance();
    private ArrayList<Project> projects = projectList.getProjects();

    @BeforeEach
    public void setup() {
        projects.clear();
        User testUser = new User("Test", "User", "uname", "password123#");
        projects.add(new Project("New Project 1", testUser));
        projects.add(new Project("New Project 2", testUser));
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
        Project p = projectList.getProject("New Project 1");
        assertNotNull(p);
    }

    @Test
    public void testGetProjectValidSecondItem() {
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


}