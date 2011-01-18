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

/**
 * Classe servlet servant de contrôleur pour
 * l'application (MVC)
 * 
 * @author killian.b
 * @version 1.0.0
 */
@SuppressWarnings("serial")
public class OpenScoreServlet extends HttpServlet {
    
    private UserService userService = null;
    private User user = null;
    private String page = new String();
    private String url = new String();
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    
    /**
     * Constructeur de la servlet avec log pour contrôle
     * de l'état
     * 
     * @param config
     * @throws ServletException qui gère les exceptions
     * @since 1.0.0
     */
    public void init(ServletConfig config) throws ServletException {
        log.info("Init servlet: on");
    }
    
    /**
     * Méthode GET qui sert pour la redirection vers les vues
     * apropriées
     * 
     * @param req
     * @param resp
     * @throws IOException, ServletException
     * @since 1.0.0
     */
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        this.userService = UserServiceFactory.getUserService();
        this.user = userService.getCurrentUser();
        this.url = req.getParameter("page");
        
        log.info("Parameter page: "+this.url);
        
        /*
         * récupère le paramètre GET puis charge
         * la vue correspondante
         */
        if(req.getParameter("page") != null) {   
            url = "/view/" + url + ".jsp";
            this.page = url;
            log.info("Load page: "+this.page);
        } else this.page = "/view/bienvenue.jsp"; 

        /*
         * contrôle si l'utilisateur est connecté
         * si connecté redirige sur acceuil
         * sinon crée une url de login
         */
        if (this.user != null) {
            req.setAttribute("page", page);
            RequestDispatcher dispatch = req.getRequestDispatcher("/index.jsp");
            dispatch.forward(req, resp);
        } else {
            resp.sendRedirect(userService.createLoginURL(req.getRequestURI()));
        }
    }
}





