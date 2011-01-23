package org.jredway.model;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.util.List;

/**
 * Classe permettant de gèrer la classe Parcours
 * pour la persistence des données
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class BaseParcours {

    private Parcours parcours;
    private UserService userService = UserServiceFactory.getUserService();
    private User user = userService.getCurrentUser();
    
    /**
     * constructeur sans paramètres
     * 
     * @since 1.0.0
     */
    public BaseParcours(){
        
    }
    
    /**
     * Méthode qui ajoute un parcours dans la bdd
     * utilise la persistence
     * 
     * @see PMF
     * @param compte
     * @param nom
     * @param prenom
     * @param index
     * @since 1.0.0
     */
    public void ajouter(User compte, String nomParours, String depart, int trou[]){
        PersistenceManager pm = PMF.get().getPersistenceManager();
        this.parcours = new Parcours(compte, nomParours, depart, trou);
        try {
            pm.makePersistent(parcours);
        } finally {
            pm.close();
        }
    }
    
}
