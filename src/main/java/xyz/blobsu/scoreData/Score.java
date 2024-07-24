package xyz.blobsu.scoreData;

public class Score {
    private int id;
    private long score;
    private int combo;
    private double acc;
    private int n300;
    private int n100;
    private int n50;
    private int ngeki;
    private int nkatu;
    private int nmiss;
    private double pp;
    private int rank;
    private int completed;
    private long max_combo;
    private long mods;
    private long playTime;
    private long playMode;
    private int mode;
    private int passed;
    private long totalHits;
    private Beatmap beatmap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }

    public int getCombo() {
        return combo;
    }

    public void setCombo(int combo) {
        this.combo = combo;
    }

    public double getAcc() {
        return acc;
    }

    public void setAcc(double acc) {
        this.acc = acc;
    }

    public int getN300() {
        return n300;
    }

    public void setN300(int n300) {
        this.n300 = n300;
    }

    public int getN100() {
        return n100;
    }

    public void setN100(int n100) {
        this.n100 = n100;
    }

    public int getN50() {
        return n50;
    }

    public void setN50(int n50) {
        this.n50 = n50;
    }

    public int getNgeki() {
        return ngeki;
    }

    public void setNgeki(int ngeki) {
        this.ngeki = ngeki;
    }

    public int getNkatu() {
        return nkatu;
    }

    public void setNkatu(int nkatu) {
        this.nkatu = nkatu;
    }

    public int getNmiss() {
        return nmiss;
    }

    public void setNmiss(int nmiss) {
        this.nmiss = nmiss;
    }

    public double getPp() {
        return pp;
    }

    public void setPp(double pp) {
        this.pp = pp;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getCompleted() {
        return completed;
    }

    public void setCompleted(int completed) {
        this.completed = completed;
    }

    public long getMaxCombo() {
        return max_combo;
    }

    public void setMaxCombo(long max_combo) {
        this.max_combo = max_combo;
    }

    public long getMods() {
        return mods;
    }

    public void setMods(long mods) {
        this.mods = mods;
    }

    public long getPlayTime() {
        return playTime;
    }

    public void setPlayTime(long playTime) {
        this.playTime = playTime;
    }

    public long getPlayMode() {
        return playMode;
    }

    public void setPlayMode(long playMode) {
        this.playMode = playMode;
    }

    public int getPassed() {
        return passed;
    }

    public void setPassed(int passed) {
        this.passed = passed;
    }

    public long getTotalHits() {
        return totalHits;
    }

    public void setTotalHits(long totalHits) {
        this.totalHits = totalHits;
    }

    public Beatmap getBeatmap() {
        return beatmap;
    }

    public void setBeatmap(Beatmap beatmap) {
        this.beatmap = beatmap;
    }

    @Override
    public String toString() {
        return "Score{" +
                "id=" + id +
                ", score=" + score +
                ", combo=" + combo +
                ", accuracy=" + acc +
                ", n300=" + n300 +
                ", n100=" + n100 +
                ", n50=" + n50 +
                ", ngeki=" + ngeki +
                ", nkatu=" + nkatu +
                ", nmiss=" + nmiss +
                ", pp=" + pp +
                ", rank=" + rank +
                ", completed=" + completed +
                ", max_combo=" + max_combo +
                ", mods=" + mods +
                ", playTime=" + playTime +
                ", playMode=" + playMode +
                ", passed=" + passed +
                ", totalHits=" + totalHits +
                ", beatmap=" + beatmap +
                '}';
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
