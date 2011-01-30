package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion des
 * labels dans la jsp chargerPartie
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class ChargementBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs pour les labels de la jsp
     * 
     * @since 1.0.0
     */
    private String titre, bouton, modifier;
    
    /**
     * Méthode permettant la récupération
     * des properties pour chargerPartie
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public ChargementBean() throws IOException {
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        titre = myProps.getProperty("app.champs.chatitre");
        bouton = myProps.getProperty("app.champs.chabouton");
        modifier = myProps.getProperty("app.champs.chamodifier");
        MyInputStream.close();
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getBouton() {
        return bouton;
    }

    public void setBouton(String bouton) {
        this.bouton = bouton;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

}
