package managment.conference.db.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import manegment.conference.entity.Conference;
import manegment.conference.entity.Speech;

class TestSpeechDaoImpl {
	
	SpeechDaoImpl speechDaoImpl;
	SpeechesConferenceDaoImpl speachesConferenceDaoImpl;
	ConferenceDaoImpl conferenceDaoImpl;
	@BeforeEach
	void setUp() throws Exception {
		speechDaoImpl = new SpeechDaoImpl();
		speachesConferenceDaoImpl = new SpeechesConferenceDaoImpl();
		conferenceDaoImpl = new ConferenceDaoImpl();
	}


	@Test
	void testGetAllSpeaches() {
		try {
			List<Speech> speeches = speechDaoImpl.getAllSpeaches();
			List<Speech> speeches1 = speechDaoImpl.getAllSpeaches();
			assertTrue(speeches.size() == speeches1.size());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testAddSpeach() {
		try {
			List<Speech> speechesBefore = speechDaoImpl.getAllSpeaches();
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			List<Speech> speechesAfter = speechDaoImpl.getAllSpeaches();
			assertTrue(speechesAfter.size() - speechesBefore.size() == 1);
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testGetSpeachbyConference() {
		try {
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			conferenceDaoImpl.addConference(conference);
			speachesConferenceDaoImpl.addSpeachConf("H10000", "C10000");
			assertTrue(speechDaoImpl.getSpeachbyConference(conference) == speech);
			speechDaoImpl.removeSpeech("H10000");
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
	void testGetSpeachByCode() {
		try {
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			assertEquals(speechDaoImpl.getSpeachByCode(speech.getCode()), "H10000");
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testGetSpeachesByLogSpkr() {
		try {
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			assertEquals(speechDaoImpl.getSpeachesByLogSpkr(speech.getLogin()), "freeSpeaker");
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testChangeLogin() {
		try {
			String oldLogin = "freeSpeaker";
			String newLogin = "Dmitriy";
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", oldLogin, "H10000");
			speechDaoImpl.changeLogin(oldLogin, newLogin, "H10000");
			speechDaoImpl.addSpeach(speech);
			assertEquals(speechDaoImpl.getSpeachesByLogSpkr(speech.getLogin()), newLogin);
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testChangeAllLogin() {
		try {
			String oldLogin = "freeSpeaker";
			String newLogin = "Dmitriy";
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", oldLogin, "H10000");
			speechDaoImpl.addSpeach(speech);
			speechDaoImpl.changeAllLogin(oldLogin, newLogin);
			assertEquals(speechDaoImpl.getSpeachesByLogSpkr(speech.getLogin()), newLogin);
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testRemoveSpeech() {
		try {
			List<Speech> speechesBefore = speechDaoImpl.getAllSpeaches();
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			List<Speech> speechesAfter = speechDaoImpl.getAllSpeaches();
			speechDaoImpl.removeSpeech("H10000");
			assertTrue(speechesAfter.size() - speechesBefore.size() == 0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testChangeTopic() {
		try {
			String oldTipic = "TestAddSpeech";
			String newTopic = "TestAddSpeech1";
			Speech speech = new Speech(oldTipic, "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			speechDaoImpl.changeTopic(newTopic, "H10000");
			assertTrue(speech.getNameSpeach().equals(newTopic));
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	
	@Test
	void testChangeParamSpeech() {
		try {
			String oldTipic = "TestAddSpeech";
			String newTopic = "TestAddSpeech1";
			Speech speech = new Speech(oldTipic, "15:00:00", "20", "freeSpeaker", "H10000");
			speechDaoImpl.addSpeach(speech);
			speechDaoImpl.changeParamSpeech(newTopic, "15:00:00", "20", "freeSpeaker", "H10000");
			assertTrue(speech.getNameSpeach().equals(newTopic));
			speechDaoImpl.removeSpeech("H10000");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
		}
	}
	

}
