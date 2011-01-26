package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion des
 * labels dans la jsp creationPartie
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class CreationPartieBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs pour les labels de la jsp
     * 
     * @since 1.0.0
     */
    private String titre, menu, depart, bouton;
    
    /**
     * Attributs pour les labels de la jsp
     * 
     * @since 1.0.0
     */
    private String cNoir, cBlanc, cJaune, cBleu, cRouge;
    
    /**
     * Méthode permettant la récupération
     * des properties pour CreationPartie
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public CreationPartieBean() throws IOException {
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        titre = myProps.getProperty("app.champs.titrenvpartie");
        menu = myProps.getProperty("app.champs.menunvpartie");
        depart = myProps.getProperty("app.champs.departnvpartie");
        bouton = myProps.getProperty("app.champs.boutonnvpartie");
        cNoir = myProps.getProperty("app.champs.departnoir");
        cBlanc = myProps.getProperty("app.champs.departblanc");
        cJaune = myProps.getProperty("app.champs.departjaune");
        cBleu = myProps.getProperty("app.champs.departbleu");
        cRouge = myProps.getProperty("app.champs.departrouge");
        MyInputStream.close();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getBouton() {
        return bouton;
    }

    public void setBouton(String bouton) {
        this.bouton = bouton;
    }

    public String getcNoir() {
        return cNoir;
    }

    public void setcNoir(String cNoir) {
        this.cNoir = cNoir;
    }

    public String getcBlanc() {
        return cBlanc;
    }

    public void setcBlanc(String cBlanc) {
        this.cBlanc = cBlanc;
    }

    public String getcJaune() {
        return cJaune;
    }

    public void setcJaune(String cJaune) {
        this.cJaune = cJaune;
    }

    public String getcBleu() {
        return cBleu;
    }

    public void setcBleu(String cBleu) {
        this.cBleu = cBleu;
    }

    public String getcRouge() {
        return cRouge;
    }

    public void setcRouge(String cRouge) {
        this.cRouge = cRouge;
    }

}
