package helpops.interfaces;

import helpops.model.Incident;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * Interface RMI du serveur principal (HelpOpsServer).
 * Chaque methode prend le token de session en premier parametre.
 */
public interface IHelpOps extends Remote {

    /** Cree un nouvel incident pour l'utilisateur identifie par son token. */
    Incident signalerIncident(String tokenValeur, String categorie, String titre, String description)
        throws RemoteException;

    /** Retourne la liste des incidents de l'utilisateur identifie par son token. */
    List<Incident> listerMesIncidents(String tokenValeur) throws RemoteException;

    /** Retourne le detail d'un incident (s'il appartient bien a l'utilisateur). */
    Incident consulterIncident(String tokenValeur, int id) throws RemoteException;

    /** Test de connectivite. */
    String ping() throws RemoteException;
}
