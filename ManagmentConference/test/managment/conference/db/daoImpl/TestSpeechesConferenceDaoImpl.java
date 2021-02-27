package managment.conference.db.daoImpl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		fail("Not yet implemented");
	}

	@Test
	void testAddSpeachConf() {
		fail("Not yet implemented");
	}

}
