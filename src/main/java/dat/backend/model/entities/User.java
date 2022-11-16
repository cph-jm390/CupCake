package dat.backend.model.entities;

import java.sql.Timestamp;
import java.util.Objects;

public class User {
    private Timestamp created;
    private String username;
    private String password;
    private String role;
    private int balance;
    private int idShoppinglist;

    public User(String username, String password, String role, int balance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = getBalance();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public int getIdShoppinglist() {
        return idShoppinglist;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getUsername().equals(user.getUsername()) && getPassword().equals(user.getPassword()) &&
                getRole().equals(user.getRole());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword(), getRole());
    }

    @Override
    public String toString() {
        return "User{" +
                "created=" + created +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", balance=" + balance +
                ", idShoppinglist=" + idShoppinglist +
                '}';
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void payCupcake(User user, ShoppingCart cart) {
    }

}

