package models;

import Enums.GameStatus;

import java.time.LocalDateTime;

public class Game {
    private int gameId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private User player1;
    private User player2;
    private GameBoard gameBoard;
    private String status;
    private User winner;

    public Game(int gameId, LocalDateTime startTime, User player1, User player2, GameBoard gameBoard) {
        this.gameId = gameId;
        this.startTime = startTime;
        this.player1 = player1;
        this.player2 = player2;
        this.gameBoard = gameBoard;
        this.status = GameStatus.IN_PROGRESS.toString();
    }

    public int getGameID() {
        return gameId;
    }

    public void setGameID(int gameID) {
        this.gameId = gameID;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }
}
