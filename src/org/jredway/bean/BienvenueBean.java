package org.jredway.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Logger;

import org.jredway.openscore.OpenScoreServlet;


public class BienvenueBean {
    
    private static final Logger log = Logger.getLogger(OpenScoreServlet.class.getName());
    private String titre, message;

    public BienvenueBean() throws IOException {
        
        Properties myProps = new Properties();
        FileInputStream MyInputStream = null;
        
        try {
            MyInputStream = new FileInputStream(System.getProperty("app.config"));
            log.info("Load properties: on");
        } catch (FileNotFoundException e) {
            log.info("Load properties: off");
        }
        myProps.load(MyInputStream);
        titre = myProps.getProperty("app.champs.titrebienvenue");
        message = myProps.getProperty("app.champs.messagebienvenue");
        MyInputStream.close();
    }
    
    public String getTitre() {
        return titre;
    }

    public String getMessage() {
        return message;
    }
    
}
