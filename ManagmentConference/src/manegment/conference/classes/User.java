package manegment.conference.classes;

public class User {
	private String login;
	private String password;
	private String email;
	private String rolle;
	
	public User(String login, String password, String email, String rolle) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.rolle = rolle;
	}

	public User() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRolle() {
		return rolle;
	}

	public void setRolle(String rolle) {
		this.rolle = rolle;
	}
	
	
	
}
