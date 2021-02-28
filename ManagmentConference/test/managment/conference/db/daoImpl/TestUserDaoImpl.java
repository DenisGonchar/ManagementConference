package managment.conference.db.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import manegment.conference.entity.User;

class TestUserDaoImpl {
	
	UserDaoImpl userDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		userDaoImpl = new UserDaoImpl();
	}

	@Test
	void testGetAllUsers() {
		try {
			List<User> users = userDaoImpl.getAllUsers();
			List<User> users1 = userDaoImpl.getAllUsers();
			assertTrue(users.size() == users1.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testGetAllSpeakers() {
		try {
			List<User> speakers = userDaoImpl.getAllSpeakers();
			List<User> speakers1 = userDaoImpl.getAllSpeakers();
			assertTrue(speakers.size() == speakers1.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testCheckUser() {
		try {
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			User user1 = new User("TestUserForTest1", "22222", "test@test", "user");
			userDaoImpl.addUser(user);
			userDaoImpl.addUser(user1);
			assertTrue(userDaoImpl.checkUser(user) != userDaoImpl.checkUser(user1));
			userDaoImpl.removeUser(user);
			userDaoImpl.removeUser(user1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testAddUser() {
		try {
			List<User> usersBefore = userDaoImpl.getAllUsers();
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			userDaoImpl.addUser(user);
			List<User> usersAfter = userDaoImpl.getAllUsers();
			assertTrue(usersBefore.size() < usersAfter.size());
			userDaoImpl.removeUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testRemoveUser() {
		try {
			List<User> usersBefore = userDaoImpl.getAllUsers();
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			userDaoImpl.addUser(user);
			List<User> usersAfter = userDaoImpl.getAllUsers();
			userDaoImpl.removeUser(user);
			assertTrue(usersBefore.size() == usersAfter.size());
			userDaoImpl.removeUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testCheckLoginEmail() {
		try {
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			userDaoImpl.addUser(user);
			assertTrue(userDaoImpl.checkLoginEmail(user.getLogin(), user.getEmail()));
			userDaoImpl.removeUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testGetUserByLogin() {
		try {
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			userDaoImpl.addUser(user);
			assertEquals(userDaoImpl.getUserByLogin("TestUserForTest"), user);
			userDaoImpl.removeUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testSetRolle() {
		try {
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			userDaoImpl.addUser(user);
			userDaoImpl.setRolle(user, "speaker");
			assertEquals(user.getRolle(), "speaker");
			userDaoImpl.removeUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
