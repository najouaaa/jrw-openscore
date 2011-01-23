package org.jredway.model;

import java.util.ArrayList;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Classe représentant l'entité Utilisateur
 * 
 * @author killian.b
 * @version 1.0.0
 */
@PersistenceCapable(detachable="true")
public class Parcours {
    
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
    public Parcours(User compte, String nomParcours, String depart, int trou[]) {
        int i;
        this.compte = compte;
        this.nomParcours = nomParcours;
        this.depart = depart;
        for(i=1;i<19;i++) {
            this.trou.add(trou[i]);
        }
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
    
}