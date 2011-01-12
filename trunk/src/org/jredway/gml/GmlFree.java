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
        
       //On crée une instance de SAXBuilder
       SAXBuilder sxb = new SAXBuilder();
       try
       {
          //On crée un nouveau document JDOM avec en argument le fichier XML
          //Le parsing est terminé ;)
          document = sxb.build(new File("/parcours/" + xml + ".xml"));
       }
       catch(Exception e){}

       //On initialise un nouvel élément racine avec l'élément racine du document.
       this.racine = document.getRootElement();
       
    }

}
