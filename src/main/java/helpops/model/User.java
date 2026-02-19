package helpops.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;
    private String motDePasseHash; // SHA-256 en hexadecimal
    private String role;           // "UTILISATEUR" ou "AGENT"

    public User(String login, String motDePasseHash, String role) {
        this.login = login;
        this.motDePasseHash = motDePasseHash;
        this.role = role;
    }

    public String getLogin()          { return login; }
    public String getMotDePasseHash() { return motDePasseHash; }
    public String getRole()           { return role; }

    @Override
    public String toString() {
        return login + " [" + role + "]";
    }
}
