package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.entity.DBProperties;
import manegment.conference.entity.User;
import menegment.conference.db.dao.UserConferenceDao;

public class UserConferenceDaoImpl implements UserConferenceDao{
	private DBProperties dbproperties = new DBProperties();
	private List<User> users = new ArrayList<User>();
	private String query;
	
	@Override
	public boolean checkUser(User user, String code) throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM userConference WHERE login =? AND code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setCheckRegParameters(user.getLogin(), code);
		ResultSet rs = dbproperties.createResult();
		if(rs.next()){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public List<User> getUsersByCode (String code) throws ClassNotFoundException, SQLException {
		query = "SELECT login FROM userConference WHERE code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParametersFromUserConference(code);
		ResultSet rs = dbproperties.createResult();
		users.clear();
		UserDaoImpl userDaoImpl = new UserDaoImpl();
		while (rs.next()) {
			String login = rs.getString("login");
			users.add(userDaoImpl.getUserByLogin(login));
		}
		return users;
	}

	@Override
	public void regUser(User user, String code) throws SQLException, ClassNotFoundException {
		query = "INSERT INTO userConference (login, code) VALUES (?, ?)";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParametersToRegUserConference(user.getLogin(), code);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	@Override
	public void unRegUser(User user, String code) throws SQLException, ClassNotFoundException {
		query = "DELETE FROM userConference WHERE login =? AND code =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParametersToRegUserConference(user.getLogin(), code);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	@Override
	public void delUser(User user) throws ClassNotFoundException, SQLException {
		query = "DELETE FROM userconference WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setDelUserParameters(user);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}
	
}
