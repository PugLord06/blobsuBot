package xyz.blobsu.scoreData;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeParseException;
import java.util.EnumSet;
import java.util.Locale;
import java.util.Set;

public class Score {
    private int id;
    private int score;
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
    private int mods;
    private String play_time;
    private long playMode;
    private int mode;
    private int passed;
    private long totalHits;
    private String grade;
    private Beatmap beatmap;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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

    public int getMods() {
        return mods;
    }

    public void setMods(int mods) {
        this.mods = mods;
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
                ", playTime=" + play_time +
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGradeEmoji() {
        return switch (grade) {
            case "XH" -> "<:XH_:1265443313583128680>";
            case "X" -> "<:X_:1265443296306663494>";
            case "SH" -> "<:SH_:1265443272030158941>";
            case "S" -> "<:S_:1265443255588229242>";
            case "A" -> "<:A_:1265443137560510534>";
            case "B" -> "<:B_:1265443157508751370>";
            case "C" -> "<:C_:1265443173048516648>";
            case "D" -> "<:D_:1265443188810711113>";
            default -> "<:F_:1265443204979888149>";
        };


    }

    public String getScoreString() {
        return String.format(Locale.US, "%,d", score);
    }

    public String convertToDiscordTimestamp() throws DateTimeParseException {
        // Parse the date-time string to LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.parse(play_time);

        // Convert to ZonedDateTime with the specified timezone
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("UTC"));

        // Convert to an Instant
        Instant instant = zonedDateTime.toInstant();

        // Get the epoch time in seconds
        long epochSeconds = instant.getEpochSecond();

        // Return the Discord timestamp string
        return "<t:" + epochSeconds + ":R>";
    }

    public String getPlay_time() {
        return play_time;
    }

    public void setPlay_time(String play_time) {
        this.play_time = play_time;
    }

    public String getActiveMods(int bitmask) {
        String mods = "";
        Set<Mods> activeModsSet = EnumSet.noneOf(Mods.class);

        for (Mods mod : Mods.values()) {
            if ((bitmask & mod.getValue()) != 0) {
                activeModsSet.add(mod);
                mods += mod;

            }

        }
        if (mods.contains("NC")) {
            mods = mods.replaceAll("NC", "");

        }

        if (activeModsSet.isEmpty()) {
            return Mods.NM.name();
        }


        return mods;
    }
}
