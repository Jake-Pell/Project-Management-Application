import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	private User user = User.getInstance();
	private ArrayList<User> userList = user.getUsers();
	
	@BeforeEach
	public void setup() {
		User.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		User.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("asmith", "Amy", "Smith", 19, "803-454-3344"));
		DataWriter.saveUsers();
		assertEquals("asmith", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("asmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new User("bsmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new User("csmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new User("dsmith", "Amy", "Smith", 19, "803-454-3344"));
		userList.add(new User("esmith", "Amy", "Smith", 19, "803-454-3344"));
		DataWriter.saveUsers();
		assertEquals("esmith", DataLoader.getUsers().get(4).getUserName());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new User("", "", "", 0, ""));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getUserName());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new User(null, "", "", 0, ""));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.getUsers().get(0).getUserName());
	}
	
}