package Main;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kurtis Lloyd on 5/26/2016.
 */
public class UserCreation {

    public void writeUserToDatabase(String username, String password) {
        User user = new User();
        user.setUserName(username);
        user.setPassword(password);

        HibernateQuery hibernate = new HibernateQuery();

        hibernate.makeTransaction();
        hibernate.saveTransaction(user);
        hibernate.endTrasaction();
    }

    public boolean userCreated(String username, String password){

        HibernateQuery hibernateQuery = new HibernateQuery();
        List<User> userList = new ArrayList<>();

            userList = hibernateQuery.writeQuery("FROM User");

            for (User u : userList) {
                if(u.getUserName().equals(username)){
                    System.out.println("User already exists.");
                    return false;
                }
                else{

                    writeUserToDatabase(username, password);
                    return true;
                }
            }
        return false;
    }
}
