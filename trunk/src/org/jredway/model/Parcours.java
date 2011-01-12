package org.jredway.model;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.users.User;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class Parcours {
    
    @PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private Key key;

    @Persistent
    private User compte;
    
    @Persistent
    private String nomParcours;
    
    @Persistent
    private int trou[] = new int[18];
    
    @Persistent
    private int SSJ;
    
    @Persistent
    private String depart;
    
    public Parcours() {
        
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

    public int[] getTrou() {
        return trou;
    }

    public void setTrou(int[] trou) {
        this.trou = trou;
    }

    public int getSSJ() {
        return SSJ;
    }

    public void setSSJ(int sSJ) {
        SSJ = sSJ;
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