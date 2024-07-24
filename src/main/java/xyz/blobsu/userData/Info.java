package xyz.blobsu.userData;


public class Info {
    private int id;
    private String name;
    private String safe_name;
    private int priv;
    private String country;
    private long silence_end;
    private long donor_end;
    private long creation_time;
    private long latest_activity;
    private int clan_id;
    private int clan_priv;
    private int preferred_mode;
    private int play_style;
    private String custom_badge_name;
    private String custom_badge_icon;
    private String userpage_content;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSafeName() {
        return safe_name;
    }

    public int getPriv() {
        return priv;
    }

    public String getCountry() {
        return country;
    }

    public long getSilenceEnd() {
        return silence_end;
    }

    public long getDonorEnd() {
        return donor_end;
    }

    public long getCreationTime() {
        return creation_time;
    }

    public long getLatestActivity() {
        return latest_activity;
    }

    public int getClanId() {
        return clan_id;
    }

    public int getClanPriv() {
        return clan_priv;
    }

    public int getPreferredMode() {
        return preferred_mode;
    }

    public int getPlayStyle() {
        return play_style;
    }

    public String getCustomBadgeName() {
        return custom_badge_name;
    }

    public String getCustomBadgeIcon() {
        return custom_badge_icon;
    }

    public String getUserpageContent() {
        return userpage_content;
    }


}

