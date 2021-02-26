package manegment.conference.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBProperties {
	private String drv = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost/managmentconference";
	private String login = "root";
	private String pass = "1111111";
	private Connection connection = null;
	private PreparedStatement pstmt;
	private ResultSet result = null;
	
	public void openDB() throws ClassNotFoundException, SQLException {
		Class.forName(drv);
		connection = DriverManager.getConnection(url, login, pass);
	}
	public void createPreparedStatement(String quary) throws SQLException {
		pstmt=connection.prepareStatement(quary);
	}
	public void setCheckParameters(String login, String password) throws SQLException{
		pstmt.setString(1, login);
		pstmt.setString(2, password);
	}
	public void setCheckParametersForConference(String nameConf, String time) throws SQLException {
		pstmt.setString(1, nameConf);
		pstmt.setString(2, time);
		
	}
	public void setCheckParametersForSpeach(String nameSpeach, String time) throws SQLException {
		pstmt.setString(1, nameSpeach);
		pstmt.setString(2, time);
		
	}
	public void setAddParameters(String login, String password, String email) throws SQLException{
		pstmt.setString(1, login);
		pstmt.setString(2, password);
		pstmt.setString(3, email);
	}
	public void setDelParameters(String login) throws SQLException{
		pstmt.setString(1, login);
	}
	public void setAddParametersToSpeach(String nameSpeach, String time, String interval, String login, String code) throws SQLException {
		pstmt.setString(1, nameSpeach);
		pstmt.setString(2, time);
		pstmt.setString(3, interval);
		pstmt.setString(4, login);
		pstmt.setString(5, code);
	}
	
	public void setAddParametersToConference(String nameConf, String place, String date, String time, String code) throws SQLException {
		pstmt.setString(1, nameConf);
		pstmt.setString(2, place);
		pstmt.setString(3, date);
		pstmt.setString(4, time);
		pstmt.setString(5, code);
	}
	public ResultSet createResult() throws SQLException {
		result=pstmt.executeQuery();
		return result;
	}
	
	public void updateResult() throws SQLException {
		pstmt.executeUpdate();
	}
	public void closeDB() throws SQLException {
		connection.close();
	}
	public void setUpdateParameters(Conference conference) throws SQLException {
		pstmt.setString(1, conference.getNameConf());
		pstmt.setString(2, conference.getPlace());
		pstmt.setString(3, conference.getDate());
		pstmt.setString(4, conference.getTime());
		pstmt.setString(5, conference.getCode());
	}
	public void setCheckRegParameters(String login, String code) throws SQLException {
		pstmt.setString(1, login);
		pstmt.setString(2, code);
	}
	public void setAddParametersToRegUserConference(String login, String code) throws SQLException {
		pstmt.setString(1, login);
		pstmt.setString(2, code);
	}
	public void setParametersFromUserConference(String code) throws SQLException {
		pstmt.setString(1, code);
		
	}
	public void setUserByLoginParameters(String login) throws SQLException {
		pstmt.setString(1, login);
		
	}
	public void setParameterForRolle(User user, String rolle) throws SQLException {
		pstmt.setString(1, rolle);
		pstmt.setString(2, user.getLogin());
		
	}
	public void setDelUserParameters(User user) throws SQLException {
		pstmt.setString(1, user.getLogin());
		
	}
	public void setParametersCodesSpeaches(Conference conference) throws SQLException {
		pstmt.setString(1, conference.getCode());
		
	}
	public void setParameterSpeachCode(String code) throws SQLException {
		pstmt.setString(1, code);
		
	}
	public void setAddSpeachConfParameters(String codeConf, String codeSpeach) throws SQLException {
		pstmt.setString(1, codeSpeach);
		pstmt.setString(2, codeConf);
		
	}
	public void setUpdateParametersChangeLogin(String login, String code) throws SQLException {
		pstmt.setString(1, login);
		pstmt.setString(2, code);
		
	}
	public void setUpdateAllParametersSpeech(String nameSpeach, String time, String interval, String login,
			String code) throws SQLException {
		pstmt.setString(1, nameSpeach);
		pstmt.setString(2, time);
		pstmt.setString(3, interval);
		pstmt.setString(4, code);
	}
	
	
	
}
