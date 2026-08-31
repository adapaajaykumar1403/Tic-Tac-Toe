package services;

import builders.AppBuilder;
import models.User;
import repositories.UserDB;


public class UserService {
    UserDB userDB;
    public UserService(UserDB userDB){
        this.userDB = userDB;
    }
    public User registerNewUser(String name, String email, String password){
        // if user already exist ...execption.....
        return userDB.createNewUser(name, email, password);
    }
    public User getExistingUser(String email){
        return userDB.getUserByEmail(email);
    }
    public int getNumberOfUsers(){
        return userDB.getNumberOfUser();
    }
    public User getUserById(int id){
        return userDB.getUserById(id);
    }
}
