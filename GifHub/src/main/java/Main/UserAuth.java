package Main;

/**
 * Created by Kurtis Lloyd on 5/16/2016.
 */
public class UserAuth {



    public boolean checkUser(String givenUsername, String givenPassword, String userName, String password){
        boolean passed = false;

        if(givenUsername.equals(userName) ){
            if(givenPassword.equals(password)){
                passed = true;
            }
            else {
                System.out.println("Incorrect Password.");
            }
        }
        else {
            System.out.println("No username with that name.");
        }

        return passed;
    }

}
