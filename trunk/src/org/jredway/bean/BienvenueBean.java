package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion du
 * message d'acceuil dans la jsp
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class BienvenueBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs du bean
     * 
     * @see BienvenueBean#getTitre()
     * @see BienvenueBean#getMessage()
     * @since 1.0.0
     */
    private String titre, message;

    /**
     * Constructeur bean qui charge les properties
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public BienvenueBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        titre = myProps.getProperty("app.champs.titrebienvenue");
        message = myProps.getProperty("app.champs.messagebienvenue");
        MyInputStream.close();
    }
    
    public String getTitre() {
        return titre;
    }

    public String getMessage() {
        return message;
    }
    
}
