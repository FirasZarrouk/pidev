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

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class HomeSponsorsController implements Initializable {

    @FXML
    private Button btnAjouterPart;
    @FXML
    private Button btnModifPart;
    @FXML
    private Button bntSupprimerPart;
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
    private Label TotalEv;
    @FXML
    private VBox pnItems;
    @FXML
    private Button CHercher_part;
    @FXML
    private Button bntcroissant;
    @FXML
    private Button btnDesc;
    @FXML
    private TextField chercherAcceuilPar;
    ArrayList<evenements> Event = new ArrayList<>(); 
    EventService es= new EventService();

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
                fxmlLoader.setLocation(getClass().getResource("/GUI/ItemSponsorEvent.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemSponsorEventController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(Event.get(i));
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(HomeSponsorsController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
            
        }
           TotalEv.setText(String.valueOf(es.nbLigne()));
    }    

    @FXML
    private void BtnAjouterParticipant(ActionEvent event) throws IOException {
   // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterSponsor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) btnAjouterPart.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
            
            }

    @FXML
    private void BTNModifierParT(ActionEvent event) throws IOException {
         // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierSponsor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) btnAjouterPart.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void BTNSupprimerPart(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerSponsorAcc.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) btnAjouterPart.getScene().getWindow();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AcceuilUtilisateur.fxml"));
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
    private void BTNChercherPartiCIPANT(ActionEvent event) {
        
         
        String searchEv = chercherAcceuilPar.getText();
        evenements EvenementChercher = es.readbyName(searchEv);
        pnItems.getChildren().clear();
        if(EvenementChercher != null){
        
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ItemSponsorEvent.fxml"));
               
                AnchorPane abc = fxmlLoader.load();
               ItemSponsorEventController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(EvenementChercher);
                
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(HomeParticipantsController.class.getName()).log(Level.SEVERE, null, ex);
                }
        }}

    @FXML
    private void BTNprixCroi(ActionEvent event) {
          // Events = new ArrayList<>(); 
       ArrayList<evenements> Events  = es.sortBy("Tarif_Ev", "ASC");
        pnItems.getChildren().clear();
      
         for(int i = 0; i<Events.size() ; i++)
        {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ItemParticipantEvenement.fxml"));
               
                AnchorPane abc = fxmlLoader.load();
                ItemParticipantEvenementController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(Events.get(i)  );
                //
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(HomeParticipantsController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    }
    }

    @FXML
    private void prixDecroissantPart(ActionEvent event) {
   ArrayList<evenements> Events  = es.sortBy("Tarif_Ev", "DESC");
        pnItems.getChildren().clear();
      
         for(int i = 0; i<Events.size() ; i++)
        {
        try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/ItemParticipantEvenement.fxml"));
               
                AnchorPane abc = fxmlLoader.load();
                ItemParticipantEvenementController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(Events.get(i)  );
                //
                
                
                
                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(HomeParticipantsController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
    } }
    
}
