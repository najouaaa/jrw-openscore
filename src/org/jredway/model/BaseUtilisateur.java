package org.jredway.model;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import java.util.List;


public class BaseUtilisateur {
    
    private Utilisateur membre;
    private UserService userService = UserServiceFactory.getUserService();
    private User user = userService.getCurrentUser();
    
    // constructeur
    public BaseUtilisateur(){
        
    }
    
    // méthode ajouter un utilisateur
    public void ajouter(User compte, String nom, String prenom, int index){
        PersistenceManager pm = PMF.get().getPersistenceManager();
        this.membre = new Utilisateur(compte, nom, prenom, index);
        try {
            pm.makePersistent(membre);
        } finally {
            pm.close();
        }
    }
    
    // supprimer un utilisateur
    public void supprimer(User compte) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(Utilisateur.class,":p.contains(compte)");
        query.deletePersistentAll(compte);
    }
    
    // créer un objet détachable pour la modif car sinon impossible
    @SuppressWarnings("unchecked")
    public Utilisateur getUtilisateur() {
        
        
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Utilisateur uti, detached = null;
        
        Query query = pm.newQuery(Utilisateur.class,":p.contains(compte)");
        List<Utilisateur> results = (List<Utilisateur>) query.execute(this.user);
        
        try {
            uti = pm.getObjectById(Utilisateur.class,
                    results.get(0).getKey().getId());
            detached = pm.detachCopy(uti);
        } finally {
            pm.close();
        }
        return detached;
    }
    
    // simple envoie des nouvelles informations
    public void modifier(Utilisateur e) {
        PersistenceManager pm = PMF.get().getPersistenceManager();
        try {
            pm.makePersistent(e);
        } finally {
            pm.close();
        }
    }
    
    // teste si l'utilisateur courant existe
    public boolean existe(){
        PersistenceManager pm = PMF.get().getPersistenceManager();
        boolean res = false;

        try {
            Query query = pm.newQuery(Utilisateur.class,":p.contains(compte)");
            if(query.execute(this.user).toString() != "[]"){
                res = true;
            }


        } finally {
            pm.close();
        }
        
        return res;
    }
}
