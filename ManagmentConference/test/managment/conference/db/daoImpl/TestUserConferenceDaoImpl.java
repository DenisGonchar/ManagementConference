package managment.conference.db.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import manegment.conference.entity.Conference;
import manegment.conference.entity.User;

class TestUserConferenceDaoImpl {

	SpeechDaoImpl speechDaoImpl;
	SpeechesConferenceDaoImpl speachesConferenceDaoImpl;
	ConferenceDaoImpl conferenceDaoImpl;
	UserConferenceDaoImpl userConferenceDaoImpl;
	UserDaoImpl userDaoImpl;
	
	@BeforeEach
	void setUp() throws Exception {
		speechDaoImpl = new SpeechDaoImpl();
		speachesConferenceDaoImpl = new SpeechesConferenceDaoImpl();
		conferenceDaoImpl = new ConferenceDaoImpl();
		userConferenceDaoImpl = new UserConferenceDaoImpl();
		userDaoImpl = new UserDaoImpl();
	}

	@Test
	void testCheckUser() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			conferenceDaoImpl.addConference(conference);
			userDaoImpl.addUser(user);
			userConferenceDaoImpl.regUser(user, conference.getCode());
			assertTrue(userConferenceDaoImpl.checkUser(user, conference.getCode()));
			conferenceDaoImpl.removeConference(conference);
			userDaoImpl.removeUser(user);
			userConferenceDaoImpl.delUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testGetUsersByCode() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			conferenceDaoImpl.addConference(conference);
			userDaoImpl.addUser(user);
			userConferenceDaoImpl.regUser(user, conference.getCode());
			List<User> users = userConferenceDaoImpl.getUsersByCode(conference.getCode());
			assertTrue(users.size() == 1);
			conferenceDaoImpl.removeConference(conference);
			userDaoImpl.removeUser(user);
			userConferenceDaoImpl.delUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testRegUser() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			conferenceDaoImpl.addConference(conference);
			userDaoImpl.addUser(user);
			userConferenceDaoImpl.regUser(user, conference.getCode());
			List<User> users = userConferenceDaoImpl.getUsersByCode(conference.getCode());
			assertTrue(users.size() == 1);
			conferenceDaoImpl.removeConference(conference);
			userDaoImpl.removeUser(user);
			userConferenceDaoImpl.delUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testUnRegUser() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			conferenceDaoImpl.addConference(conference);
			userDaoImpl.addUser(user);
			userConferenceDaoImpl.regUser(user, conference.getCode());
			List<User> users = userConferenceDaoImpl.getUsersByCode(conference.getCode());
			userConferenceDaoImpl.unRegUser(user, conference.getCode());
			List<User> users1 = userConferenceDaoImpl.getUsersByCode(conference.getCode());
			assertTrue(users.size() > users1.size());
			conferenceDaoImpl.removeConference(conference);
			userDaoImpl.removeUser(user);
			userConferenceDaoImpl.delUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testDelUser() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			User user = new User("TestUserForTest", "11111", "test@test", "user");
			conferenceDaoImpl.addConference(conference);
			userDaoImpl.addUser(user);
			userConferenceDaoImpl.regUser(user, conference.getCode());
			List<User> users = userConferenceDaoImpl.getUsersByCode(conference.getCode());
			userConferenceDaoImpl.delUser(user);
			List<User> users1 = userConferenceDaoImpl.getUsersByCode(conference.getCode());
			assertTrue(users.size() > users1.size());
			conferenceDaoImpl.removeConference(conference);
			userDaoImpl.removeUser(user);
			userConferenceDaoImpl.delUser(user);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
