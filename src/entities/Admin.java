package entities;

import java.util.Objects;

public class Admin {
    private String username;
    private String password;


    // Constructors

    public Admin(){

    }

    //Constructor with the attributes
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }

    // Getters & Setters

    public void setUsername(String username){
        this.password = password;
    }

    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(username, admin.username) && Objects.equals(password, admin.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
