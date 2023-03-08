/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import model.User;
/**
 *
 * @author LENOVO
 */
public class servicePack implements Interface_IService <Pack> {
     Connection cnx = Maconnexion.getInstance().getCnx();

    @Override
    public void ajouter(Pack t) {
            try {
                String req = "INSERT INTO `pack`(`nomPack`, `categorie`, `tarif`, `roleU`, `id`) VALUES ('"+ t.getNomPack()+"','"+t.getCategorie()+"',"+t.getTarif()+",'"+t.getRoleU()+"','"+t.getUser().getId()+"')";
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
                String req="UPDATE pack SET `nomPack`='"+t.getNomPack()+"',`categorie`='"+t.getCategorie()+"',`tarif`='"+t.getTarif()+"',`roleU`='"+t.getRoleU()+"' WHERE (`ID_Pack`='"+t.getID_Pack()+"' )";
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
                    p.setRoleU(res.getString(5));
                    User U = new User();
                    U.setId(res.getInt(6));
                    p.setUser(U);
                   
                  
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
                   p.setRoleU(res.getString(5));
                    User U = new User();
                    U.setId(res.getInt(6));
                    p.setUser(U);
                
                  
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
                  p.setRoleU(res.getString(5));
                   User U = new User();
                    U.setId(res.getInt(6));
                    p.setUser(U);
                   

                  
                    pa.add(p);
            }} 
                  catch (SQLException ex) {
                Logger.getLogger(servicePack.class.getName()).log(Level.SEVERE, null, ex);
            }
            return (ArrayList<Pack>) pa;
    }

  
    @Override
    public List<Pack> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pack> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
