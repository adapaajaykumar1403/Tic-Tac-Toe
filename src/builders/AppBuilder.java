package builders;

import controllers.BoardController;
import controllers.GameController;
import controllers.UserController;
import repositories.BoardDB;
import repositories.GameDB;
import repositories.UserDB;
import services.BoardService;
import services.GameService;
import services.StatsService;
import services.UserService;

import java.util.Scanner;

public class AppBuilder {
    private static AppBuilder instance;
    private static UserDB userDB;
    private static GameDB gameDB;
    private static BoardDB boardDB;
    private static BoardController boardController;
    private static UserController userController;
    private static GameController gameController;
    private static UserService userService;
    private static GameService gameService;
    private static BoardService boardService;
    private static StatsService statsService;
    private static Scanner sc;

    private AppBuilder(){
        //System.out.println("[builder]: Essentials class object creation started..");

        sc = new Scanner(System.in);
        userDB = new UserDB();
        gameDB = new GameDB();
        boardDB = new BoardDB();
        userService = new UserService(userDB);
        boardService = new BoardService(boardDB);
        gameService = new GameService(gameDB, boardService, userService);
        statsService = new StatsService(gameDB);
        boardController = new BoardController();
        userController = new UserController(sc, userService, statsService);
        gameController = new GameController(sc, userService, gameService, boardController, userController);

        //System.out.println("[builder]: Essentials class object creation ended..");
    }
    public static AppBuilder getInstance(){
        if(instance == null){
            instance = new AppBuilder();
        }
        return instance;
    }
    public static UserDB getUserDB(){
        return userDB;
    }
    public static GameDB getGameDB(){
        return gameDB;
    }
    public static BoardDB getBoardDB(){
        return boardDB;
    }
    public static GameController getGameController(){
        return gameController;
    }
    public static UserService  getUserService(){
        return userService;
    }
    public static Scanner getScanner(){
        return sc;
    }
}
