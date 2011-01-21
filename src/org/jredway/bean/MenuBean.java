package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean qui charge les properties
 * pour la jsp menu
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class MenuBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs pour les labels de la jsp
     * 
     * @since 1.0.0
     */
    private String lBonjour, lIndex, lCompte, lPartie, lTitrePartie, lTitreProfile, lAjouter, lCharger, lSupprimer, lModifier, lDeconnexion;

    /**
     * Constructeur du bean qui charge les properties
     * 
     * @throws IOException
     * @since 1.0.0
     */
    public MenuBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        lBonjour = myProps.getProperty("app.champs.labelbonjour");
        lIndex = myProps.getProperty("app.champs.labelindex");
        lCompte = myProps.getProperty("app.champs.labelcompte");
        lPartie = myProps.getProperty("app.champs.labelpartie");
        lTitrePartie = myProps.getProperty("app.champs.titremenupartie");
        lTitreProfile = myProps.getProperty("app.champs.titremenuprofile");
        lAjouter = myProps.getProperty("app.champs.sstitrepartieajouter");
        lCharger = myProps.getProperty("app.champs.sstitrepartiecharger");
        lSupprimer = myProps.getProperty("app.champs.sstitrepartiesupprimer");
        lModifier = myProps.getProperty("app.champs.sstitrepartiemodifier");
        lDeconnexion = myProps.getProperty("app.champs.sstitrepartiedeconnexion");
        MyInputStream.close();
    }

	public String getlBonjour() {
		return lBonjour;
	}

	public String getlIndex() {
		return lIndex;
	}

	public String getlCompte() {
		return lCompte;
	}

	public String getlPartie() {
		return lPartie;
	}

	public String getlTitrePartie() {
		return lTitrePartie;
	}

	public String getlTitreProfile() {
		return lTitreProfile;
	}

	public String getlAjouter() {
		return lAjouter;
	}

	public String getlCharger() {
		return lCharger;
	}

	public String getlSupprimer() {
		return lSupprimer;
	}

	public String getlModifier() {
		return lModifier;
	}

	public String getlDeconnexion() {
		return lDeconnexion;
	}
    
}