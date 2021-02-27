package menegment.conference.db.dao;

import java.sql.SQLException;

public interface SpeechesConferenceDao {
	public void delSpeachConfByCodeSpeach(String codeSpeach) throws SQLException, ClassNotFoundException;
	public void addSpeachConf(String codeSpeach, String codeConf) throws SQLException, ClassNotFoundException;
}
