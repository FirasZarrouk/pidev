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
    private Date date;
    private String heure;
    private String location;
    private String ID_investisseur;
    private String ID_entrepreneur;
    private String ID_projet;

    public reunion() {
    }

    public reunion(int id_reunion, Date date, String heure, String location, String ID_investisseur, String ID_entrepreneur, String ID_projet) {
        this.id_reunion = id_reunion;
        this.date = date;
        this.heure = heure;
        this.location = location;
        this.ID_investisseur = ID_investisseur;
        this.ID_entrepreneur = ID_entrepreneur;
        this.ID_projet = ID_projet;
    }

    public int getId_reunion() {
        return id_reunion;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getLocation() {
        return location;
    }

    public String getID_investisseur() {
        return ID_investisseur;
    }

    public String getID_entrepreneur() {
        return ID_entrepreneur;
    }

    public String getID_projet() {
        return ID_projet;
    }

    public void setId_reunion(int id_reunion) {
        this.id_reunion = id_reunion;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setID_investisseur(String ID_investisseur) {
        this.ID_investisseur = ID_investisseur;
    }

    public void setID_entrepreneur(String ID_entrepreneur) {
        this.ID_entrepreneur = ID_entrepreneur;
    }

    public void setID_projet(String ID_projet) {
        this.ID_projet = ID_projet;
    }

    @Override
    public String toString() {
        return "reunion{" + "id_reunion=" + id_reunion + ", date=" + date + ", heure=" + heure + ", location=" + location + ", ID_investisseur=" + ID_investisseur + ", ID_entrepreneur=" + ID_entrepreneur + ", ID_projet=" + ID_projet + '}';
    }

    
    
    
    
    
            
    
}
