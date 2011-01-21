package org.jredway.dopost;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

/**
 * Classe servlet qui gère les POST pour la 
 * déconnexion/redirection des Utilisateurs Google
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class DeconnexionServlet extends HttpServlet {
	
    /**
     * Attributs user
     * 
     * @since 1.0.0
     */
	private UserService userService = UserServiceFactory.getUserService();
    
	/**
	 * Méthode permettant la gestion des flux POST
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @since 1.0.0
	 */
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
        resp.sendRedirect(userService.createLogoutURL("/")); 
        
    }
}
