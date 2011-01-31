package org.jredway.bean;

import java.io.IOException;

import org.jredway.model.BaseParcours;
import org.jredway.model.Parcours;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

/**
 * Classe bean pour le chargement
 * du parcours
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class ChargerPartieBean {

    private Key pKey;
    private String affichageParcours;
    
    /**
     * Constructeur bean
     * 
     * @since 1.0.0 
     */
    public ChargerPartieBean() {
        
    }

    /**
     * Générateur du parcours
     * 
     * @return affichagePartie
     * @throws IOException 
     */
    public String getAffichageParcours() throws IOException {
        BaseParcours base = new BaseParcours();
        Parcours partie = base.charger(pKey);
        
        String sKey = KeyFactory.keyToString(pKey);
        
        ChargementBean label = new ChargementBean();
        CreationScoreBean clabel = new CreationScoreBean();
        
        StringBuilder tmp = new StringBuilder();
        tmp.append("<span id=\"titre\"></span> \n");
        tmp.append("<form id=\"confirmC\" name=\"confirmC\" method=\"post\" action=\"/openscore/ModifierPartie\"> \n");
        tmp.append("<input type=\"text\" name=\"pParcours\" id=\"pParcours\" class=\"JHide\"/> \n");
        tmp.append("<input type=\"text\" name=\"pDepart\" id=\"pDepart\" class=\"JHide\"/> \n");
        tmp.append("<input type=\"text\" name=\"pKey\" id=\"pKey\" class=\"JHide\" value=\""+sKey+"\" /> \n");
        tmp.append("<table border=\"1\" class=\"sample\" id=\"tabAller\"> \n");
        tmp.append("<tr> \n");
        tmp.append("<td class=\"N\"><span id=\"\">"+clabel.getTrou()+"</span></td> \n");
        tmp.append("<td class=\"P\"><span id=\"\">"+clabel.getPar()+"</span></td> \n");
        tmp.append("<td class=\"H\"><span id=\"\">"+clabel.getHcp()+"</span></td> \n");
        tmp.append("<td class=\"D\"><span id=\"\">"+clabel.getDistance()+"</span></td> \n");
        tmp.append("<td><span id=\"\">Score</span></td> \n");
        tmp.append("</tr> \n");
        for(int i=1;i<10;i++) {
            tmp.append("<tr> \n");
            tmp.append("<td class=\"N\"><span id=\"N"+i+"\"></span></td> \n");
            tmp.append("<td class=\"P\"><span id=\"P"+i+"\"></span></td> \n");
            tmp.append("<td class=\"H\"><span id=\"H"+i+"\"></span></td> \n");
            tmp.append("<td class=\"D\"><span id=\"D"+i+"\"></span></td> \n");
            tmp.append("<td><input class=\"saisi\" type=\"text\" id=\"S"+i+"\" name=\"S"+i+"\" "+
            		    "value=\""+partie.getTrou().get(i-1)+"\" /></td> \n");
            tmp.append("</tr> \n");
        }
        tmp.append("</table> \n");
        tmp.append("<table border=\"1\" class=\"sample\" id=\"tabRetour\"> \n");
        tmp.append("<tr> \n");
        tmp.append("<td class=\"N\"><span id=\"\">"+clabel.getTrou()+"</span></td> \n");
        tmp.append("<td class=\"P\"><span id=\"\">"+clabel.getPar()+"</span></td> \n");
        tmp.append("<td class=\"H\"><span id=\"\">"+clabel.getHcp()+"</span></td> \n");
        tmp.append("<td class=\"D\"><span id=\"\">"+clabel.getDistance()+"</span></td> \n");
        tmp.append("<td><span id=\"\">Score</span></td> \n");
        tmp.append("</tr> \n");
        tmp.append("<tr> \n");
        for(int i=10;i<19;i++) {
            tmp.append("<tr> \n");
            tmp.append("<td class=\"N\"><span id=\"N"+i+"\"></span></td> \n");
            tmp.append("<td class=\"P\"><span id=\"P"+i+"\"></span></td> \n");
            tmp.append("<td class=\"H\"><span id=\"H"+i+"\"></span></td> \n");
            tmp.append("<td class=\"D\"><span id=\"D"+i+"\"></span></td> \n");
            tmp.append("<td><input class=\"saisi\" type=\"text\" id=\"S"+i+"\" name=\"S"+i+"\" "+
            		    "value=\""+partie.getTrou().get(i-1)+"\" /></td> \n");
            tmp.append("</tr> \n");
        }
        tmp.append("</tr> \n");
        tmp.append("</table> \n");
        tmp.append("<br/> \n");
        tmp.append("<br/> \n");
        tmp.append("<a href=\"/openscore?page=chargerPartie\" class=\"jbouton\">"+clabel.getRetour()+"</a> \n");
        tmp.append("<input id=\"modifierScore\" type=\"submit\" value=\""+label.getModifier()+"\" class=\"jbouton\"/> \n");
        tmp.append("</form>");
        affichageParcours = tmp.toString();
        
        return affichageParcours;
    }
    
    public Key getpKey() {
        return pKey;
    }

    public void setpKey(Key pKey) {
        this.pKey = pKey;
    }
    
}
