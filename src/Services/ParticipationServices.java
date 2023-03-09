/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

/**
 *
 * @author ASUS
 */
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import Interfaces.Interface_IService;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import Model.Participation;
import Util.MaConnection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Model.Formation;
import Model.User;
import Model.reunion;
/**
 *
 * @author adelb
 */
public class ParticipationServices implements Interface_IService<Participation>{
    //var
    Connection cnx = MaConnection.getInstance().getCnx();
    
    @Override
    public void ajouter(Participation t) {
            try {
                String req = "INSERT INTO `participation`(`idU`,`id_formation`,`date`) VALUES ('"+ t.getUser().getId()+"',"+t.getForm().getId_formation()+",'"+t.getDate()+"')";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Participation ajouter avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void supprimer(int id) {
            try {
                String req="DELETE FROM participation WHERE (`id_participation`='"+id+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Participation supprimé avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public void modifier(Participation t) {
            try {
                String req="UPDATE participation SET `idU`='"+t.getUser()+"',`date`='"+t.getDate()+"' WHERE (`id`='"+t.getId_participation()+"' )";
                Statement st = cnx.createStatement();
                st.executeUpdate(req);
                System.out.println("Participation modifié avec succes");
            } catch (SQLException ex) {
                Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @Override
    public List<Participation> afficher() {
         List<Participation> pa=new ArrayList<>();
         FormationServices fs=new FormationServices();
         
        try {
               
                String req="SELECT * FROM participation";
                Statement st = cnx.createStatement();
                ResultSet res=st.executeQuery(req);
                while(res.next()){
                    Participation p=new Participation();
                    p.setId_participation(res.getInt(1));
                    User U = new User();
                    U.setId(res.getInt(2));
                    p.setUser(U);
                    //Formation F = new Formation();
                    p.setForm(fs.readById(res.getInt(3)));
                    //p.setForm(F);
//                    Date date=res.getDate(4);
                 //   p.setDate(date);
                  
                    pa.add(p);
                }       } catch (SQLException ex) {
                Logger.getLogger(FormationServices.class.getName()).log(Level.SEVERE, null, ex);
            }
         return (ArrayList<Participation>) pa;
}

    @Override
    public Participation readById(int id) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
   Participation P = new Participation();
        try {
            String req="SELECT * FROM participation WHERE `id_participation`='"+id+"'";
            Statement ste = cnx.createStatement();
            ResultSet res=ste.executeQuery(req);
            while(res.next()){
                FormationServices se = new FormationServices();
               
              P.setId_participation(res.getInt(1));
              User U = new User();
              U.setId(res.getInt(2));
              P.setUser(U);
              Formation F = se.readById(res.getInt(3));
              P.setForm(F);
              Date date=res.getDate(4);
              P.setDate(date);
                  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
        }
       return P;
    }

    @Override
    public ArrayList<Participation> sortBy(String nom_column, String Asc_Dsc) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
      List<Participation> ta =new ArrayList<>();
                try {
                    String req="SELECT * FROM participation ORDER BY "+nom_column+" "+Asc_Dsc+"";
                    Statement ste = cnx.createStatement();
                    ResultSet res=ste.executeQuery(req);
                      while(res.next()){
                          FormationServices se = new FormationServices();
                    Participation pr = new Participation();
                    pr.setId_participation(res.getInt(1));
                    User U = new User();
                    U.setId(res.getInt(2));
                    pr.setUser(U);
                    Formation F = se.readById(res.getInt(3));
                    pr.setForm(F);
                    Date date=res.getDate(4);
                    pr.setDate(date);
                  
                    ta.add(pr);
                }}
                catch (SQLException ex) {
                    Logger.getLogger(ParticipationServices.class.getName()).log(Level.SEVERE, null, ex);
                }
         return (ArrayList<Participation>) ta; 

    }

    @Override
    public Participation readByName(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
     public void likeEvent(Participation p) {
        try {    
                 String sql = "update participation set vote=vote+1 where idU=? and id_formation=?";
        
            PreparedStatement ste = cnx.prepareStatement(sql);
           // ste.setInt(1, p.getVote());
            ste.setInt(1,p.getUser().getId());
            ste.setInt(2,p.getForm().getId_formation());
            ste.executeUpdate();
            System.out.println("like ajouté");
             
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
     public void DislikeEvent(Participation p) {
        try {
            
                 
                 String sql = "update participation set vote=vote-1 where idU=? and id_formation=?";
        
            PreparedStatement ste = cnx.prepareStatement(sql);
           // ste.setInt(1, p.getVote());
            ste.setInt(1,p.getUser().getId());
            ste.setInt(2,p.getForm().getId_formation());
            ste.executeUpdate();
            System.out.println("dislike ajouté");
        }  catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     
        public int[] getLikesAndDislikesCount(Participation p) {
    int[] counts = new int[2];
    try {
        // Préparer la requête SQL pour sélectionner tous les votes pour l'événement donné
        String sql = "SELECT vote FROM participation WHERE id_formation = ?";
        PreparedStatement stmt = cnx.prepareStatement(sql);
        stmt.setInt(1, p.getForm().getId_formation());
        
        // Exécuter la requête SQL et parcourir les résultats pour compter les votes positifs et négatifs
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            int vote = rs.getInt("vote");
            if (vote == 1) {
                counts[0]++;
            } else if (vote == 2) {
                counts[1]++;
            }
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors du calcul du nombre de likes et dislikes : " + ex.getMessage());
    }
    return counts;
}
        
         private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    public void addPropertyChangeListener(PropertyChangeListener listener) {
    pcs.addPropertyChangeListener(listener);
}
        private int likesCount = 0;
    private int dislikesCount = 0;
    
    public void updateLikesAndDislikes(Participation p) {
        int[] newLikesAndDislikes = getLikesAndDislikesCount(p);
        int[] oldLikesAndDislikes = { likesCount, dislikesCount };
        likesCount = newLikesAndDislikes[0];
        dislikesCount = newLikesAndDislikes[1];
        pcs.firePropertyChange("likesAndDislikes", oldLikesAndDislikes, newLikesAndDislikes);
    }
    

    public ObservableList<Participation> betweenDates(LocalDate date1,LocalDate date2) throws SQLException {
      Participation P = new Participation(); 
         ObservableList<Participation> list = FXCollections.observableArrayList();
         try {
             String sql = "SELECT p.*, f.titre, f.Description, f.categorie, f.nbrPlaces, f.prix " +
                     "FROM participation p " +
                     "INNER JOIN formation f ON p.id_formation = f.id_formation " +
                     "WHERE p.date BETWEEN '" + date1 + "' AND '" + date2 + "'";
        
                Statement stmt = cnx.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                P.setId_participation(rs.getInt(1));
                User U = new User();
                P.setUser(U);
                Formation F= new Formation();
                P.setForm(F);
                P.setDate(rs.getDate(2));
                
                 list.add(P);
            }
             } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
        return list ;
    }

    @Override
    public List<Participation> afficherjointure() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participation> afficherrr() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Participation> readBynom(String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public reunion readbyd(Date d) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Participation readbyName(String s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int nbLigne() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}
