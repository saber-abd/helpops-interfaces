package helpops.interfaces;

import helpops.model.Evenement;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMISupervisionClient extends Remote {
    // Méthode appelée par le serveur vers le client de type AGENT uniquement
    void notifier(Evenement e) throws RemoteException;
}