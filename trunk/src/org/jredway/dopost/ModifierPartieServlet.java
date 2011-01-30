package org.jredway.dopost;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jredway.model.BaseParcours;
import org.jredway.model.Parcours;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * 
 * @author killian.b
 * @since 1.0.0
 */
@SuppressWarnings("serial")
public class ModifierPartieServlet extends HttpServlet{

    /**
     * Méthode permettant la gestion des flux POST
     * 
     * @param req
     * @param resp
     * @throws IOException
     * @since 1.0.0
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BaseParcours base = new BaseParcours();
        String sKey = (String) req.getParameter("pKey");
        Key pKey = KeyFactory.stringToKey(sKey);
        Parcours partie = base.charger(pKey);
        ArrayList<Integer> trou = new ArrayList<Integer>(); 
        
        for (int i = 1; i < 19; i++) {
            trou.add(Integer.parseInt(req.getParameter("S"+i)));
        }
        partie.setTrou(trou);
        base.modifier(partie);
        resp.sendRedirect("/openscore?page=chargerPartie");
    }
}
