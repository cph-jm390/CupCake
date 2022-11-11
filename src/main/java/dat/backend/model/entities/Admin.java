package dat.backend.model.entities;

import dat.backend.model.persistence.UserFacade;

public class Admin extends UserFacade {
    private String username;
    private String password;
    private String role;

    public Admin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }
}