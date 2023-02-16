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

import utilities.MyConnection;

/**
 *
 * @author Firas
 */
public class UserService implements Interface_IService <User> {
    
    Connection cnx=MyConnection.getInstance().getCnx();
    
    @Override
    public void ajouter(User user) {
    try {
        String req = "INSERT INTO `user` ( `nom`, `prenom`, `ddn`, `email`, `pswd`, `tel`, `adresse`, `role`) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, user.getNom());
        ps.setString(2, user.getPrenom());
        ps.setDate(3, (Date) user.getDdn());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPswd());
        ps.setInt(6, user.getTel());
        ps.setString(7, user.getAdresse());
        ps.setString(8, user.getRole());
        ps.executeUpdate();
        System.out.println("User Added Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
     /*      try {
            String req = "INSERT INTO `user`(`nom`, `prenom`, `ddn`, `email`, `pswd`, `tel`, `adresse`, `role`) VALUES ('"+ user.getNom()"','"+user.getPrenom()+"','"+user.getDDN()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getTel()+"','"+user.getAdresse()+"','"+user.getRole()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println(" L'evenement est ajouté avec succés ! ");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       */
    //}


    
    @Override
   public void modifier(User user) {
    try {
        String req = "UPDATE user SET nom = ?, prenom = ?, ddn = ?, email = ?, pswd = ?, tel = ?, adresse = ?, role = ? WHERE id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setString(1, user.getNom());
        ps.setString(2, user.getPrenom());
        ps.setDate(3, (Date) user.getDdn());
        ps.setString(4, user.getEmail());
        ps.setString(5, user.getPswd());
        ps.setInt(6, user.getTel());
        ps.setString(7, user.getAdresse());
        ps.setString(8, user.getRole());
        ps.setInt(9, user.getId());
        ps.executeUpdate();
        System.out.println("User Updated Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
   
    @Override
   public void supprimer(int id) {
    try {
        String req = "DELETE FROM user WHERE id = ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        ps.setInt(1, id);
        ps.executeUpdate();
        System.out.println("User Deleted Successfully!");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    @Override
   public List<User> afficher() {
    List<User> users = new ArrayList<>();
    try {
        String req = "SELECT * FROM user";
        PreparedStatement ps = cnx.prepareStatement(req);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setDdn(rs.getDate("ddn"));
            user.setEmail(rs.getString("email"));
            user.setPswd(rs.getString("pswd"));
            user.setTel(rs.getInt("tel"));
            user.setAdresse(rs.getString("adresse"));
            user.setRole(rs.getString("role"));
            users.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return users;
}

    @Override
    public User readById(int id) {
        User user=new User();
        try {
        String req="SELECT * FROM user WHERE `id`='"+id+"'";
        Statement ste = cnx.createStatement();
        ResultSet rs=ste.executeQuery(req);
        while(rs.next()){
            
            user.setId(rs.getInt("id"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setDdn(rs.getDate("ddn"));
            user.setEmail(rs.getString("email"));
            user.setPswd(rs.getString("pswd"));
            user.setTel(rs.getInt("tel"));
            user.setAdresse(rs.getString("adresse"));
            user.setRole(rs.getString("role"));
            
        }
           } catch (SQLException ex) {
        ex.printStackTrace();    }
       return user;
    }

    @Override
    public ArrayList<User> sortBy(String nom_column, String Asc_Dsc) {
        ArrayList<User>users=new ArrayList();
       try {
            String req="SELECT * FROM user ORDER BY "+nom_column+" "+Asc_Dsc+"";
            Statement ste = cnx.createStatement();
            ResultSet rs=ste.executeQuery(req);
         while(rs.next()){
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setDdn(rs.getDate("ddn"));
            user.setEmail(rs.getString("email"));
            user.setPswd(rs.getString("pswd"));
            user.setTel(rs.getInt("tel"));
            user.setAdresse(rs.getString("adresse"));
            user.setRole(rs.getString("role"));
            users.add(user);
            
        }   } catch (SQLException ex) {
        ex.printStackTrace(); ;
    }
     return users;
    }
}
