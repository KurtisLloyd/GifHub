package Main;

import org.hibernate.annotations.Table;

import javax.persistence.*;

/**
 * Created by Kurtis Lloyd on 5/9/2016.
 */
@Entity
@javax.persistence.Table(name = "user")
public class User {
    @Id @GeneratedValue
    @Column(name ="id")
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

    public User(){
    }

    public User(int id, String userName, String password){
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
