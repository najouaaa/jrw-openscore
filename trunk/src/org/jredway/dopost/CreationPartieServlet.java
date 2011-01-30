package org.jredway.dopost;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jredway.model.BaseParcours;
import org.jredway.tools.JDate;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Classe servlet permettant la gestion des saisi
 * de score pour CreationPartie
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class CreationPartieServlet extends HttpServlet {
    
    private UserService userService = UserServiceFactory.getUserService();
    private User user = userService.getCurrentUser();
    
    /**
     * Méthode permettant la gestion des flux GET
     * 
     * @param req
     * @param resp
     * @throws IOException
     * @since 1.0.0
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        String parcours = (String) req.getParameter("parcours");
        String depart = (String) req.getParameter("depart");
        
        resp.sendRedirect("/openscore?page=creationScore&parcours="+parcours+"&depart="+depart);
    }
    
    /**
     * Méthode permettant la gestion des flux POST
     * 
     * @param req
     * @param resp
     * @throws IOException
     * @since 1.0.0
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        BaseParcours test = new BaseParcours();
        String parcours = (String) req.getParameter("pParcours");
        String depart = (String) req.getParameter("pDepart");
        ArrayList<Integer> trou = new ArrayList<Integer>();
        int jour = Integer.parseInt(req.getParameter("pJour"));
        int mois = Integer.parseInt(req.getParameter("pMois"));
        int annee = Integer.parseInt(req.getParameter("pAnnee"));
        JDate date = new JDate(jour, mois, annee);
        
        for (int i = 1; i < 19; i++) {
            trou.add(Integer.parseInt(req.getParameter("S"+i)));
        }
        
        test.ajouter(user, parcours, depart, trou, date.toDate());
        resp.sendRedirect("/openscore?page=chargerPartie");
    }
    
}
