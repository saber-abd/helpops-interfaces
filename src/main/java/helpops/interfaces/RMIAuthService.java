package helpops.interfaces;

import helpops.model.Token;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIAuthService extends Remote {  //interface RMI pour authentification
    Token connecter(String login, String motDePasse) throws RemoteException;  // return le token si reussi sinon null
    boolean inscrire(String login, String motDePasse) throws RemoteException; // return true ou false selon le resultat
    boolean verifierToken(String tokenValeur) throws RemoteException; // return aussi true ou false selon la validite
    String getLoginDepuisToken(String tokenValeur) throws RemoteException;  // return le login associe au token sinon null
    String ping() throws RemoteException;  // test connexion RMI
}
