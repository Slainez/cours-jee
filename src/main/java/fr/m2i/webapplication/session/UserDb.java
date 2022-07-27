
package fr.m2i.webapplication.session;


import java.util.ArrayList;
import java.util.List;


public class UserDb {
    
    private static UserDb _instance ;
    
    
    private static String _dbUser = "root";
    private static String _dbPass = "root" ;
    
    private static List<User> users = new ArrayList() {{
        add(new User("admin@admin.com", "admin", Role.ADMIN));
        add(new User("user@user.com", "user", Role.USER));
    }};
    
    private UserDb(){
        
    }
    
    
    public static UserDb getInstance(String dbUser, String dbPass){
        if (!_dbUser.equals(dbUser) || !_dbPass.equals(dbPass)){
            return null ;
        }
        
        if (_instance == null){
            _instance = new UserDb();
        }
        return _instance ;
    }

    public  User checkUser(String email, String password) {
        
        if (email == null || password == null) {
            return null;
        }

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public List<User> getUsers() {
        return users;
    }
    
}
