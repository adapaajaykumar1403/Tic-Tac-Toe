import Enums.GameStatus;
import builders.AppBuilder;
import controllers.GameController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AppBuilder appBuilder = AppBuilder.getInstance();
        GameController gameController = AppBuilder.getGameController();
        gameController.startGame();
        System.out.println(GameStatus.COMPLETED.toString());

    }
}