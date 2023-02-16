/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import Interface.Interface_IService;
import model.rapport_financier;
import Util.Maconnexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LENOVO
 */
public class servicerapportfinancier implements Interface_IService <rapport_financier>{

    Connection cnx = Maconnexion.getInstance().getCnx();
    
    @Override
    public void ajouter(rapport_financier t) {
        try {
            String req = "INSERT INTO `rapport_financier`(`Date_rap`, `Type_rap`, `revenus`, `depences`) VALUES ('"+ t.getDate_rap()+"','"+t.getType_rap()+"',"+t.getRevenus()+","+t.getDepences()+")";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rapport ajouté avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int ID) {
        try {
            String req="DELETE FROM rapport_financier WHERE (`ID_rap`='"+ID+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rapport supprimé avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(rapport_financier t) {
        try {
            String req="UPDATE rapport_financier SET `Date_rap`='"+t.getDate_rap()+"',`Type_rap`='"+t.getType_rap()+"',`revenus`='"+t.getRevenus()+",`depences`='"+t.getDepences()+"' WHERE (`ID_rap='"+t.getID_rap()+"' )";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("Rapport modifié avec succes");
        } catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<rapport_financier> afficher() {
                List<rapport_financier> ra =new ArrayList<>();

        try {
            String req="SELECT * FROM rapport_financier";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
            while(res.next()){
                    rapport_financier r = new rapport_financier();
                    r.setDate_rap(res.getDate(1));
                    r.setType_rap(res.getNString(2));
                    r.setRevenus(res.getFloat(3));
                    r.setDepences(res.getFloat(4));
                  
                    ra.add(r);
            
        }} catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (ArrayList<rapport_financier>) ra; 
    }

    @Override
    public rapport_financier readById(int id) {
        rapport_financier r = new rapport_financier();
        try {
            String req="SELECT * FROM rapport_financier WHERE (`ID_rap`='"+id+"' )";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
            while(res.next()){
                    r.setDate_rap(res.getDate(1));
                    r.setType_rap(res.getNString(2));
                    r.setRevenus(res.getFloat(3));
                    r.setDepences(res.getFloat(4));
                          }} 
        catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }

    @Override
    public ArrayList<rapport_financier> sortBy(String nom_column, String Asc_Dsc) {
        List<rapport_financier> ra =new ArrayList<>();
        try {
            String req="SELECT * FROM rapport_financier ORDER BY "+nom_column+" "+Asc_Dsc+"";
            Statement st = cnx.createStatement();
            ResultSet res=st.executeQuery(req);
             while(res.next()){
                    rapport_financier r = new rapport_financier();
                    r.setDate_rap(res.getDate(1));
                    r.setType_rap(res.getNString(2));
                    r.setRevenus(res.getFloat(3));
                    r.setDepences(res.getFloat(4));
                  
                    ra.add(r);
            
        }
        } catch (SQLException ex) {
            Logger.getLogger(servicerapportfinancier.class.getName()).log(Level.SEVERE, null, ex);
        }
    return (ArrayList<rapport_financier>) ra; 
    }

}
