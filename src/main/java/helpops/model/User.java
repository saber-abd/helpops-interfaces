package helpops.model;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;  // serial RMI
    private String login;
    private String motDePasseHash; // SHA-256 en hexadecimal car plus simple a stocker et comparer
    private String role;           // "UTILISATEUR" pour l'instant en V1, plus tard il y aura les autres roles

    public User(String login, String motDePasseHash, String role) {
        this.login = login;
        this.motDePasseHash = motDePasseHash;
        this.role = role;
    }

    public String getLogin()          { return login; }

    public String getMotDePasseHash() { return motDePasseHash; }

    public String getRole()           { return role; }  // utile plus tard

    @Override
    public String toString() {
        return login + " [" + role + "]";
    }
}
