package manegment.conference.classes;

public class Speach {
    private String nameSpeach;
    private String time;
    private String interval;
    private String login;

    public Speach(String nameSpeach, String time, String interval, String login) {
        this.nameSpeach = nameSpeach;
        this.time = time;
        this.interval = interval;
        this.login = login;
    }

    public Speach() {
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

