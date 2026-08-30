package repositories;

import models.User;

import java.util.HashMap;

public class UserDB {
    private HashMap<String, User> userMap;

    public UserDB(){
        this.userMap = new HashMap<>();
    }

    public void saveUser(User user){
        String email = user.getEmail();
        this.userMap.put(email, user);
    }
    public int generateID(){
        return this.userMap.size()+1;
    }
    public User getUserByEmail(String email){
//        if(!this.userMap.containsKey((email)))
//            return null;
        return this.userMap.get(email);
    }

    public User createNewUser(String name, String email, String password){
        int id = generateID();
        User user = new User(id, name, email, password);
        saveUser(user);
        return user;
    }


}
