package manegment.conference.entity;

public class PropConference {
	private Conference conference;
	private Boolean registration;
	public PropConference(Conference conference, Boolean registration) {
		super();
		this.conference = conference;
		this.registration = registration;
	}
	public Conference getConference() {
		return conference;
	}
	public void setConference(Conference conference) {
		this.conference = conference;
	}
	public Boolean getRegistration() {
		return registration;
	}
	public void setRegistration(Boolean registration) {
		this.registration = registration;
	}
	
}
