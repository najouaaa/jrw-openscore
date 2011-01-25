package org.jredway.model;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.jredway.openscore.OpenScoreServlet;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * Classe permettant de gèrer la classe Parcours
 * pour la persistence des données
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("unused")
public class BaseParcours {

    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
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
    public void ajouter(User compte, String nomParours, String depart, ArrayList<Integer> trou, Date date){
        PersistenceManager pm = PMF.get().getPersistenceManager();
        this.parcours = new Parcours(compte, nomParours, depart, trou, date);
        try {
            pm.makePersistent(parcours);
        } finally {
            pm.close();
        }
    }
    
    /**
     * Méthode qui supprime un parcours
     * dans la bdd
     * 
     * @see PMF
     * @param compte
     * @param date
     * @since 1.0.0
     */
    public void supprimer(User compte, Date date) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(Parcours.class);
        query.declareImports("import com.google.appengine.api.users.User; import java.util.Date;");
        query.setFilter("compte == pCompte && dateParcours == pDate");
        query.declareParameters("User pCompte, Date pDate");
        query.deletePersistentAll(compte, date);
    }
    
}
