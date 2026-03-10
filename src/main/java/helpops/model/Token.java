package helpops.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Objet de session circulant entre le client et les serveurs.
 * Contient les privilèges de l'utilisateur et expire après 1 heure.
 */
public class Token implements Serializable {
    private static final long serialVersionUID = 1L;

    private String valeur;
    private String login;
    private UUID userUuid;
    private String role;
    private Date expiration;

    // Constructeur complet pour la V2
    // Dans Token.java
    public Token(String valeur, String login, UUID userUuid, String role) {
        this.valeur = valeur;
        this.login = login;
        this.userUuid = userUuid;
        this.role = role;
        this.expiration = new Date(System.currentTimeMillis() + 3600_000);
    }
    public boolean estValide() {
        return new Date().before(expiration);
    }

    // Getters
    public String getValeur()   { return valeur; }
    public String getLogin()    { return login; }
    public UUID getUserUuid()   { return userUuid; }
    public String getRole()     { return role; }

    @Override
    public String toString() {
        return "Token[" + login + " | Role: " + role + "]";
    }

    public boolean estAgent() {
        return "AGENT".equalsIgnoreCase(this.role);
    }
}