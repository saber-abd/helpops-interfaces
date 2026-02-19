package helpops.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Token implements Serializable {
    private static final long serialVersionUID = 1L;

    private String valeur; 
    private String login;    
    private Date expiration; 

    public Token(String login) {
        this.valeur = UUID.randomUUID().toString();
        this.login = login;
        this.expiration = new Date(System.currentTimeMillis() + 3600_000); // +1h
    }

    public boolean estValide() {
        return new Date().before(expiration);
    }

    public String getValeur()    { return valeur; }
    public String getLogin()     { return login; }
    public Date   getExpiration(){ return expiration; }

    @Override
    public String toString() {
        return "[Token " + valeur.substring(0, 8) + "... | login=" + login + "]";
    }
}
