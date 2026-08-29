package builders;

import models.Game;
import models.User;
import repositories.BoardDB;
import repositories.GameDB;
import repositories.UserDB;

public class AppBuilder {
    private static AppBuilder instance;
    private static UserDB userDB;
    private static GameDB gameDB;
    private static BoardDB boardDB;

    private AppBuilder(){
        System.out.println("[builder]: Essentials class object creation started..");
        AppBuilder.userDB = new UserDB();
        AppBuilder.gameDB = new GameDB();
        AppBuilder.boardDB = new BoardDB();
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
}
