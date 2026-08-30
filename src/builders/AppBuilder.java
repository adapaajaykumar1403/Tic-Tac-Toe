package builders;

import controllers.GameController;
import models.Game;
import models.User;
import repositories.BoardDB;
import repositories.GameDB;
import repositories.UserDB;
import services.UserService;

import java.util.Scanner;

public class AppBuilder {
    private static AppBuilder instance;
    private static UserDB userDB;
    private static GameDB gameDB;
    private static BoardDB boardDB;
    private static GameController gameController;
    private static UserService userService;
    private static Scanner sc;

    private AppBuilder(){
        System.out.println("[builder]: Essentials class object creation started..");
        AppBuilder.userDB = new UserDB();
        AppBuilder.gameDB = new GameDB();
        AppBuilder.boardDB = new BoardDB();
        AppBuilder.gameController = new GameController();
        AppBuilder.userService = new UserService();
        AppBuilder.sc = new Scanner(System.in);
        System.out.println("[builder]: Essentials class object creation ended..");
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
