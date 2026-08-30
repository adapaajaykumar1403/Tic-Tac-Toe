package repositories;

import models.Game;

import java.util.HashMap;

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

}
