package menegment.conference.db.dao;

import java.sql.SQLException;
import java.util.List;

import manegment.conference.classes.Conference;

public interface ConferenceDao {
	public List<Conference> getAllConferences() throws ClassNotFoundException, SQLException;
	public void addConference(Conference conference) throws ClassNotFoundException, SQLException;
	public void removeConference(Conference conference) throws SQLException, ClassNotFoundException;
	public void updateConference(Conference conference) throws SQLException, ClassNotFoundException;
}
