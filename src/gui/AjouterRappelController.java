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
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.rappel;
import services.serviceRappel;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AjouterRappelController implements Initializable {

    @FXML
    private Button allerauaffichRA;
    @FXML
    private Button ajouterRA;
    @FXML
    private TextField commentaireRA;
    @FXML
    private TextField heureRA;
    @FXML
    private DatePicker dateRA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void allerauaffichRA(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherRappel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauaffichRA.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void ajouterRA(ActionEvent event) {
        rappel ra = new rappel();
        LocalDate d = dateRA.getValue(); 
        ra.setDate(java.sql.Date.valueOf(d));
        ra.setReminder(commentaireRA.getText());
        ra.setHeure(heureRA.getText());
        serviceRappel sr= new serviceRappel();
           sr.ajouter(ra);
          }
    
}
