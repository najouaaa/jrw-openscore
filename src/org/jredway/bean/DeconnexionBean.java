package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;


public class DeconnexionBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    private String question, bouton;

    public DeconnexionBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        question = myProps.getProperty("app.champs.questiondeconnexion");
        bouton = myProps.getProperty("app.champs.boutondeconnexion");
        MyInputStream.close();
    }

    public String getQuestion() {
        return question;
    }

    public String getBouton() {
        return bouton;
    }
    
}
