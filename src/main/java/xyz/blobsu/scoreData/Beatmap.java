package xyz.blobsu.scoreData;

public class Beatmap {

    private int id;
    private int set_id;
    private String md5;
    private String artist;
    private String title;
    private String version;
    private String creator;
    private int max_combo;
    private double bpm;
    private double cs;
    private double ar;
    private double od;
    private double hp;
    private double difficultyRating;
    private String mode;

    public int getId() {
        return id;
    }


    public int getSet_id() {
        return set_id;
    }

    public void setSet_id(int set_id) {
        this.set_id = set_id;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public double getBpm() {
        return bpm;
    }

    public void setBpm(double bpm) {
        this.bpm = bpm;
    }

    public double getCs() {
        return cs;
    }

    public void setCs(double cs) {
        this.cs = cs;
    }

    public double getAr() {
        return ar;
    }

    public void setAr(double ar) {
        this.ar = ar;
    }

    public double getOd() {
        return od;
    }

    public void setOd(double od) {
        this.od = od;
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getDifficultyRating() {
        return difficultyRating;
    }

    public void setDifficultyRating(double difficultyRating) {
        this.difficultyRating = difficultyRating;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Beatmap{" +
                "id=" + id +
                ", beatmapsetId=" + set_id +
                ", md5='" + md5 + '\'' +
                ", artist='" + artist + '\'' +
                ", title='" + title + '\'' +
                ", version='" + version + '\'' +
                ", creator=" + creator +
                ", bpm=" + bpm +
                ", cs=" + cs +
                ", ar=" + ar +
                ", od=" + od +
                ", hp=" + hp +
                ", difficultyRating=" + difficultyRating +
                ", mode='" + mode + '\'' +
                '}';
    }

    public int getMaxCombo() {
        return max_combo;
    }

    public void setMaxCombo(int max_combo) {
        this.max_combo = max_combo;
    }
}
