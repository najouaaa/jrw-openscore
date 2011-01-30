package org.jredway.model;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import org.jredway.openscore.OpenScoreServlet;

import com.google.appengine.api.datastore.Key;
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
     * @param nomParcours
     * @param depart
     * @param trou
     * @param date
     * @since 1.0.0
     */
    public void ajouter(User compte, String nomParcours, String depart, ArrayList<Integer> trou, Date date){
        PersistenceManager pm = PMF.get().getPersistenceManager();
        this.parcours = new Parcours(compte, nomParcours, depart, trou, date);
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
     * @param key
     * @since 1.0.0
     */
    public void supprimer(Key key) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(Parcours.class,":p.contains(key)");
        query.deletePersistentAll(key);
    }
    
    /**
     * Méthode qui charge de l'utilisateur
     * en fonction d'une date
     * 
     * @param key
     * @return detached
     */
    @SuppressWarnings("unchecked")
    public Parcours charger(Key key) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Parcours uti, detached = null;
        
        Query query = pm.newQuery(Parcours.class,":p.contains(key)");
        List<Parcours> results = (List<Parcours>) query.execute(key);
        
        try {
            uti = pm.getObjectById(Parcours.class,
                    results.get(0).getKey().getId());
            detached = pm.detachCopy(uti);
        } finally {
            pm.close();
        }
        return detached;
    }
    
    /**
     * Mise à jour des informations du
     * parcours envoyer en paramètre
     * 
     * @see PMF
     * @param e
     * @since 1.0.0
     */
    public void modifier(Parcours e) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(e);
        } finally {
            pm.close();
        }
    }
    
}
