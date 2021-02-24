package menegment.conference.db.dao;

import java.sql.SQLException;

public interface SpeachesConferenceDao {
	public void delSpeachConfByCodeSpeach(String codeSpeach) throws SQLException, ClassNotFoundException;
	public void addSpeachConf(String codeSpeach, String codeConf) throws SQLException, ClassNotFoundException;
}
