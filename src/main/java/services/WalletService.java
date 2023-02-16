/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import interfaces.Interface_IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Wallet;
import utilities.MyConnection;

/**
 *
 * @author Firas
 */
public class WalletService implements Interface_IService <Wallet>{
        Connection cnx=MyConnection.getInstance().getCnx();
        
        @Override
    public void ajouter(Wallet w) {
    try {
        String req = "INSERT INTO `wallet` ( `id_wallet`, `id`, `num_carte`, `methode_payment`, `date_expiration`) VALUES (?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, w.getUser().getId());
        ps.setInt(2, w.getNum_carte());
        ps.setString(3, w.getMethode_payment());
        ps.setDate(4,(Date) w.getDate_expiration());
        ps.executeUpdate();
        System.out.println("Wallet Added Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    @Override
    public void supprimer(int ID) {
    try {
        String req = "DELETE FROM wallet WHERE id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, ID);
        ps.executeUpdate();
        System.out.println("Wallet Deleted Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }   
    
    }

    @Override
    public List afficher() {
     List<Wallet> wallets = new ArrayList<>();
    try {
        String req = "SELECT * FROM wallet";
        PreparedStatement ps = cnx.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Wallet w = new Wallet();
            w.setId_wallet(rs.getInt("id_wallet"));
            w.getUser().setId(rs.getInt("id"));
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
           wallets.add(w);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return wallets;    
    
    }

    @Override
    public Wallet readById(int id) {
      Wallet  w =new Wallet();
        try {
        String req="SELECT * FROM wallet WHERE `id_wallet`='"+id+"'";
        Statement ste = cnx.createStatement();
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            w.setId_wallet(rs.getInt("id_wallet"));
            //w.setUser(rs.getInt("id"));
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
        }
           } catch (SQLException ex) {
        ex.printStackTrace();    }
       return w;  
    }

    @Override
    public ArrayList sortBy(String nom_column, String Asc_Dsc) {
    ArrayList<Wallet>wallets=new ArrayList();
       try {
            String req="SELECT * FROM wallet ORDER BY "+nom_column+" "+Asc_Dsc+"";
            Statement ste = cnx.createStatement();
            ResultSet rs=ste.executeQuery(req);
         while(rs.next()){
           Wallet w = new Wallet();
            w.setId_wallet(rs.getInt("id"));
            //w.getUser(rs.getString("nom"));
            w.setNum_carte(rs.getInt("num_carte"));
            w.setMethode_payment(rs.getString("methode_payment"));
            w.setDate_expiration(rs.getDate("date_expiration"));
            
            wallets.add(w);
            
        }   } catch (SQLException ex) {
        ex.printStackTrace(); ;
    }
     return wallets;
    }

   


    @Override
    public void modifier(Wallet w) {
       try {
        String req = "UPDATE user SET id = ?, num_carte = ?, methode_payment = ?, date_expiration = ?, pswd = ? WHERE id_wallet = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, w.getUser().getId());
        ps.setInt(2, w.getNum_carte());
        ps.setString(3, w.getMethode_payment());
        ps.setDate(4,(Date) w.getDate_expiration());
        ps.setInt(5, w.getId_wallet());
        ps.executeUpdate();
        System.out.println("Wallet Updated Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }   }
    
}
