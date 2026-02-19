package helpops.model;

import java.io.Serializable;
import java.util.Date;

public class Incident implements Serializable {
    private static final long serialVersionUID = 1L;

    private int    id;
    private String categorie;
    private String titre;
    private String description;
    private String statut;
    private String login;
    private Date   dateCreation;

    public Incident(int id, String categorie, String titre, String description, String login) {
        this.id = id;
        this.categorie = categorie;
        this.titre = titre;
        this.description = description;
        this.login = login;
        this.statut = "OUVERT";
        this.dateCreation = new Date();
    }

    public int    getId()          { return id; }
    public String getCategorie()   { return categorie; }
    public String getTitre()       { return titre; }
    public String getDescription() { return description; }
    public String getStatut()      { return statut; }
    public String getLogin()       { return login; }
    public Date   getDateCreation(){ return dateCreation; }

    public void setStatut(String statut) { this.statut = statut; }

    @Override
    public String toString() {
        return String.format("[#%d] %s | %s | %s | %s | %s",
            id, titre, categorie, statut, login, dateCreation);
    }
}
