package helpops.interfaces;

import helpops.model.Incident;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIHelpOps extends Remote {
    Incident signalerIncident(String tokenValeur, String categorie, String titre, String description)
        throws RemoteException;
    List<Incident> listerMesIncidents(String tokenValeur) throws RemoteException;
    Incident consulterIncident(String tokenValeur, int id) throws RemoteException;

    List<Incident> listerIncidentsOuverts(String tokenValeur) throws RemoteException;// Liste tous les incidents avec statut 'OPEN'

    boolean prendreEnChargeIncident(String tokenValeur, int id) throws RemoteException;//prise en charge d'un incident

    List<Incident> listerMesAssignations(String tokenValeur) throws RemoteException;// Liste incidents assignés spécifiquement à l'agent connecté

    List<Incident> listerTousLesIncidents(String tokenValeur) throws RemoteException;

    String ping() throws RemoteException;



}
