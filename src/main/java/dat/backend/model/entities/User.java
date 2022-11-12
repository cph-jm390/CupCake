package dat.backend.model.entities;

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
    private String username;
    private String password;
    private String role;
    private int balance;
    private int idOrder;

    public User(String username, String password, String role, int balance) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = balance;
        this.idOrder = 0;
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.balance = 500;
        this.idOrder = 0;
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
                "brugerNavn='" + username + '\'' +
                ", kodeord='" + password + '\'' +
                ", rolle='" + role + '\'' +
                '}';
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void payOrder(User user, ShoppingCart cart) {

    }
}
