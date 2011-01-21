package org.jredway.dopost;

import java.io.IOException;
import org.jredway.model.BaseUtilisateur;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.*;

/**
 * Classe servlet permettant de gérer les POST la 
 * création de profile Utilisateurs
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class CreerProfileServlet extends HttpServlet {
    
    /**
     * Attribut UserService
     * 
     * @since 1.0.0
     */
    private UserService userService = null;
    
    /**
     * Attribut User
     * 
     * @since 1.0.0
     */
    private User user = null;
    
    /**
     * Méthode permettant la gestion des flux POST
     * 
     * @param req
     * @param resp
     * @throws IOException
     * @since 1.0.0
     */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        this.userService = UserServiceFactory.getUserService();
        this.user = userService.getCurrentUser();
        
        String initNom = req.getParameter("nomVide");
        String initPrenom = req.getParameter("prenomVide");
        String tmp = req.getParameter("indexVide");
        int initIndex = Integer.parseInt(tmp);
        
        BaseUtilisateur base = new BaseUtilisateur();
            
        base.ajouter(user, initNom, initPrenom, initIndex);
        resp.sendRedirect("/openscore?page=profile");   
    }
}