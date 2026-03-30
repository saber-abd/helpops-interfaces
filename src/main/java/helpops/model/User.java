package helpops.model;

import java.io.Serializable;
import java.util.UUID;

public class User implements Serializable {
    private static final long serialVersionUID = 1L; // serial RMI

    private UUID userUuid;
    private String login;
    private String motDePasseHash;
    private String role;

    public User(UUID userUuid, String login, String motDePasseHash, String role) {
        this.userUuid = userUuid;
        this.login = login;
        this.motDePasseHash = motDePasseHash;
        this.role = role;}

    // getters
    public UUID getUserUuid()         { return userUuid; }

    public String getLogin()          { return login; }

    public String getMotDePasseHash() { return motDePasseHash; }

    public String getRole()           { return role; }

    public void setRole(String role)  { this.role = role; }

    @Override
    public String toString() {
        return String.format("%s [%s] (ID: %s)", login, role, userUuid);
    }
}