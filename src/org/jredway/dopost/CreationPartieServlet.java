package org.jredway.dopost;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Classe servlet permettant la gestion des saisi
 * de score pour CreationPartie
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class CreationPartieServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        String parcours = (String) req.getParameter("parcours");
        String depart = (String) req.getParameter("depart");
        
        resp.sendRedirect("/openscore?page=creationScore&parcours="+parcours+"&depart="+depart);
    }
    
}
