/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import Interfaces.Interface_IService;
import Model.transaction;
import Util.MaConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.User;
import Model.Wallet;
import Model.reunion;
/**
 *
 * @author LENOVO
 */
public class servicetransaction implements Interface_IService<transaction>{
  Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(transaction t) {
                try {
                    
                    String req = "INSERT INTO `transaction`(`Date_trans`, `montant`, `Type_trans`, `id`) VALUES ('"+ t.getDate_trans()+"','"+t.getMontant()+"','"+t.getType_trans()+"','"+t.getId().getId()+"')";
                    Statement st = cnx.createStatement();
                    st.executeUpdate(req);
                    System.out.println("Transaction ajoutée avec succes");
                     
                } catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
                
    }
    public Float chercher_revenue(Date date,String typeR) throws SQLException{
      LocalDate d1; 
      Float revenus;
        if(typeR=="Bilan annuel") {
            d1=date.toLocalDate().plusYears(1);
        }
        else {
            d1=date.toLocalDate().plusMonths(1);
        }
        String reqRevenus = "SELECT SUM(montant) AS total FROM `transaction` WHERE ((`Date_trans` BETWEEN '" + date + "' AND '" + d1 + "') AND (`type_trans`='Transaction de revenus'))";

        //String reqRevenus = "SELECT SUM(montant) AS total FROM `transaction` WHERE ((`Date_trans` BETWEEN ‘'"+date+"'’ AND ‘'"+d1+"'’) AND (`type_trans`='Transaction de revenus'))";
        Statement stRevenus = cnx.createStatement();
        ResultSet resRevenus = stRevenus.executeQuery(reqRevenus);
        while(resRevenus.next()) {
         revenus = resRevenus.getFloat("total");
         return revenus;
        }
        return null;
    }
     public Float chercher_depense(Date date,String typeR) throws SQLException{
      LocalDate d1; 
      Float depenses;
        if(typeR=="Bilan annuel") {
            d1=date.toLocalDate().plusYears(1);
        }
        else {
            d1=date.toLocalDate().plusMonths(1);
        }
                String reqRevenus = "SELECT SUM(montant) AS total FROM `transaction` WHERE ((`Date_trans` BETWEEN '" + date + "' AND '" + d1 + "') AND (`type_trans`='Transaction de depenses'))";

       // String reqRevenus = "SELECT SUM(montant) AS total FROM `transaction` WHERE ((Date_trans BETWEEN ‘"+date+"’ AND ‘"+d1+"’) AND (type_trans='Transaction de depenses'))";
        Statement stRevenus = cnx.createStatement();
        ResultSet resRevenus = stRevenus.executeQuery(reqRevenus);
        while(resRevenus.next()) {
         depenses = resRevenus.getFloat("total");
         return depenses;
        }
        return null;
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
                    String req="UPDATE `transaction` SET `Date_trans` ='"+t.getDate_trans()+"',`montant`='"+t.getMontant()+"',`Type_trans`='"+t.getType_trans()+"',`id`='"+t.getId().getId()+"' WHERE (`ID_Trans`='"+t.getID_trans()+"' )";
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
//                    Wallet w = new Wallet();
//                    w.setId_wallet(res.getInt(5));
//                    tr.setWallet(w);
                   User u = new User();
                   u.setId(res.getInt(5));
                   tr.setId(u);
                  
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
                          User u = new User();
                   u.setId(res.getInt(5));
                   tr.setId(u);
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
                 User u = new User();
                   u.setId(res.getInt(5));
                   tr.setId(u);
                   
                  
                    ta.add(tr);
                }}
                catch (SQLException ex) {
                    Logger.getLogger(servicetransaction.class.getName()).log(Level.SEVERE, null, ex);
                }
         return (ArrayList<transaction>) ta; 

    }  

  
      public List<transaction> getAllTransactions() {
    return afficher();
} 


    @Override
    public List<transaction> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<transaction> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public transaction readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<transaction> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public transaction readbyName(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbLigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            


}
