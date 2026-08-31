package models;

import java.time.LocalDateTime;

public class PlayerStats {
    private User player;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int gamesDrawn;
    private float winPercentage;
    private float lostPercentage;
    private float avgDuration;
    private long longestGame;
    private long shortestGame;

    public PlayerStats(User player){
        this.player = player;
    }

    public User getPlayer() {
        return player;
    }

    public void setPlayer(User player) {
        this.player = player;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public void setGamesDrawn(int gamesDrawn) {
        this.gamesDrawn = gamesDrawn;
    }

    public float getWinPercentage() {
        return winPercentage;
    }

    public void setWinPercentage(float winPercentage) {
        this.winPercentage = winPercentage;
    }

    public float getLostPercentage() {
        return lostPercentage;
    }

    public void setLostPercentage(float lostPercentage) {
        this.lostPercentage = lostPercentage;
    }

    public float getAvgDuration() {
        return avgDuration;
    }

    public void setAvgDuration(float avgDuration) {
        this.avgDuration = avgDuration;
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
