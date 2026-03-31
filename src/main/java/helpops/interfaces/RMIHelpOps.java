package helpops.interfaces;

import helpops.model.Incident;
import helpops.model.Statistiques;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Interface RMI pour la gestion des incidents
public interface RMIHelpOps extends Remote {
    Incident signalerIncident(String tokenValeur, String categorie, String titre, String description)
        throws RemoteException;
    List<Incident> listerMesIncidents(String tokenValeur) throws RemoteException;
    Incident consulterIncident(String tokenValeur, int id) throws RemoteException;

    List<Incident> listerIncidentsOuverts(String tokenValeur) throws RemoteException;
    boolean prendreEnChargeIncident(String tokenValeur, int id) throws RemoteException;
    List<Incident> listerMesAssignations(String tokenValeur) throws RemoteException;
    List<Incident> listerTousLesIncidents(String tokenValeur) throws RemoteException;

    // v3 cloture ticket par agent assigne
    boolean resoudreTicket(String tokenValeur, int id, String messageResolution) throws RemoteException;
    // v3 creation ticket par agent pour utilisateur donne (par login)
    Incident creerTicketPourUtilisateur(String tokenValeur, String loginCible, String categorie, String titre, String description) throws RemoteException;
    // v3 statistiques fonctionnement
    Statistiques getStatistiques(String tokenValeur) throws RemoteException;
    String ping() throws RemoteException;

    //V3 supervision
    void sAbonner(String tokenValeur, RMISupervisionClient client) throws RemoteException;
    void seDesabonner(String tokenValeur, RMISupervisionClient client) throws RemoteException;
}
