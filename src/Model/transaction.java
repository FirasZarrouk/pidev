/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Date;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class transaction {
    private int ID_trans;
    private Date Date_trans;
    private float montant;
    private String Type_trans;
    private User id ;
    

    public transaction() {
    }

    public transaction(int ID_trans, Date Date_trans, float montant, String Type_trans, User id) {
        this.ID_trans = ID_trans;
        this.Date_trans = Date_trans;
        this.montant = montant;
        this.Type_trans = Type_trans;
        this.id = id;
    }

    public transaction(Date Date_trans, float montant, String Type_trans, User id) {
        this.Date_trans = Date_trans;
        this.montant = montant;
        this.Type_trans = Type_trans;
        this.id = id;
    }

    public User getId() {
        return id;
    }

    public void setId(User id) {
        this.id = id;
    }

 
    

    
 

    public int getID_trans() {
        return ID_trans;
    }

    public Date getDate_trans() {
        return Date_trans;
    }

    public float getMontant() {
        return montant;
    }

    public String getType_trans() {
        return Type_trans;
    }

    public void setID_trans(int ID_trans) {
        this.ID_trans = ID_trans;
    }

    public void setDate_trans(Date Date_trans) {
        this.Date_trans = Date_trans;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public void setType_trans(String Type_trans) {
        this.Type_trans = Type_trans;
    }

    @Override
    public String toString() {
        return "transaction{" + "ID_trans=" + ID_trans + ", Date_trans=" + Date_trans + ", montant=" + montant + ", Type_trans=" + Type_trans + ", id=" + id + '}';
    }

   
   
}
