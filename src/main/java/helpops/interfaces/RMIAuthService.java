package helpops.interfaces;

import helpops.model.Token;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

// Contrat RMI : Service d'Authentification
public interface RMIAuthService extends Remote {
    Token connecter(String login, String motDePasse) throws RemoteException;
    boolean inscrire(String login, String motDePasse) throws RemoteException;
    // v3 inscription avec choix du role (phase de tests uniquement)
    boolean inscrireAvecRole(String login, String motDePasse, String role) throws RemoteException;
    boolean verifierToken(String tokenValeur) throws RemoteException;

    UUID getUuidDepuisToken(String tokenValeur) throws RemoteException;
    // v3 recupere l'UUID d'un utilisateur par son login (pour creation ticket par agent)
    UUID getUuidDepuisLogin(String login) throws RemoteException;
    String ping() throws RemoteException;
    boolean changerRole(String tokenAgent, UUID utilisateurAChanger, String nouveauRole) throws RemoteException;
    String getRoleDepuisToken(String tokenValeur) throws RemoteException;
}
