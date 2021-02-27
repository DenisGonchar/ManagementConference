package managment.conference.db.daoImpl;

import java.sql.SQLException;

import manegment.conference.classes.DBProperties;
import menegment.conference.db.dao.SpeechesConferenceDao;

public class SpeechesConferenceDaoImpl implements SpeechesConferenceDao{
	private DBProperties dbproperties = new DBProperties();
	private String quary;

	@Override
	public void delSpeachConfByCodeSpeach(String codeSpeach) throws SQLException, ClassNotFoundException {
		quary = "DELETE FROM speachesconference WHERE codeSpeach =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setDelParameters(codeSpeach);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void addSpeachConf(String codeSpeach, String codeConf) throws SQLException, ClassNotFoundException {
		quary = "INSERT INTO speachesconference (codeConf, codeSpeach) VALUES (?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setAddSpeachConfParameters(codeConf, codeSpeach);
		dbproperties.updateResult();
		dbproperties.closeDB();
	}

}
