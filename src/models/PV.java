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
public class PV {
    private int ID_PV;
    private String nom;
    private String prenom;
    private Date date;    
    private String Commentaire;
    private String ID_investisseur;
    private String ID_entrepreneur;
    private String ID_projet;
    private reunion id_reunion;

    public PV() {
    }

    public PV(int ID_PV, String nom, String prenom, Date date, String Commentaire, String ID_investisseur, String ID_entrepreneur, String ID_projet, reunion id_reunion) {
        this.ID_PV = ID_PV;
        this.nom = nom;
        this.prenom = prenom;
        this.date = date;
        this.Commentaire = Commentaire;
        this.ID_investisseur = ID_investisseur;
        this.ID_entrepreneur = ID_entrepreneur;
        this.ID_projet = ID_projet;
        this.id_reunion = id_reunion;
    }

    public int getID_PV() {
        return ID_PV;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Date getDate() {
        return date;
    }

    public String getCommentaire() {
        return Commentaire;
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

    public reunion getId_reunion() {
        return id_reunion;
    }

    public void setID_PV(int ID_PV) {
        this.ID_PV = ID_PV;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
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

    public void setId_reunion(reunion id_reunion) {
        this.id_reunion = id_reunion;
    }

    @Override
    public String toString() {
        return "PV{" + "ID_PV=" + ID_PV + ", nom=" + nom + ", prenom=" + prenom + ", date=" + date + ", Commentaire=" + Commentaire + ", ID_investisseur=" + ID_investisseur + ", ID_entrepreneur=" + ID_entrepreneur + ", ID_projet=" + ID_projet + ", id_reunion=" + id_reunion + '}';
    }

    
    
    
}
