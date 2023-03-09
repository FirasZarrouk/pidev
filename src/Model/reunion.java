/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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
    private User id;
    private Projet id_projet;
    private int ID_enrepreneur ;
    
    

    public reunion() {
    }

    public reunion(int id_reunion, Date dateReunion, String heureReunion, String lieuReunion, String contactReunion, String Valider, User id, Projet id_projet, int ID_enrepreneur) {
        this.id_reunion = id_reunion;
        this.dateReunion = dateReunion;
        this.heureReunion = heureReunion;
        this.lieuReunion = lieuReunion;
        this.contactReunion = contactReunion;
        this.Valider = Valider;
        this.id = id;
        this.id_projet = id_projet;
        this.ID_enrepreneur = ID_enrepreneur;
    }

    public reunion(Date dateReunion, String heureReunion, String lieuReunion, String contactReunion, String Valider, User id, Projet id_projet, int ID_enrepreneur) {
        this.dateReunion = dateReunion;
        this.heureReunion = heureReunion;
        this.lieuReunion = lieuReunion;
        this.contactReunion = contactReunion;
        this.Valider = Valider;
        this.id = id;
        this.id_projet = id_projet;
        this.ID_enrepreneur = ID_enrepreneur;
    }

    

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

    public Projet getId_projet() {
        return id_projet;
    }

    public void setId_projet(Projet id_projet) {
        this.id_projet = id_projet;
    }

    public int getID_enrepreneur() {
        return ID_enrepreneur;
    }

    public void setID_enrepreneur(int ID_enrepreneur) {
        this.ID_enrepreneur = ID_enrepreneur;
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

    @Override
    public String toString() {
        return "reunion{" + "id_reunion=" + id_reunion + ", dateReunion=" + dateReunion + ", heureReunion=" + heureReunion + ", lieuReunion=" + lieuReunion + ", contactReunion=" + contactReunion + ", Valider=" + Valider + ", id=" + id + ", id_projet=" + id_projet + ", ID_enrepreneur=" + ID_enrepreneur + '}';
    }

    
    

    

    
   
    

    
    
    
    
}
