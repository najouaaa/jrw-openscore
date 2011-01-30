package org.jredway.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Implémentation du nouvelle classe
 * qui gère l'uniformisation des dates
 * 
 * @author killian.b
 * @version 1.0.0
 */
public class JDate {

    /**
     * Attribut Date
     * 
     * @see JDate#toDate()
     * @since 1.0.0
     */
    private Date dDate;
    
    /**
     * Attribut String
     * 
     * @see JDate#toString()
     * @since 1.0.0
     */
    private String sDate;
    
    /**
     * Attribut Int (ArrayList)
     * 
     * @see JDate#toInt()
     * @since 1.0.0
     */
    private ArrayList<Integer> iDate;
    
    /**
     * constructeur du JDate avec
     * JJ/MM/AAAA
     * 
     * @param jour
     *            format JJ
     * @param mois
     *            format MM
     * @param annee
     *            format AAAA
     */
    public JDate(int jour, int mois, int annee) {
        this.iDate = new ArrayList<Integer>();
        this.iDate.add(jour);
        this.iDate.add(mois);
        this.iDate.add(annee);
        
        this.sDate = jour+"/"+mois+"/"+annee;
        
        this.dDate = conversionIntToDate(jour,mois,annee);
    }
    
    /**
     * Méthode privé de conversion
     * Integer => Date
     * 
     * @param jour
     * @param mois
     * @param annee
     * @return Date
     */
    private Date conversionIntToDate(int jour, int mois, int annee) {
        GregorianCalendar gc = (GregorianCalendar)GregorianCalendar.getInstance();
        gc.set(GregorianCalendar.DATE, jour);
        gc.set(GregorianCalendar.MONTH, mois-1);
        gc.set(GregorianCalendar.YEAR, annee);
        gc.set(GregorianCalendar.HOUR, 12);
        gc.set(GregorianCalendar.MINUTE, 0);
        gc.set(GregorianCalendar.SECOND, 0);
        return gc.getTime();
    }
    
    /**
     * Retourne une date
     * 
     * @return dDate Date
     */
    public Date toDate() {
        return dDate;
    }
    
    /**
     * Retourne une String préformatée
     * 
     * @return sDate String
     */
    public String toString() {
        return sDate;
    }
    
    /**
     * Retourne une liste des int
     * 
     * @return iDate ArrayList(Integer)
     */
    public ArrayList<Integer> toInt() {
        return iDate;
    }
}
