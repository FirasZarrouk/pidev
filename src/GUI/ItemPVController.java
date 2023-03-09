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
import Model.PV;
import Model.reunion;
import services.servicePV;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class ItemPVController implements Initializable {

    @FXML
    private Button supprimerPV;
    @FXML
    private Button verifierPV;
    @FXML
    private Button modifierPV;
    @FXML
    private Label verifieritemPV;
    @FXML
    private Label commentaireitemPV;
    @FXML
    private Label dateitemPV;
    @FXML
    private Label IDPV;
    @FXML
    private Label IDR;
    public PV PVs;
    servicePV p = new servicePV();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void getPV(PV E){


            
           
            commentaireitemPV.setText(E.getCommentaire());
            //this.evenements=EP;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(E.getDatePV()); 
            dateitemPV.setText(dateEnString);
            verifieritemPV.setText(E.getVerifier());


            PVs=E;

    }
    

    @FXML
    private void supprimerPV(ActionEvent event) throws IOException {
        p.supprimer(PVs.getID_PV());
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/gui/afficherPV.fxml"));
                Parent root = loader.load();
        Scene scene = new Scene(root);

         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  supprimerPV.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void verifierPV(ActionEvent event) throws IOException {
        PV selectPVs =(PV) p.readById(PVs.getID_PV());
        selectPVs.setVerifier("Verifiée");
        p.modifier(selectPVs);
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/gui/afficherPV.fxml"));
                Parent root = loader.load();
        Scene scene = new Scene(root);

         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  verifierPV.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void modifierPV(ActionEvent event) throws IOException {
         PV selectPVs =(PV) p.readById(PVs.getID_PV());


            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierPV.fxml"));
             Parent root = loader.load();
        Scene scene = new Scene(root);
           ModifierPVController ModifierPVsController=loader.getController();
        ModifierPVsController.getPV(selectPVs);
        ModifierPVsController.PVs=selectPVs;

//             ModifierEventController=loader.getController();
//            ModifierEventController.getProjet(selectedProjet);
//            ModifierEventController.p=selectedProjet;
         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  modifierPV.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

   

    
}
