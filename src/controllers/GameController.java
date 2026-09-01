package controllers;

import Enums.GameStatus;
import models.Game;
import models.GameStats;
import models.User;
import services.GameService;
import services.UserService;

import java.time.LocalDateTime;
import java.util.Scanner;

public class GameController {
    Scanner sc;
    UserService userService;
    GameService gameService;
    BoardController boardController;
    UserController userController;

    public GameController(Scanner sc,UserService userService, GameService gameService, BoardController boardController, UserController userController){
        this.sc = sc;
        this.userService = userService;
        this.gameService = gameService;
        this.boardController = boardController;
        this.userController = userController;
    }

    public void startGame(){
        System.out.println("---Welcome!!! to TIC-TAC-TOE---");
        boolean flag = true;
        while(flag){
            System.out.println(" Start a new Game    - Press 1");
            System.out.println(" Get your game Stats - Press 2");
            System.out.println(" All game Stats      - Press 3");
            System.out.println(" Exit                - Press 0");
            System.out.print(" Waiting for user input : ");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    startNewGame();
                    break;
                case 2:
                    userController.printUserStats();
                    break;
                case 3:
                    printAllGameStats();
                    break;
                case 0:
                    flag = false;
                    System.out.println(" THANKS for playing...");
                    break;
                default:
                    System.out.println(" Enter a valid input value...");
                    break;

            }
        }
    }

    public void startNewGame(){
        User player1 = null;
        while(player1 == null) {
            System.out.println(" Enter player 1 details...");
            player1 = getPlayerDetails();
        }
        User player2 = null;
        while(player2 == null || (player2 == player1)) {
            if(player2 == player1){
                System.out.println("player 2 is same as player 1. Please create new Player...");
            }
            System.out.println(" Enter player 2 details...");
            player2 = getPlayerDetails();
        }
        Game game = gameService.createNewGame(player1, player2);
        System.out.println("*** GAME STARTED ***");
        int count = 0;
        int turn = 1;
        User winner = null;
        while(count < 9 && winner == null){
            if(turn == 1){
                System.out.println(" PLAYER 1.. its your turn");
            }else{
                System.out.println(" PLAYER 2 .. its your turn");
            }
            boardController.printBoard(game.getGameBoard());
            System.out.print(" Enter your values : ");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(!gameService.isValidMove(x, y, game)){
                System.out.println(" Enter valid positions....");
                continue;
            }
            winner = gameService.validateMove(turn, x, y, game);
            turn = turn % 2 + 1;
            count++;
        }
        game.setEndTime(LocalDateTime.now());
        game.setWinner(winner);
        if(winner == null){
            game.setStatus(GameStatus.DRAW);
            System.out.println("*** GAME DRAWN ***");
            return;
        }
        game.setStatus(GameStatus.COMPLETED);
        System.out.println("*** Hurray...! "+winner.getName()+" WON the game ***");
    }

    public User getPlayerDetails(){
        System.out.println(" New player        - Press 1");
        System.out.println(" Existing player   - Press 2");
        System.out.print(" Waiting for user response: ");
        int option = sc.nextInt();
        User player = null;
        if(option == 1){
            System.out.println(" Enter your Name : ");
            String name = sc.next();
            System.out.println(" Enter your Email : ");
            String email = sc.next();
            System.out.println(" Enter your password : ");
            String password = sc.next();
            player = userService.registerNewUser(name, email, password);
            if(player != null){
                System.out.println(" New User created successfully......");
            }
        }else if(option == 2){
            System.out.println(" Enter your Email : ");
            String email = sc.next();
            player = userService.getExistingUser(email);
            if(player != null){
                System.out.println(" User details fetched Successfully......");
            }else{
                System.out.println(" No User Found ........");
            }
        }else{
            System.out.println(" Invalid option.........");
        }
        return player;
    }

    public void printAllGameStats(){
        GameStats gameStats = gameService.getAllGameStats();
        System.out.println("\n========== GAME STATS ==========");
        System.out.println("Total Games       : " + gameStats.getTotalGames());
        System.out.println("Total Players     : " + gameStats.getTotalPlayers());
        System.out.println("Draws             : " + gameStats.getDrawn());
        if(gameStats.getMostWinner() != null)
            System.out.println("Most Winner       : " + gameStats.getMostWinner().getName());
        System.out.println("Most Wins         : " + gameStats.getMostWins());

        System.out.println("\n------ Duration Stats ------");
        System.out.println("Total Duration  : " + gameStats.getTotalDuration() + " mins");
        System.out.println("Longest Game      : " + gameStats.getLongestGame() + " mins");
        System.out.println("Shortest Game     : " + gameStats.getShortestGame() + " mins");
        System.out.println("=================================");

    }
}

