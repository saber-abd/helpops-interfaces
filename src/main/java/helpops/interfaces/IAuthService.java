package helpops.interfaces;

import helpops.model.Token;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAuthService extends Remote {
    Token connecter(String login, String motDePasse) throws RemoteException;
    boolean inscrire(String login, String motDePasse) throws RemoteException;
    boolean verifierToken(String tokenValeur) throws RemoteException;
    String getLoginDepuisToken(String tokenValeur) throws RemoteException;
    String ping() throws RemoteException;
}
