package org.jredway.bean;


import java.util.logging.Logger;

import org.jredway.model.BaseUtilisateur;
import org.jredway.openscore.OpenScoreServlet;

/**
 * Classe bean pour la gestion de
 * l'utilisateur dans la jsp
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class UtilisateurBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Attributs du compte
     * 
     * @see UtilisateurBean#getCompte()
     * @see UtilisateurBean#getNom()
     * @see UtilisateurBean#getPrenom()
     * @since 1.0.0
     */
    private String compte, nom, prenom;
    
    /**
     * Attributs index du compte
     * 
     * @see UtilisateurBean#getIndex()
     * @since 1.0.0
     */
    private int index;
    
    /**
     * Variable booléenne pour
     * vérifier si l'uitlisateur courant
     * existe
     * 
     * @see UtilisateurBean#isExiste()
     * @since 1.0.0
     */
    private boolean existe;

    /**
     * Constructeur du Bean
     * 
     * @since 1.0.0
     */
	public UtilisateurBean() {
		BaseUtilisateur membre = new BaseUtilisateur();
		compte = membre.getUtilisateur().getCompte().getNickname();
		nom = membre.getUtilisateur().getNom();
		prenom = membre.getUtilisateur().getPrenom();
		index = membre.getUtilisateur().getIndex();
		existe = membre.existe();
		log.info(compte);
    }

	public boolean isExiste() {
		return existe;
	}

	public String getCompte() {
		return compte;
	}

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getIndex() {
        return index;
    }
    
}
