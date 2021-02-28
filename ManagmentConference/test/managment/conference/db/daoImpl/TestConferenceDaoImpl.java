package managment.conference.db.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import manegment.conference.entity.Conference;

class TestConferenceDaoImpl {

	ConferenceDaoImpl conferenceDaoImpl;

	@BeforeEach
	void setUp() throws Exception {
		conferenceDaoImpl = new ConferenceDaoImpl();
	}

	@Test
	void testGetAllConferences() {
		try {
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			List<Conference> conferences1 = conferenceDaoImpl.getAllConferences();
			assertTrue(conferences.size() == conferences1.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}


	@Test
	void testAddConference() {
		try {
			List<Conference> conferencesBefore = conferenceDaoImpl.getAllConferences();
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			conferenceDaoImpl.addConference(conference);
			List<Conference> conferencesAfter = conferenceDaoImpl.getAllConferences();
			assertTrue(conferencesBefore.size() < conferencesAfter.size());
			conferenceDaoImpl.removeConference(conference);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testRemoveConference() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			conferenceDaoImpl.addConference(conference);
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			conferenceDaoImpl.removeConference(conference);
			assertTrue(conferences.size() == 6);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

	@Test
	void testUpdateConference() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			conferenceDaoImpl.addConference(conference);
			conference.setNameConf("NewTestConf1");
			conferenceDaoImpl.updateConference(conference);
			List<Conference> conferences = conferenceDaoImpl.getAllConferences();
			for (int i = 0; i < conferences.size(); i++) {
				if(conferences.get(i).getCode().equals(conference.getCode())) {
					conference = conferences.get(i);
					break;
				}
			}
			assertTrue(conference.getNameConf().equals("NewTestConf1"));
			conferenceDaoImpl.removeConference(conference);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}

}
