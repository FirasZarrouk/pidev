/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;

/**
 *
 * @author afifa
 */
public class rappel {
    private int ID_rappel;
    private Date date; 
    private String heure;
    private String reminder;
    private String ID_investisseur;
    private String ID_entrepreneur;

    public rappel() {
    }

    public rappel(int ID_rappel, Date date, String heure, String reminder, String ID_investisseur, String ID_entrepreneur) {
        this.ID_rappel = ID_rappel;
        this.date = date;
        this.heure = heure;
        this.reminder = reminder;
        this.ID_investisseur = ID_investisseur;
        this.ID_entrepreneur = ID_entrepreneur;
    }

    public int getID_rappel() {
        return ID_rappel;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getReminder() {
        return reminder;
    }

    public String getID_investisseur() {
        return ID_investisseur;
    }

    public String getID_entrepreneur() {
        return ID_entrepreneur;
    }

    public void setID_rappel(int ID_rappel) {
        this.ID_rappel = ID_rappel;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public void setID_investisseur(String ID_investisseur) {
        this.ID_investisseur = ID_investisseur;
    }

    public void setID_entrepreneur(String ID_entrepreneur) {
        this.ID_entrepreneur = ID_entrepreneur;
    }

    @Override
    public String toString() {
        return "rappel{" + "ID_rappel=" + ID_rappel + ", date=" + date + ", heure=" + heure + ", reminder=" + reminder + ", ID_investisseur=" + ID_investisseur + ", ID_entrepreneur=" + ID_entrepreneur + '}';
    }
    
    
    
}
