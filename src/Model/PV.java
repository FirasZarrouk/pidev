/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author afifa
 */
public class PV {

    public static int size() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void addAll(List<PV> afficher) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private int ID_PV;
    private Date datePV;    
    private String Commentaire;
    private String Verifier;
    private reunion id_reunion;

    public PV() {
    }

    public PV(int ID_PV, Date datePV, String Commentaire, String Verifier, reunion id_reunion) {
        this.ID_PV = ID_PV;
        this.datePV = datePV;
        this.Commentaire = Commentaire;
        this.Verifier = Verifier;
        this.id_reunion = id_reunion;
    }

    public int getID_PV() {
        return ID_PV;
    }

    public Date getDatePV() {
        return datePV;
    }

    public String getCommentaire() {
        return Commentaire;
    }

    public String getVerifier() {
        return Verifier;
    }

    public reunion getId_reunion() {
        return id_reunion;
    }

    public void setID_PV(int ID_PV) {
        this.ID_PV = ID_PV;
    }

    public void setDatePV(Date datePV) {
        this.datePV = datePV;
    }

    public void setCommentaire(String Commentaire) {
        this.Commentaire = Commentaire;
    }

    public void setVerifier(String Verifier) {
        this.Verifier = Verifier;
    }

    public void setId_reunion(reunion id_reunion) {
        this.id_reunion = id_reunion;
    }

    @Override
    public String toString() {
        return "PV{" + "ID_PV=" + ID_PV + ", datePV=" + datePV + ", Commentaire=" + Commentaire + ", Verifier=" + Verifier + ", id_reunion=" + id_reunion + '}';
    }

    public reunion get(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
    
}
