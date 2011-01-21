package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion des
 * déconnexion dans la jsp
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class DeconnexionBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs bean
     * 
     * @see DeconnexionBean#getQuestion()
     * @see DeconnexionBean#getBouton()
     * @since 1.0.0
     */
    private String question, bouton;

    /**
     * Constructeur bean qui charge les properties
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public DeconnexionBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        question = myProps.getProperty("app.champs.questiondeconnexion");
        bouton = myProps.getProperty("app.champs.boutondeconnexion");
        MyInputStream.close();
    }

    public String getQuestion() {
        return question;
    }

    public String getBouton() {
        return bouton;
    }
    
}
