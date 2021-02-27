package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.classes.Conference;
import manegment.conference.classes.DBProperties;
import menegment.conference.db.dao.ConferenceDao;

public class ConferenceDaoImpl implements ConferenceDao {
	private DBProperties dbproperties = new DBProperties();
	private List<Conference> conferences = new ArrayList<>();
	private String quary;

	@Override
	public List<Conference> getAllConferences() throws ClassNotFoundException, SQLException{
		quary = "SELECT * FROM conference";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		ResultSet rs = dbproperties.createResult();
		conferences.clear();
		while (rs.next()) {
			conferences.add(new Conference(rs.getString("nameConf"), rs.getString("place"), rs.getString("date"), 
					rs.getString("time"), rs.getString("code")));
		}
		dbproperties.closeDB();
		return conferences;
	}


	@Override
	public void addConference(Conference conference) throws ClassNotFoundException, SQLException {
		quary = "INSERT INTO conference (nameConf, place, date, time, code) VALUES (?, ?, ?, ?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setAddParametersToConference(conference.getNameConf(), conference.getPlace(), conference.getDate(), conference.getTime(), conference.getCode());
		dbproperties.updateResult();
		dbproperties.closeDB();
	}


	@Override
	public void removeConference(Conference conference) throws SQLException, ClassNotFoundException {
		quary = "DELETE FROM conference WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setDelParameters(conference.getCode());
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void updateConference(Conference conference) throws SQLException, ClassNotFoundException {
		quary = "UPDATE conference SET nameConf=?, place=?, date=?, time=? WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setUpdateParameters(conference);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}


}
