package manegment.conference.entity;

public class Conference {
    private String nameConf;
    private String place;
    private String date;
    private String time;
    private String code;
	public Conference(String nameConf, String place, String date, String time, String code) {
		super();
		this.nameConf = nameConf;
		this.place = place;
		this.date = date;
		this.time = time;
		this.code = code;
	}
	public String getNameConf() {
		return nameConf;
	}
	public void setNameConf(String nameConf) {
		this.nameConf = nameConf;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
    

    
}
