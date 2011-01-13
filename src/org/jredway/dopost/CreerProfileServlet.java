package org.jredway.dopost;

import java.io.IOException;
import org.jredway.model.BaseUtilisateur;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class CreerProfileServlet extends HttpServlet {
    
    private UserService userService = null;
    private User user = null;
    
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