/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Participation {
    private int id_participation;
    private User user;
    private Formation form;
    private Date date;
    private int vote=0;

    public Participation() {
    }

    public Participation(int id_participation, User user, Formation form, Date date) {
        this.id_participation = id_participation;
        this.user = user;
        this.form = form;
        this.date = date;
    }

    public Participation(User user, Formation form, Date date) {
        this.user = user;
        this.form = form;
        this.date = date;
    }


    public int getId_participation() {
        return id_participation;
    }

    public void setId_participation(int id_participation) {
        this.id_participation = id_participation;
    }

    public User getUser() {
        return user;
    }

    public Formation getForm() {
        return form;
    }

    public void setForm(Formation form) {
        this.form = form;
    }
    
    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }

    
    @Override
    public String toString() {
        return "Participation{" + "id_participation=" + id_participation + ", idU=" + user + ", id_formation=" + form + ", date=" + date + '}';
    }

   

   
    

    

   

}
