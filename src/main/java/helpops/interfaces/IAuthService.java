package helpops.interfaces;

import helpops.model.Token;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface RMI du serveur d'authentification (AuthServer).
 * Chaque methode peut lancer RemoteException (obligatoire en RMI).
 */
public interface IAuthService extends Remote {

    /**
     * Connexion : verifie login + mot de passe.
     * Retourne un Token si OK, null sinon.
     */
    Token connecter(String login, String motDePasse) throws RemoteException;

    /**
     * Inscription : cree un nouveau compte.
     * Retourne true si le compte a ete cree, false si le login existe deja.
     */
    boolean inscrire(String login, String motDePasse) throws RemoteException;

    /**
     * Verifie qu'un token est valide (existe + non expire).
     */
    boolean verifierToken(String tokenValeur) throws RemoteException;

    /**
     * Retourne le login associe a un token, ou null si invalide.
     */
    String getLoginDepuisToken(String tokenValeur) throws RemoteException;

    /** Test de connectivite. */
    String ping() throws RemoteException;
}
