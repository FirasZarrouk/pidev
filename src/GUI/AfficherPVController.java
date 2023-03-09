/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.Interface_IService;
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
import Model.PV;
import Model.reunion;
import services.servicePV;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AfficherPVController implements Initializable {

    
    Interface_IService sp= new servicePV(); 
    PV p = new PV();
    private TextField chercheridPV;
    private Button alleraumodifPV;
    private Button allerauajoutPV;
    private Button retouracceuilPV;
    @FXML
    private Button affichPajoutP;
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
      ArrayList<PV> PV = new ArrayList<>();
    @FXML
    private Button home;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         // TODO
         servicePV servicePVs = new servicePV();
        PV.addAll(servicePVs.afficher());
        // TODO
       pnItems.getChildren().clear();


        Node [] nodes = new  Node[15];



        for(int i = 0; i<PV.size() ; i++)
        {

                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemPV.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemPVController itemcontroller = fxmlLoader.getController();
                itemcontroller.getPV(PV.get(i));




                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherPVController.class.getName()).log(Level.SEVERE, null, ex);
                }



        }
        // TODO
    }    

    

    @FXML
    private void affichPajoutP(ActionEvent event) { 
    }

    @FXML
    private void home(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMINHOME.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  home.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
    }
    
}
