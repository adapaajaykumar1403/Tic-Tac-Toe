package services;

import builders.AppBuilder;
import models.User;
import repositories.UserDB;

import java.util.Scanner;

public class UserService {
    Scanner sc ;
    UserDB userDB;
    public UserService(){
        this.sc = AppBuilder.getScanner();
        this.userDB = AppBuilder.getUserDB();
    }
    public User registerNewUser(String name, String email, String password){
        // if user already exist ...execption.....
        User user = userDB.createNewUser(name, email, password);
        if(user != null){
            System.out.println("[SERVICE] : User created successfully ");
        }
        return user;
    }
    public User getExistingUser(String email){
        User user = userDB.getUserByEmail(email);
        if(user != null){
            System.out.println("[SERVICE] : User fetched Successfully");
        }
        return  user;
    }
}
