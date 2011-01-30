package org.jredway.dopost;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jredway.model.BaseParcours;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Classe servlet permettant la
 * suppression partie
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class SupprimerPartieServlet extends HttpServlet {
    
    /**
     * Méthode de gestion des flux POST
     * 
     * @param req
     * @param resp
     * @since 1.0.0
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BaseParcours supParcours = new BaseParcours();
        
        Key pKey = KeyFactory.stringToKey((String) req.getParameter("pKey")); 
        supParcours.supprimer(pKey);
        resp.sendRedirect("/openscore?page=supprimerPartie");
    }
}
