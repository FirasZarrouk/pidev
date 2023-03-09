/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import models.reunion;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class afficherReunionEntrepreneurController implements Initializable {

    @FXML
    private Button affichRajoutR;
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
    
    ArrayList<reunion> Reunion = new ArrayList<>();
    @FXML
    private TextField chercherReunion;
    @FXML
    private Button chercherReunionE;
    
    serviceReunion s = new serviceReunion();
    @FXML
    private Label trouve;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         serviceReunion serviceReunions = new serviceReunion();
        Reunion.addAll(serviceReunions.afficher());
        // TODO
       pnItems.getChildren().clear();


        Node [] nodes = new  Node[15];



        for(int i = 0; i<Reunion.size() ; i++)
        {

                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemReunionentrepreneur.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemReunionEntrepreneurController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(Reunion.get(i));




                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(afficherReunionEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
                }



        }

    }    

    @FXML
    private void affichRajoutR(ActionEvent event) {
    }

    @FXML
    private void chercherReunionE(ActionEvent event) {
       String lieuch = chercherReunion.getText();
        reunion reunionchercher =s.chercherparlieu(lieuch);
        // TODO
       pnItems.getChildren().clear();


       


       if(reunionchercher!=null){
        
        {

                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemReunionentrepreneur.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemReunionEntrepreneurController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(reunionchercher);




                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(afficherReunionEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
                }



        }
    }
       else{
           trouve.setText("reunion introuvable");
       }
    }
}
