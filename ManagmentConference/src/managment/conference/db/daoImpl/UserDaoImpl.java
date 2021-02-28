package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import manegment.conference.entity.DBProperties;
import manegment.conference.entity.User;
import menegment.conference.db.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private DBProperties dbproperties = new DBProperties();
	private List<User> users = new ArrayList<>();
	private String query;

	@Override
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM user WHERE rolle = 'user'";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		users.clear();
		while (rs.next()) {
			users.add(new User(rs.getString("login"), rs.getString("password"), 
					rs.getString("email"), "rolle"));
		}
		dbproperties.closeDB();
		return users;
	}
	@Override
	public List<User> getAllSpeakers() throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM user WHERE rolle = 'speaker' AND login <> 'freeSpeaker'";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		ResultSet rs = dbproperties.createResult();
		users.clear();
		while (rs.next()) {
			users.add(new User(rs.getString("login"), rs.getString("password"), 
					rs.getString("email"), "rolle"));
		}
		dbproperties.closeDB();
		return users;
	}

	@Override
	public User checkUser(User user) throws ClassNotFoundException, SQLException {
		query = "SELECT * FROM user WHERE login=? AND password=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setCheckParameters(user.getLogin(), user.getPassword());
		ResultSet rs = dbproperties.createResult();
		User u = null;
		if(rs.next()) {
			u = new User(rs.getString("login"), rs.getString("password"), 
					rs.getString("email"), rs.getString("rolle"));
		}
		dbproperties.closeDB();
		return u;
	}

	@Override
	public void addUser(User user) throws ClassNotFoundException, SQLException {
		query = "INSERT INTO user (login, password, email, rolle) VALUES (?, ?, ?, 'user')";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setAddParameters(user.getLogin(), user.getPassword(), user.getEmail());
		dbproperties.updateResult();
		dbproperties.closeDB();
	}

	@Override
	public void removeUser(User user) throws ClassNotFoundException, SQLException {
		query = "DELETE FROM user WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setDelParameters(user.getLogin());
		dbproperties.updateResult();
		dbproperties.closeDB();

	}

	@Override
	public boolean checkLoginEmail(String login, String email) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM user WHERE login=? OR email=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setCheckParameters(login, email);
		ResultSet rs = dbproperties.createResult();
		return rs.next()?true:false;
	}
	@Override
	public User getUserByLogin(String login) throws SQLException, ClassNotFoundException {
		query = "SELECT * FROM user WHERE login=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setUserByLoginParameters(login);
		ResultSet rs = dbproperties.createResult();
		rs.next();
		return new User(rs.getString("login"), rs.getString("password"), rs.getString("email"), rs.getString("rolle"));
	}
	@Override
	public void setRolle(User user, String rolle) throws SQLException, ClassNotFoundException {
		query = "UPDATE user SET rolle=? WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(query);
		dbproperties.setParameterForRolle(user, rolle);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}


}
