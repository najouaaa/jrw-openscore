package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion des
 * labels dans la jsp creationScore
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class CreationScoreBean {

    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs pour les labels de la jsp
     * 
     * @since 1.0.0
     */
    private String trou, par, distance, hcp, score, retour, sauve;
    
    /**
     * Méthode permettant la récupération
     * des properties pour CreationScore
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public CreationScoreBean() throws IOException {
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        trou = myProps.getProperty("app.champs.tabtrou");
        par = myProps.getProperty("app.champs.tabpar");
        hcp = myProps.getProperty("app.champs.tabhcp");
        distance = myProps.getProperty("app.champs.tabdistance");
        score = myProps.getProperty("app.champs.tabscore");
        retour = myProps.getProperty("app.champs.bnretour");
        sauve = myProps.getProperty("app.champs.bnsauvegarder");
        MyInputStream.close();
    }

    public String getTrou() {
        return trou;
    }

    public void setTrou(String trou) {
        this.trou = trou;
    }

    public String getPar() {
        return par;
    }

    public void setPar(String par) {
        this.par = par;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getHcp() {
        return hcp;
    }

    public void setHcp(String hcp) {
        this.hcp = hcp;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRetour() {
        return retour;
    }

    public void setRetour(String retour) {
        this.retour = retour;
    }

    public String getSauve() {
        return sauve;
    }

    public void setSauve(String sauve) {
        this.sauve = sauve;
    }
    
}
