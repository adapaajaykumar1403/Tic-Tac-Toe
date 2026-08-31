package models;

public class GameStats {
    private int totalGames;
    private int drawn;
    private int totalPlayers;
    private User mostWinner;
    private int mostWins;
    private long longestGame;
    private long shortestGame;
    private long totalDuration;

    public int getTotalGames() {
        return totalGames;
    }

    public int getMostWins() {
        return mostWins;
    }

    public void setMostWins(int mostWins) {
        this.mostWins = mostWins;
    }

    public void setTotalGames(int totalGames) {
        this.totalGames = totalGames;
    }

    public int getDrawn() {
        return drawn;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public int getTotalPlayers() {
        return totalPlayers;
    }

    public void setTotalPlayers(int totalPlayers) {
        this.totalPlayers = totalPlayers;
    }

    public User getMostWinner() {
        return mostWinner;
    }

    public void setMostWinner(User mostWinner) {
        this.mostWinner = mostWinner;
    }

    public long getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(long totalDuration) {
        this.totalDuration = totalDuration;
    }

    public long getLongestGame() {
        return longestGame;
    }

    public void setLongestGame(long longestGame) {
        this.longestGame = longestGame;
    }

    public long getShortestGame() {
        return shortestGame;
    }

    public void setShortestGame(long shortestGame) {
        this.shortestGame = shortestGame;
    }
}
