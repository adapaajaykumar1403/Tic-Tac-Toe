package repositories;

import models.GameBoard;

import java.util.HashMap;

public class BoardDB {
    private final HashMap<Integer, GameBoard> boardMap;

    public BoardDB(){
        this.boardMap = new HashMap<>();
    }
    public int generateBoardId(){
        return this.boardMap.size()+1;
    }
    public void saveBoard(GameBoard gameBoard){
        int boardId = gameBoard.getBoardId();
        this.boardMap.put(boardId, gameBoard);
    }
}
