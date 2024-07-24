package xyz.blobsu.userData;

import java.util.Map;

public class Player {
    private Info info;
    private Map<String, ModeStats> stats;

    public Info getInfo() {
        return info;
    }

    public Map<String, ModeStats> getStats() {
        return stats;
    }
}
