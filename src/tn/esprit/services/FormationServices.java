/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.esprit.services;

/**
 *
 * @author ASUS
 */
import tn.esprit.interfaces.Interface_IService;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tn.esprit.entity.Formation;
import tn.esprit.tools.MyConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author adelb
 */
public class FormationServices implements Interface_IService<Formation>{
    //var
    Connection cnx = MyConnection.getInstance().getCnx();

    @Override
    public void ajouter(Formation t) {
            try {
                String req = "INSERT INTO `formation`(`Nom`, `nbreEtapes`, `Description`,`statut`) VALUES ('"+ t.getNom()+"','"+t.getNbreEtapes()+"','"+t.getDescription()+"','"+t.getStatut()+"')";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Formationn ajoutee avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimer(int id) {
            try {
                String req="DELETE FROM formation WHERE (`id_formation`='"+id+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Formation supprimé avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void modifier(Formation t) {
            try {
                String req= "UPDATE formation SET `Nom`='"+t.getNom()+"',`nbreEtapes`='"+t.getNbreEtapes()+"',`Description`='"+t.getDescription()+"',`statut`='"+t.getStatut()+"' WHERE (`id_formation`='"+t.getId_formation()+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Formation modifié avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Formation> afficher() {
         List<Formation> fo=new ArrayList<>();    
        try {
               
                String req="SELECT * FROM formation";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                    Formation f=new Formation();
                    f.setId_formation(res.getInt(1));
                    f.setNom(res.getString(2));
                    f.setNbreEtapes(res.getInt(3));
                    f.setDescription(res.getString(4));
                    f.setStatut(res.getString(5));
                  
                    fo.add(f);
                }       } catch (SQLException ex) {
                Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
         return (ArrayList<Formation>) fo;
}

    @Override
    public Formation readById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody      
    Formation F = new Formation();
        try {
            String req="SELECT * FROM Formation WHERE `id_formation`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
               
              F.setId_formation(res.getInt(1));
              F.setNom(res.getString(2));
              F.setNbreEtapes(res.getInt(3));
              F.setDescription(res.getString(4));
              F.setStatut(res.getString(5));
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       return F;
    }

    @Override
    public ArrayList<Formation> sortBy(String nom_column, String Asc_Dsc) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      List<Formation> fo =new ArrayList<>();
                try {
                    String req="SELECT * FROM formation ORDER BY "+nom_column+" "+Asc_Dsc+"";
                    Statement ste = cnx.createStatement();
                    ResultSet res=ste.executeQuery(req);
                      while(res.next()){
                    Formation f = new Formation();
                    f.setId_formation(res.getInt(1));
                    f.setNom(res.getString(2));
                    f.setNbreEtapes(res.getInt(3));
                    f.setDescription(res.getString(4));
                    f.setStatut(res.getString(5));
                  
                    fo.add(f);
                }}
                catch (SQLException ex) {
                    Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
                }
         return (ArrayList<Formation>) fo; 

    }
}