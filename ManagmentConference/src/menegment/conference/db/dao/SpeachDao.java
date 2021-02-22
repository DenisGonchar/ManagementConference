package menegment.conference.db.dao;

import java.sql.SQLException;
import java.util.List;

import manegment.conference.classes.Conference;
import manegment.conference.classes.Speach;

public interface SpeachDao {
	public List<Speach> getAllSpeaches() throws ClassNotFoundException, SQLException;
	public Speach checkSpeach(Speach speach) throws SQLException, ClassNotFoundException;
	public void addSpeach(Speach speach) throws ClassNotFoundException, SQLException;
	public void removeSpeach(Speach speach);
	public void updateSpeach(Speach speach);
	public boolean checkSpeachNameTime(String nameSpeach, String time, String interval, String login) throws SQLException, ClassNotFoundException;
	public List<Speach> getSpeachbyConference(Conference conference) throws ClassNotFoundException, SQLException;
	public Speach getSpeachByCode(String code) throws ClassNotFoundException, SQLException;
}
