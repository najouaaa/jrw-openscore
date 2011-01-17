package org.jredway.bean;


import java.util.logging.Logger;

import org.jredway.model.BaseUtilisateur;
import org.jredway.openscore.OpenScoreServlet;


public class UtilisateurBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    private String compte, nom, prenom;
    private int index;
    private boolean existe;

	public UtilisateurBean() {
		BaseUtilisateur membre = new BaseUtilisateur();
		compte = membre.getUtilisateur().getCompte().toString();
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
