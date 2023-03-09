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
    private Date dateRappel; 
    private String heureRappel;
    private String reminder;
    private String email_investisseur;
    private String email_entrepreneur;

    public rappel() {
    }

    public rappel(int ID_rappel, Date dateRappel, String heureRappel, String reminder, String email_investisseur, String email_entrepreneur) {
        this.ID_rappel = ID_rappel;
        this.dateRappel = dateRappel;
        this.heureRappel = heureRappel;
        this.reminder = reminder;
        this.email_investisseur = email_investisseur;
        this.email_entrepreneur = email_entrepreneur;
    }

    public int getID_rappel() {
        return ID_rappel;
    }

    public Date getDateRappel() {
        return dateRappel;
    }

    public String getHeureRappel() {
        return heureRappel;
    }

    public String getReminder() {
        return reminder;
    }

    public String getEmail_investisseur() {
        return email_investisseur;
    }

    public String getEmail_entrepreneur() {
        return email_entrepreneur;
    }

    public void setID_rappel(int ID_rappel) {
        this.ID_rappel = ID_rappel;
    }

    public void setDateRappel(Date dateRappel) {
        this.dateRappel = dateRappel;
    }

    public void setHeureRappel(String heureRappel) {
        this.heureRappel = heureRappel;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public void setEmail_investisseur(String email_investisseur) {
        this.email_investisseur = email_investisseur;
    }

    public void setEmail_entrepreneur(String email_entrepreneur) {
        this.email_entrepreneur = email_entrepreneur;
    }

    @Override
    public String toString() {
        return "rappel{" + "ID_rappel=" + ID_rappel + ", dateRappel=" + dateRappel + ", heureRappel=" + heureRappel + ", reminder=" + reminder + ", email_investisseur=" + email_investisseur + ", email_entrepreneur=" + email_entrepreneur + '}';
    }

    
    
    
}