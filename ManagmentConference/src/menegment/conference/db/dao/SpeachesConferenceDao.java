package menegment.conference.db.dao;

import java.sql.SQLException;

public interface SpeachesConferenceDao {
	public void delSpeachConfByCodeSpeach(String codeSpeach) throws SQLException, ClassNotFoundException;
}
