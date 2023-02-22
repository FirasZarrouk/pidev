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
import models.PV;
import models.reunion;
import services.servicePV;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AfficherPVController implements Initializable {

    @FXML
    private ListView<PV> listePV;
    @FXML
    private Button afficherPV;
    Interface_IService sp= new servicePV(); 
    PV p = new PV();
    @FXML
    private Button supprimerPV;
    @FXML
    private TextField chercheridPV;
    @FXML
    private Button alleraumodifPV;
    @FXML
    private Button allerauajoutPV;
    @FXML
    private Button retouracceuilPV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficherPV(ActionEvent event) {
        ObservableList<PV> PV =FXCollections.observableArrayList(sp.afficher());
       listePV.setItems(PV);
    }

    @FXML
    private void supprimerPV(ActionEvent event) {
        PV PVSelectionne = listePV.getSelectionModel().getSelectedItem();

    if (PVSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sp.supprimer(PVSelectionne.getID_PV());

        // Retirer le pack de la ListView
        listePV.getItems().remove(PVSelectionne);
    }
    }

    @FXML
    private void chercherPV(ActionEvent event) {
        int id = Integer.parseInt(chercheridPV.getText());

    // Appeler le service pour récupérer le pack correspondant à l'ID
    PV chercherPV = (PV) sp.readById(id);

    if (chercherPV != null) {
        // Afficher le pack trouvé dans la ListView
        ObservableList<PV> PV = FXCollections.observableArrayList(chercherPV);
        listePV.setItems(PV);
    } else {
        // Afficher un message d'erreur si le pack n'a pas été trouvé
        System.out.println("PV non trouvé");
    }
    }

    @FXML
    private void alleraumodifPV(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierPV.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) alleraumodifPV.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void allerauajoutPV(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterPV.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauajoutPV.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void retouracceuilPV(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("front.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) retouracceuilPV.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
