package repositories;

import models.Board;

import java.util.HashMap;

public class BoardDB {
    HashMap<Integer, Board> boardDB;

    public BoardDB(){
        this.boardDB = new HashMap<>();
    }
}
