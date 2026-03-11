package helpops.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class Incident implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private UUID userUuid;
    private String categorie;
    private String titre;
    private String description;
    private String statut;
    private UUID agentUuid;
    private Date dateCreation;
    private Date dateAssignation; // Nouveau pour la V2

    public Incident(int id, UUID userUuid, String categorie, String titre, String description) {
        this.id = id;
        this.userUuid = userUuid;
        this.categorie = categorie;
        this.titre = titre;
        this.description = description;
        this.statut = "OPEN";
        this.dateCreation = new Date();
    }

    // Getters
    public int getId()              { return id; }
    public UUID getUserUuid()       { return userUuid; }
    public String getCategorie()    { return categorie; }
    public String getTitre()        { return titre; }
    public String getDescription()  { return description; }
    public String getStatut()       { return statut; }
    public UUID getAgentUuid()      { return agentUuid; }
    public Date getDateCreation()   { return dateCreation; }
    public Date getDateAssignation(){ return dateAssignation; }

    // --- SETTERS ---

    public void setStatut(String statut) { this.statut = statut; }

    public void setAgentUuid(UUID agentUuid) { this.agentUuid = agentUuid; }

    public void setDateCreation(Date dateCreation) { this.dateCreation = dateCreation; }

    public void setDateAssignation(Date dateAssignation) { this.dateAssignation = dateAssignation; }

    @Override
    public String toString() {
        String agentInfo = (agentUuid != null) ? agentUuid.toString() : "Non assigné";
        return String.format("[#%d] %s | %s | Statut: %s | Créé par: %s | Agent: %s",
                id, titre, categorie, statut, userUuid, agentInfo);
    }
}