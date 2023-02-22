/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.Interface_IService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.rappel;
import services.serviceRappel;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AfficherRappelController implements Initializable {

    @FXML
    private TextField chercherid;
    @FXML
    private Button afficherRA;
    @FXML
    private Button supprimerRA;
    @FXML
    private Button modifierRA;
    @FXML
    private Button allerauajoutRA;
    @FXML
    private Button retouracceuilRA;
    @FXML
    private ListView<rappel> listerrappel;
    
    Interface_IService sp= new serviceRappel(); 
    rappel ra = new rappel();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherRA(ActionEvent event) {
         ObservableList<rappel> rappel =FXCollections.observableArrayList(sp.afficher());
       listerrappel.setItems(rappel);
    }

    @FXML
    private void supprimerRA(ActionEvent event) {
        rappel rappelSelectionne = listerrappel.getSelectionModel().getSelectedItem();

    if (rappelSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sp.supprimer(rappelSelectionne.getID_rappel());

        // Retirer le pack de la ListView
        listerrappel.getItems().remove(rappelSelectionne);
    }
    }

    @FXML
    private void chercherRappel(ActionEvent event) {
        int id = Integer.parseInt(chercherid.getText());

    // Appeler le service pour récupérer le pack correspondant à l'ID
    rappel chercherrappel = (rappel) sp.readById(id);

    if (chercherrappel != null) {
        // Afficher le pack trouvé dans la ListView
        ObservableList<rappel> rappel = FXCollections.observableArrayList(chercherrappel);
        listerrappel.setItems(rappel);
    } else {
        // Afficher un message d'erreur si le pack n'a pas été trouvé
        System.out.println("rappel non trouvé");
    }
    }

    @FXML
    private void modifierRA(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Modifierrappel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        rappel selectedrappel=listerrappel.getSelectionModel().getSelectedItem();
         ModifierRappelController ModifierrappelController=loader.getController();
        ModifierrappelController.getrappel(selectedrappel);
        ModifierrappelController.ra =selectedrappel ;
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  modifierRA.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void allerauajoutRA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterRappel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauajoutRA.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void retouracceuilRA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("front.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) retouracceuilRA.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
