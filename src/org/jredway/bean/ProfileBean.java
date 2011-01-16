package org.jredway.bean;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;


public class ProfileBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    private String titreCreation, titreModifier, nom, prenom, index;

    public ProfileBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        titreCreation = myProps.getProperty("app.champs.titrecreation");
        titreModifier = myProps.getProperty("app.champs.titremodifier");
        nom = myProps.getProperty("app.champs.nomprofile");
        prenom = myProps.getProperty("app.champs.prenomprofile");
        index = myProps.getProperty("app.champs.indexprofile");
        MyInputStream.close();
    }

    public String getTitreCreation() {
        return titreCreation;
    }

    public String getTitreModifier() {
        return titreModifier;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getIndex() {
        return index;
    }
    
}