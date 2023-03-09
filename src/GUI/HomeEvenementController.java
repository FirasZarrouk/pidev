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
import models.evenements;
import services.EventService;
import services.participantServices;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class HomeEvenementController implements Initializable {

    @FXML
    private Button btnAjouterEv;
    @FXML
    private Button btnModifEv;
    @FXML
    private Button bntSupprimerEv;
    @FXML
    private Button BTNRECLAMATION;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox pnItems;
    ArrayList<evenements> Event = new ArrayList<>(); 
    @FXML
    private Button CHercher_ev;
    @FXML
    private Button bntAcceuilEV;
    @FXML
    private TextField chercherAcceuilEv;
 //evenements E = new evenements();
     EventService es= new EventService();
    @FXML
    private Label TotalEv ;
    @FXML
    private Label TotalSpon;
    @FXML
    private Label TotalPart;
     participantServices ps = new participantServices();
     services.sponsorService ss= new services.sponsorService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         EventService serviceEvent = new EventService();
        Event.addAll(serviceEvent.afficher());
        // TODO
       pnItems.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Event.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/itemEvenement.fxml"));
                AnchorPane abc = fxmlLoader.load();
                itemEvenementController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(Event.get(i));
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(HomeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
           
        }
        
     TotalEv.setText(String.valueOf(es.nbLigne()));
     TotalSpon.setText(String.valueOf(ss.nbLigne()));
        TotalPart.setText(String.valueOf(ps.nbLigne()));
    }    

    @FXML
    private void BtnAjouterEvenement(ActionEvent event) throws IOException {
           // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnAjouterEv.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void BTNModifierEVe(ActionEvent event) throws IOException {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
          
     //   evenements selectedEvenemet=Event.getSelectionModel().getSelectedItem();
         ModifierEvenementController ModifierEvenementController=loader.getController();
        //ModifierEvenementController.getEvenement(selectedEvenemet);
        //ModifierEvenementController.e=selectedEvenemet;

        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnModifEv.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void BTNSupprimerEVe(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerEvAcceuil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnAjouterEv.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
           
    }

    @FXML
    private void btnReclamaion(ActionEvent event) {
    }

   

    @FXML
    private void BTNChercherEVENEMENT(ActionEvent event) {
        String searchEv = chercherAcceuilEv.getText();
        evenements EvenementChercher = es.readbyName(searchEv);
        pnItems.getChildren().clear();
        if(EvenementChercher != null){
        
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/itemEvenement.fxml"));
               
                AnchorPane abc = fxmlLoader.load();
                itemEvenementController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(EvenementChercher);
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(HomeEvenementController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
       
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
    
}
