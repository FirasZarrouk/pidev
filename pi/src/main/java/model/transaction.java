/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class transaction {
    private int ID_trans;
    private Date Date_trans;
    private float montant;
    private String Type_trans;

    public transaction() {
    }

    public transaction(int ID_trans, Date Date_trans, float montant, String Type_trans) {
        this.ID_trans = ID_trans;
        this.Date_trans = Date_trans;
        this.montant = montant;
        this.Type_trans = Type_trans;
    }

    public transaction(Date Date_trans, float montant, String Type_trans) {
        this.Date_trans = Date_trans;
        this.montant = montant;
        this.Type_trans = Type_trans;
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
        return "transaction{" + "ID_trans=" + ID_trans + ", Date_trans=" + Date_trans + ", montant=" + montant + ", Type_trans=" + Type_trans + '}';
    }
    
    
}
