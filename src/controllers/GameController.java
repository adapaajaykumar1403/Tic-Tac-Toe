package controllers;

import Enums.GameStatus;
import models.Game;
import models.User;
import services.GameService;
import services.UserService;

import java.util.Scanner;

public class GameController {
    Scanner sc;
    UserService userService;
    GameService gameService;
    BoardController boardController;

    public GameController(Scanner sc,UserService userService, GameService gameService, BoardController boardController){
        this.sc = sc;
        this.userService = userService;
        this.gameService = gameService;
        this.boardController = boardController;
    }

    public void startGame(){
        System.out.println("[GAME CONTROLLER]: Welcome!!! to TIC-TAC-TOE....");
        boolean flag = true;
        while(flag){
            System.out.println("[GAME CONTROLLER]: Start a new Game    - Press 1");
            System.out.println("[GAME CONTROLLER]: Get your game Stats - Press 2");
            System.out.println("[GAME CONTROLLER]: All game Stats      - Press 3");
            System.out.println("[GAME CONTROLLER]: Exit                - Press 0");
            System.out.println("[GAME CONTROLLER]: Waiting for user input : ");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    startNewGame();
                    break;
                case 2:
                    //getUserStats();
                    break;
                case 3:
                    //getGameStats();
                    break;
                case 0:
                    flag = false;
                    System.out.println("[GAME CONTROLLER]: THANKS for playing...");
                    break;
                default:
                    System.out.println("[GAME CONTROLLER]: Enter a valid input value...");
                    break;

            }
        }
    }

    public void startNewGame(){
        System.out.println("Enter player 1 details...");
        User player1 = getPlayerDetails();
        System.out.println("Enter player 2 details...");
        User player2 = getPlayerDetails();
        Game game = gameService.createNewGame(player1, player2);
        System.out.println("GAME STARTED");
        int count = 0;
        int turn = 1;
        User winner = null;
        while(count < 9 && winner == null){
            if(turn == 1){
                System.out.println("PLAYER 1.. its your turn");
            }else{
                System.out.println("PLAYER 2 .. its your turn");
            }
            boardController.printBoard(game.getGameBoard());
            System.out.println("Enter your values");
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x < 0 || y < 0 || x > 2 || y > 2 ){
                System.out.println("Enter valid positions");
                continue;
            }

            winner = gameService.validateMove(turn, x, y, game);
            turn = turn % 2 + 1;
            count++;
        }
        if(winner == null){
            game.setStatus(GameStatus.DRAW.toString());
            System.out.println("GAME DRAWN");
            return;
        }
        game.setStatus(GameStatus.COMPLETED.toString());
        System.out.println(winner.getName()+" WON the game");
    }

    public User getPlayerDetails(){
        System.out.println("New player - Press 1");
        System.out.println("Existing player - Press 2");
        System.out.println("Waiting for user response: ");
        int option = sc.nextInt();
        User player = null;
        if(option == 1){
            System.out.println("Enter your name: ");
            String name = sc.next();
            System.out.println("Enter your Email : ");
            String email = sc.next();
            System.out.println("Enter your password");
            String password = sc.next();
            player = userService.registerNewUser(name, email, password);
            if(player != null){
                System.out.println("New User created successfully");
            }
        }else if(option == 2){
            System.out.println("Enter your email : ");
            String email = sc.next();
            player = userService.getExistingUser(email);
            if(player != null){
                System.out.println("User details fetched Successfully");
            }
        }else{
            System.out.println("Invalid option");
        }
        return player;
    }
}

