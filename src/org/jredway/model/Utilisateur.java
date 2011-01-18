package org.jredway.model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * Entité Utilisateur
 * 
 * @author killian
 * @version 1.0.0
 */
@PersistenceCapable(detachable="true")
public class Utilisateur {
    
    /**
     * Champs clé primaire
     * 
     * @see 
     * @since 1.0.0
     */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private User compte;
    
    @Persistent
    private String nom;
    
    @Persistent
    private String prenom;
    
    @Persistent
    private int index;
    
    public Utilisateur(User compte, String nom, String prenom,int index) {
        this.compte = compte;
        this.nom = nom;
        this.prenom = prenom;
        this.index = index;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public User getCompte() {
        return compte;
    }

    public void setCompte(User compte) {
        this.compte = compte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    } 

}
