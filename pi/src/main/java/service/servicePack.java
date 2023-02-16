/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import Interface.Interface_IService;
import model.Pack;
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
public class servicePack implements Interface_IService <Pack>{

        Connection cnx = Maconnexion.getInstance().getCnx();

    @Override
    public void ajouter(Pack t) {
            try {
                String req = "INSERT INTO `pack`(`nomPack`, `categorie`, `tarif`) VALUES ('"+ t.getNomPack()+"','"+t.getCategorie()+"',"+t.getTarif()+")";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Pack ajouter avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimer(int ID) {
            try {
                String req="DELETE FROM pack WHERE (`ID_Pack`='"+ID+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Pack supprimé avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void modifier(Pack t) {
            try {
                String req="UPDATE pack SET `nomPack`='"+t.getNomPack()+"',`categorie`='"+t.getCategorie()+"',`tarif`='"+t.getTarif()+"' WHERE (`ID_Pack`='"+t.getID_Pack()+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Pack modifié avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Pack> afficher() {
         List<Pack> pa=new ArrayList<>();    
        try {
               
                String req="SELECT * FROM pack";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                    Pack p=new Pack();
                    p.setID_Pack(res.getInt(1));
                    p.setNomPack(res.getString(2));
                    p.setCategorie(res.getString(3));
                    p.setTarif(res.getFloat(4));
                  
                    pa.add(p);
                }       } catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
         return (ArrayList<Pack>) pa;
}

    @Override
    public Pack readById(int id) {
         Pack p=new Pack();
        try {
                
                String req="SELECT * FROM pack WHERE (`ID_Pack`='"+id+"' ) ";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                    p.setID_Pack(res.getInt(1));
                    p.setNomPack(res.getString(2));
                    p.setCategorie(res.getString(3));
                    p.setTarif(res.getFloat(4));
                  
                   }
               
            } catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
        return p;
    }

    @Override
    public ArrayList<Pack> sortBy(String nom_column, String Asc_Dsc) {
         List<Pack> pa=new ArrayList<>(); 
         
            try {
                String req="SELECT * FROM pack ORDER BY "+nom_column+" "+Asc_Dsc+"";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                  while(res.next()){
                    Pack p=new Pack();
                    p.setID_Pack(res.getInt( 1));
                    p.setNomPack(res.getString(2));
                    p.setCategorie(res.getString(3));
                    p.setTarif(res.getFloat(4));
                  
                    pa.add(p);
            }} 
                  catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<Pack>) pa;
    }
              
    }






