package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.entity.Conference;
import manegment.conference.entity.DBProperties;
import menegment.conference.db.dao.ConferenceDao;

public class ConferenceDaoImpl implements ConferenceDao {
	private DBProperties dbproperties = new DBProperties();
	private List<Conference> conferences = new ArrayList<>();
	private String query;
	
	/**
	 * 
	 */
	@Override
	public List<Conference> getAllConferences() throws ClassNotFoundException, SQLException{
		query = "SELECT * FROM conference";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
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
		query = "INSERT INTO conference (nameConf, place, date, time, code) VALUES (?, ?, ?, ?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParametersToConference(conference.getNameConf(), conference.getPlace(), conference.getDate(), conference.getTime(), conference.getCode());
		dbproperties.updateResult();
		dbproperties.closeDB();
	}


	@Override
	public void removeConference(Conference conference) throws SQLException, ClassNotFoundException {
		query = "DELETE FROM conference WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setDelParameters(conference.getCode());
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}

	@Override
	public void updateConference(Conference conference) throws SQLException, ClassNotFoundException {
		query = "UPDATE conference SET nameConf=?, place=?, date=?, time=? WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setUpdateParameters(conference);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}


}
