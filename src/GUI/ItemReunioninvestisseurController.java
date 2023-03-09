/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Model.reunion;
import services.EmailSender;
import services.servicePV;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class ItemReunioninvestisseurController implements Initializable {

    public reunion Reunion;
     servicePV p = new servicePV();
    serviceReunion r = new serviceReunion();
    reunion Re = new reunion();
    @FXML
    private Button supprimerReunion;
    @FXML
    private Button modifierReunion;
    @FXML
    private Label IDeven;
    @FXML
    private Label valideritemreunion;
    @FXML
    private Label contactitemreunion;
    @FXML
    private Label lieuitemreunion;
    @FXML
    private Label heureitemreunion;
    @FXML
    private Label dateitemreunion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     
    public void getEvent(reunion E){


            contactitemreunion.setText(E.getContactReunion());
            //Description.setText(P.getDescription());
            heureitemreunion.setText(E.getHeureReunion());
            lieuitemreunion.setText(E.getLieuReunion());
            //this.evenements=EP;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(E.getDateReunion()); 
            dateitemreunion.setText(dateEnString);
            valideritemreunion.setText(E.getValider());


            Reunion=E;

    }

    @FXML
    private void supprimerReunion(ActionEvent event) throws IOException {
        r.supprimer(Reunion.getId_reunion());
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/gui/afficherReunion.fxml"));
                Parent root = loader.load();
        Scene scene = new Scene(root);

         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  supprimerReunion.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }


    @FXML
    private void modifierReunion(ActionEvent event) throws IOException {
         reunion selectReunion =(reunion) r.readById(Reunion.getId_reunion());


            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierReunion.fxml"));
             Parent root = loader.load();
        Scene scene = new Scene(root);
           ModifierReunionController ModifierReunionsController=loader.getController();
        ModifierReunionsController.getReunion(selectReunion);
        ModifierReunionsController.r=selectReunion;

//             ModifierEventController=loader.getController();
//            ModifierEventController.getProjet(selectedProjet);
//            ModifierEventController.p=selectedProjet;
         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  modifierReunion.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    
}
