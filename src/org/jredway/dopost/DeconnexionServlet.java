package org.jredway.dopost;

import java.io.IOException;
import javax.servlet.http.*;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

@SuppressWarnings("serial")
public class DeconnexionServlet extends HttpServlet {
	
	private UserService userService = UserServiceFactory.getUserService();
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    	
        resp.sendRedirect(userService.createLogoutURL("/")); 
        
    }
}
