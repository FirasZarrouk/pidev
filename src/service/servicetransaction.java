/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import Interface.Interface_IService;
import model.transaction;
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
public class servicetransaction implements Interface_IService<transaction>{
  Connection cnx = Maconnexion.getInstance().getCnx();

    @Override
    public void ajouter(transaction t) {
                try {
                    String req = "INSERT INTO `transaction`(`Date_trans`, `montant`, `Type_trans`) VALUES ('"+ t.getDate_trans()+"','"+t.getMontant()+"','"+t.getType_trans()+"')";
                    Statement st = cnx.createStatement();
                    st.executeUpdate(req);
                    System.out.println("Transaction ajoutée avec succes");
                } catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @Override
    public void supprimer(int ID) {
                try {
                    String req="DELETE FROM transaction WHERE (`ID_Trans`='"+ID+"' )";
                    Statement st = cnx.createStatement();
                    st.executeUpdate(req);
                    System.out.println("Transaction supprimée avec succes");
                } catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @Override
    public void modifier(transaction t) {
                try {
                    String req="UPDATE transaction SET `Date_trans`='"+t.getDate_trans()+"',`montant`='"+t.getMontant()+"',`Type_trans`='"+t.getType_trans()+"' WHERE (`ID_Trans`='"+t.getID_trans()+"' )";
                    Statement st = cnx.createStatement();
                    st.executeUpdate(req);
                    System.out.println("Transaction modifiée avec succes");
                } catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
    }

    @Override
    public List<transaction> afficher() {
        List<transaction> ta =new ArrayList<>();
        try {
                    String req="SELECT * FROM transaction";
                    Statement st = cnx.createStatement();
                    ResultSet res=st.executeQuery(req);
                    while(res.next()){
                    transaction tr = new transaction();
                    tr.setID_trans(res.getInt(1));
                    tr.setDate_trans(res.getDate(2));
                    tr.setMontant(res.getFloat(3));
                    tr.setType_trans(res.getString(4));
                   
                  
                    ta.add(tr);
                }}
        catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
               return (ArrayList<transaction>) ta; 
       
    }

    @Override
    public transaction readById(int id) {
        transaction tr = new transaction();
                try {
                    String req="SELECT * FROM transaction WHERE (`ID_Trans`='"+id+"' )";
                    Statement st = cnx.createStatement();
                    ResultSet res=st.executeQuery(req);
                    while(res.next()){
                        tr.setID_trans(res.getInt(1));
                        tr.setDate_trans(res.getDate(2));
                        tr.setMontant(res.getFloat(3));
                        tr.setType_trans(res.getString(4));
                    }           } 
                catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                return tr;
}

    @Override
    public ArrayList<transaction> sortBy(String nom_column, String Asc_Dsc) {
        List<transaction> ta =new ArrayList<>();
                try {
                    String req="SELECT * FROM transaction ORDER BY "+nom_column+" "+Asc_Dsc+"";
                    Statement ste = cnx.createStatement();
                    ResultSet res=ste.executeQuery(req);
                      while(res.next()){
                    transaction tr = new transaction();
                    tr.setID_trans(res.getInt(1));
                    tr.setDate_trans(res.getDate(2));
                    tr.setMontant(res.getFloat(3));
                    tr.setType_trans(res.getString(4));
                   
                  
                    ta.add(tr);
                }}
                catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
         return (ArrayList<transaction>) ta; 

    }  
}
