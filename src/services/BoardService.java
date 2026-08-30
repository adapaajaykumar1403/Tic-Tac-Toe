package services;

import models.GameBoard;
import repositories.BoardDB;

public class BoardService {
    BoardDB boardDB;
    public BoardService(BoardDB boardDB){
        this.boardDB = boardDB;
    }

    public GameBoard createNewBoard(){
        int id = boardDB.generateBoardId();
        GameBoard gameBoard = new GameBoard(id);
        boardDB.saveBoard(gameBoard);
        return gameBoard;
    }


}
