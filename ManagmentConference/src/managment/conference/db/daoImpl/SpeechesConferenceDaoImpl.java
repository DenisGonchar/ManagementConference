package managment.conference.db.daoImpl;

import java.sql.SQLException;

import manegment.conference.entity.DBProperties;
import menegment.conference.db.dao.SpeechesConferenceDao;

public class SpeechesConferenceDaoImpl implements SpeechesConferenceDao{
	private DBProperties dbproperties = new DBProperties();
	private String query;

	@Override
	public void delSpeachConfByCodeSpeach(String codeSpeach) throws SQLException, ClassNotFoundException {
		query = "DELETE FROM speachesconference WHERE codeSpeach =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setDelParameters(codeSpeach);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void addSpeachConf(String codeSpeach, String codeConf) throws SQLException, ClassNotFoundException {
		query = "INSERT INTO speachesconference (codeConf, codeSpeach) VALUES (?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddSpeachConfParameters(codeConf, codeSpeach);
		dbproperties.updateResult();
		dbproperties.closeDB();
	}

}
