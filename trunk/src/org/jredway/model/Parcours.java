package org.jredway.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe représentant l'entité Utilisateur
 * 
 * @author killian.b
 * @version 1.0.0
 */
@PersistenceCapable(detachable="true")
public class Parcours {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Champs clé primaire
     * généré automatiquement
     * 
     * @see Parcours#getKey()
     * @see Parcours#setKey(Key)
     * @since 1.0.0
     */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    /**
     * Champs compte
     * 
     * @see Parcours#getCompte()
     * @see Parcours#setCompte(User)
     * @since 1.0.0
     */
    @Persistent
    private User compte;
    
    /**
     * Champs nom du parcours
     * 
     * @see Parcours#getNomParcours()
     * @see Parcours#setNomParcour(nomParcours)
     * @since 1.0.0
     */
    @Persistent
    private String nomParcours;
    
    /**
     * Champs date du parcours
     * 
     * @see Parcours#getDateParcours()
     * @see Parcours#setDateParcours(dateParcours)
     * @since 1.0.0
     */
    @Persistent
    private Date dateParcours;
    
    /**
     * Champs nom du parcours
     * 
     * @see Parcours#getNomParcours()
     * @see Parcours#setNomParcours(nomParcours)
     * @since 1.0.0
     */
    @Persistent
    private ArrayList<Integer> trou;
;
    
    /**
     * Champs couleur départ
     * 
     * @see Parcours#getDepart()
     * @see Parcours#setDepart(depart)
     * @since 1.0.0
     */
    @Persistent
    private String depart;
    
    /**
     * Constructeur de l'entité
     * 
     * @param compte
     * @param nomParcours
     * @param depart
     * @param trou
     */
    public Parcours(User compte, String nomParcours, String depart, ArrayList<Integer> trou, Date date) {
        
        log.info("5.5");
        this.compte = compte;
        this.nomParcours = nomParcours;
        this.depart = depart;
        this.trou = trou;
        log.info("6.5");
        this.dateParcours = date;
    }
    
    public User getCompte() {
        return compte;
    }

    public void setCompte(User compte) {
        this.compte = compte;
    }

    public String getNomParcours() {
        return nomParcours;
    }

    public void setNomParcours(String nomParcours) {
        this.nomParcours = nomParcours;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public Key getKey() {
        return key;
    }

    public void setDateParcours(Date dateParcours) {
        this.dateParcours = dateParcours;
    }

    public Date getDateParcours() {
        return dateParcours;
    }

    public void setTrou(ArrayList<Integer> trou) {
        this.trou = trou;
    }

    public ArrayList<Integer> getTrou() {
        return trou;
    }
    
}