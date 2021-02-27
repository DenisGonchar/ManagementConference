package menegment.conference.db.dao;

import java.sql.SQLException;
import java.util.List;

import manegment.conference.classes.Conference;
import manegment.conference.classes.Speech;

public interface SpeechDao {
	public List<Speech> getAllSpeaches() throws ClassNotFoundException, SQLException;
	public void addSpeach(Speech speach) throws ClassNotFoundException, SQLException;
	public List<Speech> getSpeachbyConference(Conference conference) throws ClassNotFoundException, SQLException;
	public Speech getSpeachByCode(String code) throws ClassNotFoundException, SQLException;
	public List<Speech> getSpeachesByLogSpkr(String login) throws SQLException, ClassNotFoundException;
	public void changeLogin(String oldlogin, String newLogin, String code) throws SQLException, ClassNotFoundException;
	public void changeTopic(String nameSpeach, String code) throws SQLException, ClassNotFoundException;
	public void changeParamSpeech(String nameSpeach, String time, String interval, String login, String code) throws SQLException, ClassNotFoundException;
	void removeSpeech(String code) throws SQLException, ClassNotFoundException;
	void changeAllLogin(String oldlogin, String newLogin) throws SQLException, ClassNotFoundException;
}
