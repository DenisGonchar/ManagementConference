package manegment.conference.classes;

public class Shedule {
    private String nameConf;
    private String nameSpeach;

    public Shedule(String nameConf, String nameSpeach) {
        this.nameConf = nameConf;
        this.nameSpeach = nameSpeach;
    }

    public Shedule() {
    }

    public String getNameConf() {
        return nameConf;
    }

    public void setNameConf(String nameConf) {
        this.nameConf = nameConf;
    }

    public String getNameSpeach() {
        return nameSpeach;
    }

    public void setNameSpeach(String nameSpeach) {
        this.nameSpeach = nameSpeach;
    }
}
