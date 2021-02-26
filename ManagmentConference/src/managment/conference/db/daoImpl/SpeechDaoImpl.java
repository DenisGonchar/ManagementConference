package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.classes.Conference;
import manegment.conference.classes.DBProperties;
import manegment.conference.classes.Speech;
import menegment.conference.db.dao.SpeechDao;

public class SpeechDaoImpl implements SpeechDao{
	private DBProperties dbproperties = new DBProperties();
	private List<Speech> speaches = new ArrayList<>();
	private String query;

	@Override
	public List<Speech> getAllSpeaches() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM speach ORDER BY code ASC";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		speaches.clear();
		while (rs.next()) {
			speaches.add(new Speech(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("intervals"), 
					rs.getString("login"), rs.getString("code")));
		}
		dbproperties.closeDB();
		return speaches;
	}

	@Override
	public Speech checkSpeach(Speech speach) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM speach WHERE nameSpeach=? AND time=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		Speech u = null;
		if(rs.next()) {
			u = new Speech(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("intervals"), 
					rs.getString("login"), rs.getString("code"));
		}
		dbproperties.closeDB();
		return u;
	}

	@Override
	public void addSpeach(Speech speach) throws ClassNotFoundException, SQLException {
		query = "INSERT INTO speach (nameSpeach, time, intervals, login, code) VALUES (?, ?, ?, ?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParametersToSpeach(speach.getNameSpeach(), speach.getTime(), speach.getInterval(), speach.getLogin(), speach.getCode());
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void updateSpeach(Speech speach) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkSpeachNameTime(String nameSpeach, String time, String interval, String login) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM conference WHERE nameSpeach=? OR time=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setCheckParametersForSpeach(nameSpeach, time);
		ResultSet rs = dbproperties.createResult();
		return rs.next()?true:false;
	}

	@Override
	public List<Speech> getSpeachbyConference(Conference conference) throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM speachesconference WHERE codeConf =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParametersCodesSpeaches(conference);
		ResultSet rs = dbproperties.createResult();
		List<String> codesConfsSpeaches = new ArrayList<String>();
		while (rs.next()) {
			codesConfsSpeaches.add(rs.getString("codeSpeach"));
		}
		speaches.clear();
		for (int i = 0; i < codesConfsSpeaches.size(); i++) {
			speaches.add(getSpeachByCode(codesConfsSpeaches.get(i)));
		}
		dbproperties.closeDB();
		return speaches;
	}

	@Override
	public Speech getSpeachByCode(String code) throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM speach WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParameterSpeachCode(code);
		ResultSet rs = dbproperties.createResult();
		rs.next();
		Speech speach = new Speech(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("intervals"),
				rs.getString("login"), rs.getString("code"));
		dbproperties.closeDB();
		return speach;
	}

	@Override
	public List<Speech> getSpeachesByLogSpkr(String login) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM speach WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParameterSpeachCode(login);
		ResultSet rs = dbproperties.createResult();
		while (rs.next()) {
			speaches.add(new Speech(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("intervals"),
				rs.getString("login"), rs.getString("code")));
		}
		dbproperties.closeDB();
		return speaches;
	}

	@Override
	public void changeLogin(String oldlogin, String newLogin, String code) throws SQLException, ClassNotFoundException {
		query = "UPDATE speach SET login=? WHERE login =? AND code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setUpdateParametersChangeLogin(oldlogin, newLogin, code);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	@Override
	public void changeAllLogin(String oldlogin, String newLogin) throws SQLException, ClassNotFoundException {
		query = "UPDATE speach SET login=? WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setUpdateParametersChangeTopic(oldlogin, newLogin);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	@Override
	public void removeSpeech(String code) throws SQLException, ClassNotFoundException {
		query = "DELETE FROM speach WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParametersDelSpeech(code);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	@Override
	public void changeTopic(String nameSpeach, String code) throws SQLException, ClassNotFoundException {
		query = "UPDATE speach SET nameSpeach=? WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setUpdateParametersChangeTopic(nameSpeach, code);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	@Override
	public void changeParamSpeech(String nameSpeach, String time, String interval, String login, String code) throws SQLException, ClassNotFoundException {
		query = "UPDATE speach SET nameSpeach=?, time=?, intervals=?, login=? WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setUpdateAllParametersSpeech(nameSpeach, time, interval, login, code);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

}
