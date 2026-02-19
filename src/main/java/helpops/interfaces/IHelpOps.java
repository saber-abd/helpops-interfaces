package helpops.interfaces;

import helpops.model.Incident;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IHelpOps extends Remote {
    Incident signalerIncident(String tokenValeur, String categorie, String titre, String description)
        throws RemoteException;

    List<Incident> listerMesIncidents(String tokenValeur) throws RemoteException;

    Incident consulterIncident(String tokenValeur, int id) throws RemoteException;

    String ping() throws RemoteException;
}
