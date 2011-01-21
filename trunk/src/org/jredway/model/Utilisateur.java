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
 * @author killian.b
 * @version 1.0.0
 */
@PersistenceCapable(detachable="true")
public class Utilisateur {
    
    /**
     * Champs clé primaire
     * généré automatiquement
     * 
     * @see Utilisateur#getKey()
     * @see Utilisateur#setKey(Key)
     * @since 1.0.0
     */
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    /**
     * Champs compte
     * 
     * @see Utilisateur#getCompte()
     * @see Utilisateur#setCompte(User)
     * @since 1.0.0
     */
    @Persistent
    private User compte;
    
    /**
     * Champs nom
     * 
     * @see Utilisateur#getNom()
     * @see Utilisateur#setNom(String)
     * @since 1.0.0
     */
    @Persistent
    private String nom;
    
    /**
     * Champs prénom
     * 
     * @see Utilisateur#getPrenom()
     * @see Utilisateur#setPrenom(String)
     * @since 1.0.0
     */
    @Persistent
    private String prenom;
    
    /**
     * Champs index
     * 
     * @see Utilisateur#getIndex()
     * @see Utilisateur#setIndex(int)
     * @since 1.0.0
     */
    @Persistent
    private int index;
    
    /**
     * Constructeur de l'entité
     * 
     * @param compte
     * @param nom
     * @param prenom
     * @param index
     * @since 1.0.0
     */
    public Utilisateur(User compte, String nom, String prenom,int index) {
        this.compte = compte;
        this.nom = nom;
        this.prenom = prenom;
        this.index = index;
    }

    /**
     * Retourne la clé généré
     * 
     * @return key
     * @since 1.0.0
     */
    public Key getKey() {
        return key;
    }

    /**
     * Modifie la clé
     * 
     * @param key
     * @since 1.0.0
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Retourne le compte User
     * 
     * @return compte
     * @since 1.0.0
     */
    public User getCompte() {
        return compte;
    }

    /**
     * Modifie le compte User
     * 
     * @param compte
     * @since 1.0.0
     */
    public void setCompte(User compte) {
        this.compte = compte;
    }

    /**
     * Retourne le nom associé au compte
     * 
     * @return nom
     * @since 1.0.0
     */
    public String getNom() {
        return nom;
    }

    /**
     * Modifie le nom associé au compte
     * 
     * @param nom
     * @since 1.0.0
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le prénom associé au compte 
     * 
     * @return prenom
     * @since 1.0.0
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Modifie le prenom associé au compte
     * 
     * @param prenom
     * @since 1.0.0
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Modifie l'index de l'entité
     * 
     * @param index
     * @since 1.0.0
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * Retourne l'index de l'entité
     * 
     * @return index
     * @since 1.0.0
     */
    public int getIndex() {
        return index;
    } 

}
