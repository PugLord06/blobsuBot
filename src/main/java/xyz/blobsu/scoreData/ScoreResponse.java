package xyz.blobsu.scoreData;

import java.util.List;

public class ScoreResponse {

    private String status;
    private List<Score> scores;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Score> getScores() {
        return scores;
    }

    @Override
    public String toString() {
        return "ScoreResponse{" +
                "status='" + status + '\'' +
                ", scores=" + scores +
                '}';
    }
}
