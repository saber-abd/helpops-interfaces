package helpops.model;

import java.io.Serializable;
import java.util.Date;

public class Incident implements Serializable {
    private static final long serialVersionUID = 1L;  // serial RMI
    private int    id;
    private String categorie;
    private String titre;
    private String description;
    private String statut;
    private String login;
    private Date   dateCreation;

    public Incident(int id, String categorie, String titre, String description, String login) {  // constructeur
        this.id = id;
        this.categorie = categorie;
        this.titre = titre;
        this.description = description;
        this.login = login;
        this.statut = "OUVERT"; // statut initial pour l'instant car pas besoin de plus pour la V1
        this.dateCreation = new Date();
    }

    public int    getId()          { return id; }

    public String getCategorie()   { return categorie; }

    public String getTitre()       { return titre; }

    public String getDescription() { return description; }

    public String getStatut()      { return statut; }

    public String getLogin()       { return login; }

    public Date   getDateCreation(){ return dateCreation; }

    public void setStatut(String statut) { this.statut = statut; } // pour changer le statut de l'incident plus tard lors de la V2

    @Override
    public String toString() {  // formatage affichage incident
        return String.format("[#%d] %s | %s | %s | %s | %s",
            id, titre, categorie, statut, login, dateCreation);
    }
}
