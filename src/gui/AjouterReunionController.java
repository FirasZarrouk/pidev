/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.reunion;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AjouterReunionController implements Initializable {

    @FXML
    private TextField nominv;
    @FXML
    private TextField contactinv;
    @FXML
    private TextField lieuinv;
    @FXML
    private TextField heureinv;
    @FXML
    private TextField prenominv;
    @FXML
    private TextField entrepriseinv;
    @FXML
    private DatePicker dateinv;
    @FXML
    private Button planifierinv;
    @FXML
    private Button modif;
    @FXML
    private Button allerauaffichR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private boolean ValidDate() {

        if (dateinv.getValue().compareTo(LocalDate.now()) < 0 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date ne doit pas etre fixer avant la date actuelle");
            alert.showAndWait();
            return false;
        } return true ;
     }
    private boolean Validechamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <2 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}

    @FXML
    private void ajouterReunion(ActionEvent event) {
         reunion r = new reunion();
       if (ValidDate()){
        r.setNom(nominv.getText());
        r.setPrenom(prenominv.getText());
        r.setEntreprise(entrepriseinv.getText());
        LocalDate d = dateinv.getValue(); 
        r.setDate(java.sql.Date.valueOf(d));
        r.setHeure(heureinv.getText());
        r.setLieu(lieuinv.getText());
        r.setContact(contactinv.getText());
        
           serviceReunion sr= new serviceReunion();
           sr.ajouter(r);
//             Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//        a.setTitle("Localisation ajoutée");
//        a.show();
     }  
    }

    @FXML
    private void allezaumodif(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierReunion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) modif.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void allerauaffichR(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherReunion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauaffichR.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }
    
}
