/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.Interface_IService;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister.Pack;
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
import models.reunion;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AfficherReunionController implements Initializable {

    @FXML
    private ListView<reunion> listereunion;
    @FXML
    private Button afficherR;
    Interface_IService sp= new serviceReunion(); 
    reunion r = new reunion();
    @FXML
    private Button supprimerR;
    @FXML
    private TextField chercherid;
    @FXML
    private Button alleraumodifR;
    @FXML
    private Button allerauajoutR;
    @FXML
    private Button retouracceuilR;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void afficherReunion(ActionEvent event) {
        
       ObservableList<reunion> reunion =FXCollections.observableArrayList(sp.afficher());
       listereunion.setItems(reunion);
    }

    @FXML
    private void supprimerReunion(ActionEvent event) {
        reunion reunionSelectionne = listereunion.getSelectionModel().getSelectedItem();

    if (reunionSelectionne != null) {
        // Appeler le service pour supprimer le pack
        sp.supprimer(reunionSelectionne.getId_reunion());

        // Retirer le pack de la ListView
        listereunion.getItems().remove(reunionSelectionne);
    }
    }

    @FXML
    private void chercherReunion(ActionEvent event) {
        int id = Integer.parseInt(chercherid.getText());

    // Appeler le service pour récupérer le pack correspondant à l'ID
    reunion chercherReunion = (reunion) sp.readById(id);

    if (chercherReunion != null) {
        // Afficher le pack trouvé dans la ListView
        ObservableList<reunion> reunion = FXCollections.observableArrayList(chercherReunion);
        listereunion.setItems(reunion);
    } else {
        // Afficher un message d'erreur si le pack n'a pas été trouvé
        System.out.println("reunion non trouvé");
    }
    }

    @FXML
    private void alleraumodifR(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierReunion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) alleraumodifR.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void allerauajoutR(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterReunion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauajoutR.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void retouracceuilR(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("front.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) retouracceuilR.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    }
    

