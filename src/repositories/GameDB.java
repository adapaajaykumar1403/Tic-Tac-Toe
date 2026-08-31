package repositories;

import models.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameDB {
    private final HashMap<Integer, Game> gameMap;

    public GameDB(){
        this.gameMap = new HashMap<>();
    }
    public int generateGameId(){
        return this.gameMap.size()+1;
    }
    public void saveGame(Game game){
        int gameId = game.getGameID();
        this.gameMap.put(gameId, game);
    }
    public List<Game> getAllGames(){
        List<Game> allGames = new ArrayList<>();
         for(Game game : gameMap.values()){
             allGames.add(game);
        }
         return allGames;
    }


}
