package org.jredway.gml;

import java.io.*;
import org.jdom.*;
import org.jdom.input.*;
import java.util.List;
import java.util.Iterator;


public class GmlFree {
    
    private org.jdom.Document document;
    private Element racine;

    public GmlFree(String xml) {
        
       //On cr�e une instance de SAXBuilder
       SAXBuilder sxb = new SAXBuilder();
       try
       {
          //On cr�e un nouveau document JDOM avec en argument le fichier XML
          //Le parsing est termin� ;)
          document = sxb.build(new File("/parcours/" + xml + ".xml"));
       }
       catch(Exception e){}

       //On initialise un nouvel �l�ment racine avec l'�l�ment racine du document.
       this.racine = document.getRootElement();
       
    }

}
