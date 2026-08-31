package services;

import models.Game;
import models.GameBoard;
import models.GameStats;
import models.User;
import repositories.GameDB;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class GameService {
    GameDB gameDB;
    BoardService boardService;
    UserService userService;

    public GameService(GameDB gameDB, BoardService boardService, UserService userService){
        this.gameDB = gameDB;
        this.boardService = boardService;
        this.userService = userService;
    }

    public Game createNewGame(User player1, User player2){
        int gameId = gameDB.generateGameId();
        GameBoard gameBoard = boardService.createNewBoard();
        Game game = new Game(gameId, LocalDateTime.now(), player1, player2, gameBoard);
        gameDB.saveGame(game);
        return game;
    }

    public boolean isValidMove(int x, int y, Game game){
        char[][] board = game.getGameBoard().getBoard();
        if(x<0 || x>2 || y<0 || y>2 || board[x][y] == 'X' || board[x][y] =='O'){
            return false;
        }
        return true;
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
        char ch = (turn == 1) ? 'X' : 'O';
        int val = (ch == 'X') ? 1 : -1;
        board[x][y] = ch;
        rowArr[x] = rowArr[x] + val;
        colArr[y] = colArr[y] + val;
        if(x == y){
            diag += val;
            gameBoard.setDiag(diag);
        }
        if(x+y == 2){
            antiDiag += val;
            gameBoard.setAntiDiag(antiDiag);
        }
        User winner = null;
        if(rowArr[x] == 3 || rowArr[x] == -3 ||
                colArr[y] == 3 || colArr[y] == -3 ||
                diag == 3 || diag == -3 ||
                antiDiag == 3 || antiDiag == -3
            ){
            winner = (turn == 1) ? game.getPlayer1() : game.getPlayer2();
        }
        return winner;
    }
    public GameStats getAllGameStats(){
        List<Game> allGames = gameDB.getAllGames();
        GameStats gameStats = new GameStats();
        int totPlayers = userService.getNumberOfUsers();
        int max = 0;
        int maxId = -1;
        int[] arr = new int[totPlayers+1];
        int drawn = 0;
        long totalDuration = 0;
        long longestGame = 0;
        long shortestGame = Long.MAX_VALUE;
        for(Game game : allGames){
            if(game.getStatus().equals("DRAW"))
                drawn++;
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
            if(game.getWinner() != null) {
                int id = game.getWinner().getUserId();
                arr[id]++;
                if (arr[id] > max) {
                    max = arr[id];
                    maxId = id;
                }
            }

        }
        gameStats.setTotalGames(allGames.size());
        gameStats.setDrawn(drawn);
        gameStats.setTotalPlayers(totPlayers);
        gameStats.setLongestGame(longestGame);
        gameStats.setShortestGame(shortestGame);
        gameStats.setTotalDuration(totalDuration);
        gameStats.setMostWinner(userService.getUserById(maxId));
        gameStats.setMostWins(max);
        return gameStats;
    }
}
