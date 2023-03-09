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
public class reunion {
    private int id_reunion;
    private Date dateReunion;
    private String heureReunion;
    private String lieuReunion;
    private String contactReunion;
    private String Valider;
    private int ID_investisseur;
    private int ID_projet;

    public reunion() {
    }

    public reunion(int id_reunion, Date dateReunion, String heureReunion, String lieuReunion, String contactReunion, String Valider, int ID_investisseur, int ID_projet) {
        this.id_reunion = id_reunion;
        this.dateReunion = dateReunion;
        this.heureReunion = heureReunion;
        this.lieuReunion = lieuReunion;
        this.contactReunion = contactReunion;
        this.Valider = Valider;
        this.ID_investisseur = ID_investisseur;
        this.ID_projet = ID_projet;
    }

    public int getId_reunion() {
        return id_reunion;
    }

    public Date getDateReunion() {
        return dateReunion;
    }

    public String getHeureReunion() {
        return heureReunion;
    }

    public String getLieuReunion() {
        return lieuReunion;
    }

    public String getContactReunion() {
        return contactReunion;
    }

    public String getValider() {
        return Valider;
    }

    public int getID_investisseur() {
        return ID_investisseur;
    }

    public int getID_projet() {
        return ID_projet;
    }

    public void setId_reunion(int id_reunion) {
        this.id_reunion = id_reunion;
    }

    public void setDateReunion(Date dateReunion) {
        this.dateReunion = dateReunion;
    }

    public void setHeureReunion(String heureReunion) {
        this.heureReunion = heureReunion;
    }

    public void setLieuReunion(String lieuReunion) {
        this.lieuReunion = lieuReunion;
    }

    public void setContactReunion(String contactReunion) {
        this.contactReunion = contactReunion;
    }

    public void setValider(String Valider) {
        this.Valider = Valider;
    }

    public void setID_investisseur(int ID_investisseur) {
        this.ID_investisseur = ID_investisseur;
    }

    public void setID_projet(int ID_projet) {
        this.ID_projet = ID_projet;
    }

    @Override
    public String toString() {
        return "reunion{" + "id_reunion=" + id_reunion + ", dateReunion=" + dateReunion + ", heureReunion=" + heureReunion + ", lieuReunion=" + lieuReunion + ", contactReunion=" + contactReunion + ", Valider=" + Valider + ", ID_investisseur=" + ID_investisseur + ", ID_projet=" + ID_projet + '}';
    }

   
    

    
    
    
    
}
