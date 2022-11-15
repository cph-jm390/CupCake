package dat.backend.model.entities;

import dat.backend.control.Admin;
import dat.backend.model.persistence.ConnectionPool;
import dat.backend.model.persistence.UserMapper;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

//TODO
/*
    load user funktion, tilføj loop for at printe alle users
    public Laaner hentLaanerUdFraId(int laanerId) throws DatabaseException
    {
        Logger.getLogger("web").log(Level.INFO, "laanerId=" + laanerId);
        Laaner laaner = null;
        String sql = "select * from Laaner inner join postnummer using(postnr) " +
                "where laaner_id = ?";
        try (Connection connection = connectionPool.getConnection())
        {
            try (PreparedStatement ps = connection.prepareStatement(sql))
            {
                ps.setInt(1, laanerId);
                ResultSet rs = ps.executeQuery();
                if (rs.next())
                {
                    laanerId = rs.getInt("laaner_id");
                    String navn = rs.getString("navn");
                    String adresse = rs.getString("adresse");
                    int postnummer = rs.getInt("postnr");
                    String by = rs.getString("by");
                    laaner = new Laaner(laanerId, navn, adresse, postnummer, by);
                } else
                {
                    throw new DatabaseException("Låner med laaner_id = " + laanerId + " findes ikke");
                }
            }
        } catch (SQLException ex)
        {
            throw new DatabaseException(ex, "Fejl i databaseforespørgsel for laaner_id = " + laanerId);
        }
        return laaner;
    }

     */
//TODO
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
        this.idShoppinglist = 0;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = 500;
        this.idShoppinglist = 0;
    }

    public User(String username, String password, String role, Timestamp created, int idShoppinglist, int balance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.created = created;
        this.idShoppinglist = idShoppinglist;
        this.balance = balance;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public int getIdShoppinglist() {
        return idShoppinglist;
    }

    public void setIdShoppinglist(int idShoppinglist) {
        this.idShoppinglist = idShoppinglist;
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
