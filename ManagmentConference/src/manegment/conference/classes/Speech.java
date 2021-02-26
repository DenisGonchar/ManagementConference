package manegment.conference.classes;

public class Speech {
    private String nameSpeach;
    private String time;
    private String interval;
    private String login;
    private String code;
    
    

    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Speech(String nameSpeach, String time, String interval, String login, String code) {
		super();
		this.nameSpeach = nameSpeach;
		this.time = time;
		this.interval = interval;
		this.login = login;
		this.code = code;
	}

	public Speech() {
    }

    public String getNameSpeach() {
        return nameSpeach;
    }

    public void setNameSpeach(String nameSpeach) {
        this.nameSpeach = nameSpeach;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}

