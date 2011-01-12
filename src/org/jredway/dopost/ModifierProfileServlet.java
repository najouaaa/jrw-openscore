package org.jredway.dopost;

import java.io.IOException;
import org.jredway.model.BaseUtilisateur;
import org.jredway.model.Utilisateur;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class ModifierProfileServlet extends HttpServlet {
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        
        String nom = req.getParameter("nom");
        String prenom = req.getParameter("prenom");
        String tmp = req.getParameter("index");
        int index = Integer.parseInt(tmp);
        
        BaseUtilisateur base = new BaseUtilisateur();
        
        Utilisateur membre;
        
        membre = base.getUtilisateur();
        
        membre.setIndex(index);
        membre.setNom(nom);
        membre.setPrenom(prenom);
        base.modifier(membre);
        
        resp.sendRedirect("/openscore?page=profile");
        
    }
}