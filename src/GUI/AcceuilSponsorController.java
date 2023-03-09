/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import models.Participant;
import models.sponsors;
import services.EventService;
import services.participantServices;
import services.sponsorService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AcceuilSponsorController implements Initializable {

    @FXML
    private Button bntSupprimerEv;
    @FXML
    private Button BTNRECLAMATION;
    @FXML
    private Button bntAcceuilEV;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField chercherAcceuilEv;
    @FXML
    private Label TotalEv;
    @FXML
    private Label TotalSpon;
    @FXML
    private Label TotalPart;
    @FXML
    private VBox pnItems;
    @FXML
    private Button CHercher_ev;
ArrayList<sponsors> Spon = new ArrayList<>(); 
 EventService es= new EventService();
  participantServices ps = new participantServices();
     sponsorService ss= new sponsorService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sponsorService servicePart = new sponsorService();
        Spon.addAll(servicePart.afficher());
        // TODO
       pnItems.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
      
        for(int i = 0; i<Spon.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/ItemAcceuilSponsor.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemAcceuilSponsorController itemcontroller = fxmlLoader.getController();
                itemcontroller.getSponsor(Spon.get(i));
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilSponsorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
            
        }
           TotalEv.setText(String.valueOf(es.nbLigne()));
            TotalSpon.setText(String.valueOf(ss.nbLigne()));
        TotalPart.setText(String.valueOf(ps.nbLigne()));
    }    
       
       

    @FXML
    private void BTNSupprimerEVe(ActionEvent event) throws IOException {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AnnulerSponsoring.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  bntSupprimerEv.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void btnReclamaion(ActionEvent event) {
    }

    @FXML
    private void BTNacceuilEV(ActionEvent event) throws IOException {
            // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("acceuil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  bntAcceuilEV.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void BTNChercherEVENEMENT(ActionEvent event) {
        
        String searchEv = chercherAcceuilEv.getText();
        sponsors Sponchercher = ss.readbyName(searchEv);
        pnItems.getChildren().clear();
        if(Sponchercher != null){
        
        try {
                 FXMLLoader fxmlLoader = new FXMLLoader();
               
                fxmlLoader.setLocation(getClass().getResource("/GUI/ItemAcceuilSponsor.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemAcceuilSponsorController itemcontroller = fxmlLoader.getController();
                itemcontroller.getSponsor(Sponchercher);
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilSponsorController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }

    @FXML
    private void BTNAfficher(ActionEvent event) {
        
        sponsorService servicePart = new sponsorService();
        //Part.addAll(servicePart.afficher());
        // TODO
       pnItems.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
      
        for(int i = 0; i<Spon.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
               
                fxmlLoader.setLocation(getClass().getResource("/GUI/ItemAcceuilSponsor.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemAcceuilSponsorController itemcontroller = fxmlLoader.getController();
                itemcontroller.getSponsor( Spon.get(i));
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilSponsorController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        }
    }
    
}
