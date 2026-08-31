package controllers;

import models.PlayerStats;
import models.User;
import services.StatsService;
import services.UserService;

import java.util.Scanner;

public class UserController {
    Scanner sc;
    UserService userService;
    StatsService statsService;
    public UserController(Scanner sc, UserService userService, StatsService statsService){
        this.sc = sc;
        this.userService = userService;
        this.statsService = statsService;
    }
    public void printUserStats(){
        System.out.println(" Enter the user email");
        String email = sc.next();
        User user = userService.getExistingUser(email);
        if(user == null){
            System.out.println(" No user found with email - " + email);
            return;
        }
        PlayerStats playerStats = statsService.getPlayerStats(user);
        // Print Stats
        System.out.println("\n========== PLAYER STATS ==========");
        System.out.println("Player            : " + user.getName());
        System.out.println("Total Games       : " + playerStats.getGamesPlayed());
        System.out.println("Wins              : " + playerStats.getGamesWon());
        System.out.println("Losses            : " + playerStats.getGamesLost());
        System.out.println("Draws             : " + playerStats.getGamesDrawn());
        System.out.printf("Win Percentage    : %.2f%%\n", playerStats.getWinPercentage());
        System.out.printf("Loss Percentage    : %.2f%%\n", playerStats.getLostPercentage());
        System.out.println("\n------ Duration Stats ------");
        System.out.println("Average Duration  : " + playerStats.getAvgDuration() + " mins");
        System.out.println("Longest Game      : " + playerStats.getLongestGame() + " mins");
        System.out.println("Shortest Game     : " + playerStats.getShortestGame() + " mins");
        System.out.println("=================================");

    }
}
