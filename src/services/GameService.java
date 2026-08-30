package services;

import models.Game;
import models.GameBoard;
import models.User;
import repositories.GameDB;

import java.time.LocalDateTime;

public class GameService {
    GameDB gameDB;
    BoardService boardService;

    public GameService(GameDB gameDB, BoardService boardService){
        this.gameDB = gameDB;
        this.boardService = boardService;
    }

    public Game createNewGame(User player1, User player2){
        int gameId = gameDB.generateGameId();
        GameBoard gameBoard = boardService.createNewBoard();
        Game game = new Game(gameId, LocalDateTime.now(), player1, player2, gameBoard);
        gameDB.saveGame(game);
        return game;
    }

    public User validateMove(int turn, int x, int y, Game game){
        GameBoard gameBoard = game.getGameBoard();
        char[][] board = gameBoard.getBoard();
        int[] rowArr = gameBoard.getRowArr();
        int[] colArr = gameBoard.getColArr();
        int diag = gameBoard.getDiag();
        int antiDiag = gameBoard.getAntiDiag();
        if(board[x][y] == 'X' || board[x][y] == 'O'){
            return null;// exception.........
        }
        char ch = (turn ==1) ? 'X' : 'O';
        int val = (ch == 'X') ? 1 : -1;
        board[x][y] = ch;
        rowArr[x] = rowArr[x] + val;
        colArr[y] = colArr[y] + val;
        if(x == y){
            diag += val;
        }
        if(x+y == 3){
            antiDiag += val;
        }
        User winner = null;
        if(rowArr[x] == 3 || rowArr[x] == -3 ||
            colArr[y] == 3 || colArr[y] == -3 ||
            diag == 3 || diag == -3 ||
            antiDiag == 3 || antiDiag == -3){
            winner = (turn == 1) ? game.getPlayer1() : game.getPlayer2();
        }
        return winner;
    }
}
