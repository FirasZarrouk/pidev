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
    private String nom;
    private String prenom;
    private String entreprise;
    private Date date;
    private String heure;
    private String lieu;
    private String contact;
    private String ID_investisseur;
    private String ID_entrepreneur;
    private String ID_projet;

    public reunion() {
    }

    public reunion(int id_reunion, String nom, String prenom, String entreprise, Date date, String heure, String lieu, String contact, String ID_investisseur, String ID_entrepreneur, String ID_projet) {
        this.id_reunion = id_reunion;
        this.nom = nom;
        this.prenom = prenom;
        this.entreprise = entreprise;
        this.date = date;
        this.heure = heure;
        this.lieu = lieu;
        this.contact = contact;
        this.ID_investisseur = ID_investisseur;
        this.ID_entrepreneur = ID_entrepreneur;
        this.ID_projet = ID_projet;
    }

    public int getId_reunion() {
        return id_reunion;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public Date getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public String getLieu() {
        return lieu;
    }

    public String getContact() {
        return contact;
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

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setContact(String contact) {
        this.contact = contact;
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
        return "reunion{" + "id_reunion=" + id_reunion + ", nom=" + nom + ", prenom=" + prenom + ", entreprise=" + entreprise + ", date=" + date + ", heure=" + heure + ", lieu=" + lieu + ", contact=" + contact + ", ID_investisseur=" + ID_investisseur + ", ID_entrepreneur=" + ID_entrepreneur + ", ID_projet=" + ID_projet + '}';
    }
    
    
    
}
