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
public class rapport_financier {
    private int ID_rap;
    private Date Date_rap;
    private String Type_rap;
    private float revenus ;
    private float depences;

    public rapport_financier() {
    }

    public rapport_financier(int ID_rap, Date Date_rap, String Type_rap, float revenus, float depences) {
        this.ID_rap = ID_rap;
        this.Date_rap = Date_rap;
        this.Type_rap = Type_rap;
        this.revenus = revenus;
        this.depences = depences;
    }

    public rapport_financier(Date Date_rap, String Type_rap, float revenus, float depences) {
        this.Date_rap = Date_rap;
        this.Type_rap = Type_rap;
        this.revenus = revenus;
        this.depences = depences;
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
        return "rapport_financier{" + "ID_rap=" + ID_rap + ", Date_rap=" + Date_rap + ", Type_rap=" + Type_rap + ", revenus=" + revenus + ", depences=" + depences + '}';
    }
    
}
