package menegment.conference.db.dao;

import java.sql.SQLException;
import java.util.List;

import manegment.conference.classes.User;

public interface UserConferenceDao {

	boolean checkUser(User user, String code) throws ClassNotFoundException, SQLException;
	void regUser(User user, String code) throws SQLException, ClassNotFoundException;
	List<User> getUsersByCode(String code) throws ClassNotFoundException, SQLException;
	void delUser(User user) throws ClassNotFoundException, SQLException;
	void unRegUser(User user, String code) throws SQLException, ClassNotFoundException;
}
