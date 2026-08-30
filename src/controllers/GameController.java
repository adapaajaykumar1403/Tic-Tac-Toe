package controllers;

import builders.AppBuilder;
import models.User;
import services.UserService;

import java.util.Scanner;

public class GameController {
    Scanner sc;
    UserService userService;

    public GameController(){
        this.sc = AppBuilder.getScanner();
        this.userService = AppBuilder.getUserService();
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

    }
    public User getPlayerDetails(){
        System.out.println("New player - Press 1");
        System.out.println("Existing player - Press 2");
        System.out.println("Waiting for user response: ");
        int option = sc.nextInt();
        if(option == 1){
            System.out.println("Enter your name: ");
            String name = sc.next();
            System.out.println("Enter your Email : ");
            String email = sc.next();
            System.out.println("Enter your password");
            String password = sc.next();
            return userService.registerNewUser(name, email, password);
        }else if(option == 2){
            System.out.println("Enter your email : ");
            String email = sc.next();
            return userService.getExistingUser(email);
        }else{
            System.out.println("Invalid option");
        }
        return null;
    }
}

