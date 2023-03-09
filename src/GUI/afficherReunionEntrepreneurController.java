/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Model.Projet;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import Model.reunion;
import Services.ServiceProjet;
import javafx.scene.Scene;
import javafx.stage.Stage;
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
    private TextField chercherReunion;
    
    serviceReunion s = new serviceReunion();
    @FXML
    private Label trouve;
    @FXML
    private Button home;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ServiceProjet sp = new ServiceProjet();
         serviceReunion serviceReunions = new serviceReunion();
         User c;
         c = (SessionManager.getInstance().getCurrentUser());
         System.out.println(c);
        Projet p = sp.chercherbyidP(c);
                 System.out.println(p);
                 
              //   ArrayList<reunion> r = new ArrayList<>();
                //s.chercherbyidp(p);
                 System.out.println(serviceReunions.chercherbyidp(p));
        Reunion.addAll(serviceReunions.chercherbyidp(p));
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

    @FXML
    private void home(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../View/ADMINHOMEENTR.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
        
    }
}
