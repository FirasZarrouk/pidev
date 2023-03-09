/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.SessionManager;
import Model.User;
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
import Model.reunion;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AfficherReunioninvestisseurController implements Initializable {

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
     ArrayList<reunion> Reunion = new ArrayList<>();
    @FXML
    private Button homeRInveti;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         serviceReunion serviceReunions = new serviceReunion();
         User c;
         c = (SessionManager.getInstance().getCurrentUser());

        Reunion.addAll(serviceReunions.chercherbyid(c));
        // TODO
       pnItems.getChildren().clear();


        Node [] nodes = new  Node[15];



        for(int i = 0; i<Reunion.size() ; i++)
        {

                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/gui/itemReunioninvestisseur.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemReunioninvestisseurController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEvent(Reunion.get(i));




                    pnItems.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(afficherReunionController.class.getName()).log(Level.SEVERE, null, ex);
                }



        }
    }    


    @FXML
    private void BTNChercherEVENEMENT(ActionEvent event) {
    }

    @FXML
    private void homeRInveti(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewInves/ADMINHOMEINVES.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) homeRInveti.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
    
}
