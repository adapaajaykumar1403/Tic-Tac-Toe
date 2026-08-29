package repositories;

import models.Game;

import java.util.HashMap;

public class GameDB {
    HashMap<Integer, Game> gameMap;

    public GameDB(){
        this.gameMap = new HashMap<>();
    }

}
