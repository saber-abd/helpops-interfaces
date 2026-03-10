package helpops.interfaces;

import helpops.model.Token;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

/**
 * Contrat RMI : Service d'Authentification .
 * Gère le cycle de vie des utilisateurs, la validation des accès et le contrôle des rôles.
 */
public interface RMIAuthService extends Remote {  //interface RMI pour authentification
    Token connecter(String login, String motDePasse) throws RemoteException;  // return le token si reussi sinon null
    boolean inscrire(String login, String motDePasse) throws RemoteException; // return true ou false selon le resultat, en cas de reusitte connecte directement l'utilisateur
    boolean verifierToken(String tokenValeur) throws RemoteException; // return aussi true ou false selon la validite
    UUID getUuidDepuisToken(String tokenValeur) throws RemoteException;
    String ping() throws RemoteException;  // test connexion RMI
    boolean changerRole(String tokenAgent, UUID utilisateurAChanger, String nouveauRole) throws RemoteException; // V2 : Administration des privilèges
    String getRoleDepuisToken(String tokenValeur) throws RemoteException; // V2 : Validatio pour le serveur d'incident, ermet de vérifier à la fois si le token est bon ET quel est son rôle
}
