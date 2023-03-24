package homework.dicehomework3help.component;

public class GameScore {
    private int totalScore;

    public int getTotalScore() {
        return totalScore;
    }

    public GameScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public void takeScore(GameScore otherScore, int steal_score) {
        this.totalScore -= steal_score;
        otherScore.totalScore += steal_score;
    }

    public void addScore (int buffScore) {
        this.totalScore += buffScore;
    }

    public void loseALL(int deathScore) {
        this.totalScore = deathScore;
    }

    @Override
    public String toString() {
        return "GameScore{" +
                "totalScore=" + totalScore +
                '}';
    }
}
