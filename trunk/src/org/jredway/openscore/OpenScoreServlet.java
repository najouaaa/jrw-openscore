package org.jredway.openscore;

import java.io.IOException;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import javax.servlet.http.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.logging.Logger;


@SuppressWarnings("serial")
public class OpenScoreServlet extends HttpServlet {
    
    private UserService userService = null;
    private User user = null;
    private String page = new String();
    private String url = new String();
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    // Constructeur : de la servlet
    public void init(ServletConfig config) throws ServletException {
        log.info("Init servlet: on");
    }
    
    // Controller : méthode get
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.userService = UserServiceFactory.getUserService();
        this.user = userService.getCurrentUser();
        this.url = req.getParameter("page");
        
        log.info("Parameter page: "+this.url);
        
        if(req.getParameter("page") != null) {   
            url = "/view/" + url + ".jsp";
            this.page = url;
            log.info("Load page: "+this.page);
        } else this.page = "/view/bienvenue.jsp"; 

        if (this.user != null) {
            req.setAttribute("page", page);
            RequestDispatcher dispatch = req.getRequestDispatcher("/index.jsp");
            dispatch.forward(req, resp);
        } else {
            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }
    }
}





