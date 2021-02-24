package managment.conference.db.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import manegment.conference.classes.DBProperties;
import manegment.conference.classes.User;
import menegment.conference.db.dao.UserDao;

public class UserDaoImpl implements UserDao {
	private DBProperties dbproperties = new DBProperties();
	private List<User> users = new ArrayList<>();
	private String quary;

	@Override
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		quary = "SELECT * FROM user WHERE rolle = 'user'";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
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
		quary = "SELECT * FROM user WHERE rolle = 'speaker'";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
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
		quary = "SELECT * FROM user WHERE login=? AND password=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
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
		quary = "INSERT INTO user (login, password, email, rolle) VALUES (?, ?, ?, 'user')";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setAddParameters(user.getLogin(), user.getPassword(), user.getEmail());
		dbproperties.updateResult();
		dbproperties.closeDB();
	}

	@Override
	public void removeUser(User user) throws ClassNotFoundException, SQLException {
		quary = "DELETE FROM user WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setDelParameters(user.getLogin());
		dbproperties.updateResult();
		dbproperties.closeDB();

	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkLoginEmail(String login, String email) throws SQLException, ClassNotFoundException {
		quary = "SELECT * FROM user WHERE login=? OR email=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setCheckParameters(login, email);
		ResultSet rs = dbproperties.createResult();
		return rs.next()?true:false;
	}
	@Override
	public User getUserByLogin(String login) throws SQLException, ClassNotFoundException {
		quary = "SELECT * FROM user WHERE login=?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setUserByLoginParameters(login);
		ResultSet rs = dbproperties.createResult();
		rs.next();
		return new User(rs.getString("login"), rs.getString("password"), rs.getString("email"), rs.getString("rolle"));
	}
	@Override
	public void setRolle(User user, String rolle) throws SQLException, ClassNotFoundException {
		quary = "UPDATE user SET rolle=? WHERE login =?";
		dbproperties.openDB();
		dbproperties.createPreparedStatement(quary);
		dbproperties.setParameterForRolle(user, rolle);
		dbproperties.updateResult();
		dbproperties.closeDB();
		
	}


}
