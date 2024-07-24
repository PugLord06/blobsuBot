package xyz.blobsu.userData;

import com.google.gson.annotations.SerializedName;

public class Stats {
    @SerializedName("0")
    private ModeStats modeStats;

    public ModeStats getModeStats() {
        return modeStats;
    }
}
