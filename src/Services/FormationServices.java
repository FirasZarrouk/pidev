/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author ASUS
 */
import Interfaces.Interface_IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Model.Formation;
import Model.reunion;
import Util.MaConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 *
 * @author adelb
 */
public class FormationServices implements Interface_IService<Formation>{
    //var
    Connection cnx = MaConnection.getInstance().getCnx();

    @Override
    public void ajouter(Formation t) {
            try {
                String req = "INSERT INTO `formation`(`titre`,`lien`,`imageSrc`,`Description`,`categorie`,`nbrPlaces`,`prix`) VALUES ('"+ t.getTitre()+"','"+t.getLien()+"','"+t.getImageSrc()+"','"+t.getDescription()+"','"+t.getCategorie()+"','"+t.getNbrPlaces()+"','"+t.getPrix()+"')";
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
                String req= "UPDATE formation SET `titre`='"+t.getTitre()+"',`lien`='"+t.getLien()+"',`imageSrc`='"+t.getImageSrc()+"',`Description`='"+t.getDescription()+"',`categorie`='"+t.getCategorie()+"',`nbrPlaces`='"+t.getNbrPlaces()+"',`prix`='"+t.getPrix()+"' WHERE (`id_formation`='"+t.getId_formation()+"' )";
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
                    f.setTitre(res.getString(2));
                    f.setLien(res.getString(3));
                    f.setImageSrc(res.getString(4));
                    f.setDescription(res.getString(5));
                    f.setCategorie(res.getString(6));
                    f.setNbrPlaces(res.getInt(7));
                    f.setPrix(res.getFloat(8));
                  
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
              F.setTitre(res.getString(2));
              F.setLien(res.getString(3));
              F.setImageSrc(res.getString(4));
              F.setDescription(res.getString(5));
              F.setCategorie(res.getString(6));
              F.setNbrPlaces(res.getInt(7));
              F.setPrix(res.getFloat(8));
                  
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
                    f.setTitre(res.getString(2));
                    f.setLien(res.getString(3));
                    f.setImageSrc(res.getString(4));
                    f.setDescription(res.getString(5));
                    f.setCategorie(res.getString(6));
                    f.setNbrPlaces(res.getInt(7));
                    f.setPrix(res.getFloat(8));
                  
                    fo.add(f);
                }}
                catch (SQLException ex) {
                    Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
                }
         return (ArrayList<Formation>) fo; 

    }

    @Override
    public Formation readByName(String nom) {
         Formation P = new Formation();
        try {
            String req="SELECT * FROM formation WHERE `titre`='"+nom+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                
                
                
                P.setId_formation(res.getInt(1));
                P.setTitre(res.getString(2));
                P.setLien(res.getString(3));
                P.setImageSrc(res.getString(4));
                P.setDescription(res.getString(5));
                P.setCategorie(res.getString(6));
                P.setNbrPlaces(res.getInt(7));
                P.setPrix(res.getFloat(8));
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return P ;
    }
    
     /*public ObservableList<Formation> getMostLikedEvents() {
    ObservableList<Formation> list = FXCollections.observableArrayList();
    try {
        String sql = "SELECT f.id_formation, f.titre, f.lien, f.imageSrc, f.Description, f.categorie, f.nbrPlaces, f.prix, COUNT(p.vote) AS likes " +
                     "FROM formation f " +
                     "JOIN participation p ON f.id_formation = p.id_formation " +
                     "WHERE p.vote = 1 " +
                     "GROUP BY f.id_formation " +
                     "ORDER BY likes DESC " +
                     "LIMIT 3";
        PreparedStatement statement = cnx.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();

        while (rs.next()) {
            int id_formation = rs.getInt("id_formation");
            String titre = rs.getString("titre");
            String lien = rs.getString("lien");
            String imageSrc = rs.getString("imageSrc");
            String Description = rs.getString("Description");
            String categorie = rs.getString("categorie");
            int nbrPlaces = rs.getInt("nbrPlaces");
            float prix  = rs.getFloat("prix");
           // int likes = rs.getInt("likes");
            Formation formation = new Formation(id_formation, titre, lien, imageSrc, Description, categorie, nbrPlaces, prix);
            //evenement.setLikes(likes);
            list.add(formation);
        }

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return list;
}*/
    
    /*public int countLikes(int eventId) {
    int count = 0;
    try {
        String sql = "SELECT COUNT(*) AS count FROM participation WHERE id_formation = ? AND vote = 1";
        PreparedStatement statement = cnx.prepareStatement(sql);
        statement.setInt(1, eventId);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            count = rs.getInt("count");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return count;
}*/
    
     public int getTotalVotes(Formation f) {
    int totalVotes = 0;
    try {
        Statement stmt = cnx.createStatement();
        String sql = "select * from participation where id_formation=" + f.getId_formation();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            totalVotes += rs.getInt("vote");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return totalVotes;
}
     
     public ObservableList<Formation> getMostLikedEvents() {
    ObservableList<Formation> list = FXCollections.observableArrayList();
    try {
        Statement statement = cnx.createStatement();
        String sql = "SELECT f.id_formation, f.titre, f.lien, f.imageSrc, f.Description, f.categorie, f.nbrPlaces, f.prix, COUNT(p.vote) AS likes\n" +
"FROM formation f\n" +
"JOIN participation p ON f.id_formation = p.id_formation\n" +
"JOIN (\n" +
"    SELECT id_formation, MAX(vote) as max_vote\n" +
"    FROM participation\n" +
"    GROUP BY id_formation\n" +
") pmax ON p.id_formation = pmax.id_formation AND p.vote = pmax.max_vote\n" +
"GROUP BY f.id_formation\n" +
"ORDER BY likes DESC\n" +
"LIMIT 1;";
        ResultSet rs = statement.executeQuery(sql);

        while (rs.next()) {
            int id_formation = rs.getInt("id_formation");
            String titre = rs.getString("titre");
            String lien = rs.getString("lien");
            String imageSrc = rs.getString("imageSrc");
            String Description = rs.getString("Description");
            String categorie = rs.getString("categorie");
            int nbrPlaces = rs.getInt("nbrPlaces");
            float prix = rs.getFloat("prix");
            // int likes = rs.getInt("likes");
            Formation form = new Formation(id_formation, titre, lien, imageSrc, Description, categorie, nbrPlaces, prix);
            //evenement.setLikes(likes);
            list.add(form);
        }

    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return list;
}

    @Override
    public List<Formation> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formation> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Formation> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Formation readbyName(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbLigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
}