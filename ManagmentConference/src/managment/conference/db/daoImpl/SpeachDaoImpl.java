package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.classes.Conference;
import manegment.conference.classes.DBProperties;
import manegment.conference.classes.Speach;
import menegment.conference.db.dao.SpeachDao;

public class SpeachDaoImpl implements SpeachDao{
	private DBProperties dbproperties = new DBProperties();
	private List<Speach> speaches = new ArrayList<>();
	private String query;

	@Override
	public List<Speach> getAllSpeaches() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM speach";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		speaches.clear();
		while (rs.next()) {
			speaches.add(new Speach(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("interval"), 
					rs.getString("login"), rs.getString("code")));
		}
		dbproperties.closeDB();
		return speaches;
	}

	@Override
	public Speach checkSpeach(Speach speach) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM speach WHERE nameSpeach=? AND time=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		Speach u = null;
		if(rs.next()) {
			u = new Speach(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("interval"), 
					rs.getString("login"), rs.getString("code"));
		}
		dbproperties.closeDB();
		return u;
	}

	@Override
	public void addSpeach(Speach speach) throws ClassNotFoundException, SQLException {
		query = "INSERT INTO speach (nameSpeach, time, interval, login) VALUES (?, ?, ?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParametersToSpeach(speach.getNameSpeach(), speach.getTime(), speach.getInterval(), speach.getLogin());
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void removeSpeach(Speach speach) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateSpeach(Speach speach) {
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
	public List<Speach> getSpeachbyConference(Conference conference) throws ClassNotFoundException, SQLException {
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
			System.out.println(codesConfsSpeaches.get(i));
		}
		dbproperties.closeDB();
		return speaches;
	}

	@Override
	public Speach getSpeachByCode(String code) throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM speach WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParameterSpeachCode(code);
		ResultSet rs = dbproperties.createResult();
		rs.next();
		Speach speach = new Speach(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("interval"),
				rs.getString("login"), rs.getString("code"));
		dbproperties.closeDB();
		return speach;
	}

	@Override
	public List<Speach> getSpeachesByLogSpkr(String login) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM speach WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParameterSpeachCode(login);
		ResultSet rs = dbproperties.createResult();
		while (rs.next()) {
			speaches.add(new Speach(rs.getString("nameSpeach"), rs.getString("time"), rs.getString("interval"),
				rs.getString("login"), rs.getString("code")));
		}
		dbproperties.closeDB();
		return speaches;
	}

}
