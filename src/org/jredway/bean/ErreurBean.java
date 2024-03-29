package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion des
 * erreur dans la jsp
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class ErreurBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs du bean
     * 
     * @see ErreurBean#getTitre()
     * @see ErreurBean#getMessage()
     * @see ErreurBean#getBouton()
     * @since 1.0.0
     */
    private String titre, message, bouton;

    /**
     * Cosntructeur bean qui charge les properties
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public ErreurBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        titre = myProps.getProperty("app.champs.titreerreur");
        message = myProps.getProperty("app.champs.messageerreur");
        bouton = myProps.getProperty("app.champs.boutonerreur");
        MyInputStream.close();
    }

	public String getTitre() {
		return titre;
	}

	public String getMessage() {
		return message;
	}

	public String getBouton() {
		return bouton;
	}
    
}