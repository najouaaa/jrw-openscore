package org.jredway.dopost;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jredway.model.BaseParcours;
import org.jredway.model.Parcours;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Classe servlet permetteant le
 * chargement du parcours joué voulu
 * 
 * @author killian.b
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class ChargerPartieServlet extends HttpServlet {

    /**
     * Méthode pour la gestion des flux POST
     * 
     * @param req
     * @param resp
     * @since 1.0.0
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String depart;
        String parcours;
        String sKey = (String) req.getParameter("pKey");
        Key pKey = KeyFactory.stringToKey(sKey);
        BaseParcours base = new BaseParcours();
        Parcours tmp = base.charger(pKey);
        
        depart = tmp.getDepart();
        parcours = tmp.getNomParcours();
        
        resp.sendRedirect("/openscore?page=afficherChargerPartie&parcours="+parcours
                            +"&depart="+depart+"&pKey="+sKey);
    }
}
