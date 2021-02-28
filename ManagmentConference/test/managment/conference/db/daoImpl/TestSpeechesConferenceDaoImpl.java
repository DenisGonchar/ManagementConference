package managment.conference.db.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import manegment.conference.entity.Conference;
import manegment.conference.entity.Speech;

class TestSpeechesConferenceDaoImpl {

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
	void testDelSpeachConfByCodeSpeach() {
		try {
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			speechDaoImpl.addSpeach(speech);
			conferenceDaoImpl.addConference(conference);
			speachesConferenceDaoImpl.addSpeachConf(speech.getCode(), conference.getCode());
			speachesConferenceDaoImpl.delSpeachConfByCodeSpeach(speech.getCode());
			assertTrue(speechDaoImpl.getSpeachByCode(conference.getCode()) == null);
			speechDaoImpl.removeSpeech(speech.getCode());
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
	void testAddSpeachConf() {
		try {
			Speech speech = new Speech("TestAddSpeech", "15:00:00", "20", "freeSpeaker", "H10000");
			Conference conference = new Conference("NewTestConf", "Here", "01.02.2021", "13:00:00", "C10000");
			speechDaoImpl.addSpeach(speech);
			conferenceDaoImpl.addConference(conference);
			speachesConferenceDaoImpl.addSpeachConf(speech.getCode(), conference.getCode());
			assertEquals(speechDaoImpl.getSpeachByCode(conference.getCode()), speech);
			speechDaoImpl.removeSpeech(speech.getCode());
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
