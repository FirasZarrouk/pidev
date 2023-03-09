/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.Interface_IService;
import Model.PV;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import services.servicePV;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AfficherPVinvestisseurController implements Initializable {

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
    private TextField chercherAcceuilEv;
    @FXML
    private VBox pnItems;
    @FXML
    private Button CHercher_ev;
    Interface_IService sp= new servicePV(); 
    PV p = new PV();
     ArrayList<PV> PV = new ArrayList<>();

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
                fxmlLoader.setLocation(getClass().getResource("../GUI/itemPVInvesti.fxml"));
                AnchorPane add = fxmlLoader.load();
                ItemPVInvestisseurController itemcontroller = fxmlLoader.getController();
                itemcontroller.getPV(PV.get(i));




                    pnItems.getChildren().add(add);
                } catch (IOException ex) {
                    Logger.getLogger(AfficherPVController.class.getName()).log(Level.SEVERE, null, ex);
                }



        }
        // TODO
        // TODO
    }    

    @FXML
    private void affichPajoutP(ActionEvent event) {
    }

    @FXML
    private void BTNChercherEVENEMENT(ActionEvent event) {
    }
    
}
