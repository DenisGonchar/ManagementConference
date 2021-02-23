package managment.conference.db.daoImpl;

import java.sql.SQLException;

import manegment.conference.classes.DBProperties;
import menegment.conference.db.dao.SpeachesConferenceDao;

public class SpeachesConferenceDaoImpl implements SpeachesConferenceDao{
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

}
