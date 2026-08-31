package services;

import models.Game;
import models.PlayerStats;
import models.User;
import repositories.GameDB;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StatsService {
    GameDB gameDB;
    public StatsService(GameDB gameDB){
        this.gameDB = gameDB;
    }
    public PlayerStats getPlayerStats(User player){
        PlayerStats playerStats = new PlayerStats(player);
        List<Game> gamesPlayed= getGamesPlayed(player);
        int total = gamesPlayed.size();
        int won = 0;
        int lost = 0;
        int draw = 0;
        long totalDuration = 0;
        long longestGame = 0;
        long shortestGame = Long.MAX_VALUE;


        for(Game game: gamesPlayed){
            if(game.getWinner() == player){
                won++;
            }else if(game.getStatus().equals("DRAW")){
                draw++;
            }else {
                lost++;
            }

            // Duration calculation
            if (game.getStartTime() != null && game.getEndTime() != null) {

                long duration = Duration.between(
                                game.getStartTime(),
                                game.getEndTime())
                        .toMinutes();

                totalDuration += duration;

                if (duration > longestGame) {
                    longestGame = duration;
                }

                if (duration < shortestGame) {
                    shortestGame = duration;
                }
            }
        }

        playerStats.setGamesPlayed(total);
        playerStats.setGamesWon(won);
        playerStats.setGamesLost(lost);
        playerStats.setGamesDrawn(draw);
        playerStats.setWinPercentage(((float) won /total)*100);
        playerStats.setLostPercentage(((float) lost /total)*100);
        playerStats.setLongestGame(longestGame);
        playerStats.setShortestGame(shortestGame);
        playerStats.setAvgDuration((float) totalDuration /(long)total);
        return playerStats;
    }
    public List<Game> getGamesPlayed(User player){
        List<Game> allGames = gameDB.getAllGames();
        List<Game> gamesPlayed = new ArrayList<>();
        for(Game game : allGames){
            if(game.getPlayer1()== player || game.getPlayer2()== player){
                gamesPlayed.add(game);
            }
        }
        return gamesPlayed;
    }

}
