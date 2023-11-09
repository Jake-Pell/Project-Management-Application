import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	private UserList user = UserList.getInstance();
	private ArrayList<User> userList = user.getUsers();
	
	@BeforeEach
	public void setup() {
		user.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	@AfterEach
	public void tearDown() {
		user.getInstance().getUsers().clear();
		DataWriter.saveUsers();
	}
	
	
	@Test
	void testWritingZeroUsers() {
		userList = DataLoader.getUsers();
		assertEquals(0, userList.size());
	}

	@Test
	void testWritingOneUser() {
		userList.add(new User("asmith", "Amy", "Smith", "passwrod123!"));
		DataWriter.saveUsers();
		assertEquals("asmith", DataLoader.getUsers().get(0).getUsername());
	}
	
	@Test
	void testWritingFiveUsers() {
		userList.add(new User("asmith", "Amy", "Smith", "passwrod123!"));
		userList.add(new User("asmith", "Amy", "Smith", "passwrod123!"));
		userList.add(new User("asmith", "Amy", "Smith", "passwrod123!"));
		userList.add(new User("asmith", "Amy", "Smith", "passwrod123!"));
		userList.add(new User("asmith", "Amy", "Smith", "passwrod123!"));
		DataWriter.saveUsers();
		assertEquals("esmith", DataLoader.getUsers().get(4).getUsername());
	}
	
	@Test
	void testWritingEmptyUser() {
		userList.add(new User("", "", "", ""));
		DataWriter.saveUsers();
		assertEquals("", DataLoader.getUsers().get(0).getUsername());
	}
	
	@Test
	void testWritingNullUser() {
		userList.add(new User(null, "", "", ""));
		DataWriter.saveUsers();
		assertEquals(null, DataLoader.getUsers().get(0).getUsername());
	}
	
}