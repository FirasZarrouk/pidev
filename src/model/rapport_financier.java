/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class rapport_financier {
      private int ID_rap;
    private Date Date_rap;
    private String Type_rap;
    private float revenus ;
    private float depences;
    private transaction transaction;

    public rapport_financier() {
    }

    public void setTransaction(transaction transaction) {
        this.transaction = transaction;
    }

    public transaction getTransaction() {
        return transaction;
    }

    public rapport_financier(int ID_rap, Date Date_rap, String Type_rap, float revenus, float depences, transaction transaction) {
        this.ID_rap = ID_rap;
        this.Date_rap = Date_rap;
        this.Type_rap = Type_rap;
        this.revenus = revenus;
        this.depences = depences;
        this.transaction = transaction;
    }

    public rapport_financier(Date Date_rap, String Type_rap, float revenus, float depences, transaction transaction) {
        this.Date_rap = Date_rap;
        this.Type_rap = Type_rap;
        this.revenus = revenus;
        this.depences = depences;
        this.transaction = transaction;
    }

    

    public int getID_rap() {
        return ID_rap;
    }

    public Date getDate_rap() {
        return Date_rap;
    }

    public String getType_rap() {
        return Type_rap;
    }

    public float getRevenus() {
        return revenus;
    }

    public float getDepences() {
        return depences;
    }

    public void setID_rap(int ID_rap) {
        this.ID_rap = ID_rap;
    }

    public void setDate_rap(Date Date_rap) {
        this.Date_rap = Date_rap;
    }

    public void setType_rap(String Type_rap) {
        this.Type_rap = Type_rap;
    }

    public void setRevenus(float revenus) {
        this.revenus = revenus;
    }

    public void setDepences(float depences) {
        this.depences = depences;
    }

    @Override
    public String toString() {
        return "rapport_financier{" + "ID_rap=" + ID_rap + ", Date_rap=" + Date_rap + ", Type_rap=" + Type_rap + ", revenus=" + revenus + ", depences=" + depences + ", transaction=" + transaction + '}';
    }
}
