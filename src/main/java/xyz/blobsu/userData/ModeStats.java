package xyz.blobsu.userData;

public class ModeStats {
    private int id;
    private int mode;
    private long tscore;
    private long rscore;
    private int pp;
    private int plays;
    private int playtime;
    private double acc;
    private int max_combo;
    private int total_hits;
    private int replay_views;
    private int xh_count;
    private int x_count;
    private int sh_count;
    private int s_count;
    private int a_count;
    private int rank;
    private int country_rank;

    public int getId() {
        return id;
    }

    public int getMode() {
        return mode;
    }

    public long getTscore() {
        return tscore;
    }

    public long getRscore() {
        return rscore;
    }

    public int getPp() {
        return pp;
    }

    public int getPlays() {
        return plays;
    }

    public int getPlaytime() {
        return playtime;
    }

    public double getAcc() {
        return acc;
    }

    public int getMaxCombo() {
        return max_combo;
    }

    public int getTotalHits() {
        return total_hits;
    }

    public int getReplayViews() {
        return replay_views;
    }

    public int getXhCount() {
        return xh_count;
    }

    public int getXCount() {
        return x_count;
    }

    public int getShCount() {
        return sh_count;
    }

    public int getSCount() {
        return s_count;
    }

    public int getACount() {
        return a_count;
    }

    public int getRank() {
        return rank;
    }

    public int getCountryRank() {
        return country_rank;
    }

    @Override
    public String toString() {
        return "ModeStats{" +
                "id=" + id +
                ", mode=" + mode +
                ", tscore=" + tscore +
                ", rscore=" + rscore +
                ", pp=" + pp +
                ", plays=" + plays +
                ", playtime=" + playtime +
                ", acc=" + acc +
                ", max_combo=" + max_combo +
                ", total_hits=" + total_hits +
                ", replay_views=" + replay_views +
                ", xh_count=" + xh_count +
                ", x_count=" + x_count +
                ", sh_count=" + sh_count +
                ", s_count=" + s_count +
                ", a_count=" + a_count +
                ", rank=" + rank +
                ", country_rank=" + country_rank +
                '}';
    }


}

