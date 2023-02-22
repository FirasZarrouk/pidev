/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.rappel;
import services.serviceRappel;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class ModifierRappelController implements Initializable {

    @FXML
    private TextField commentaireRAm;
    @FXML
    private TextField heureRAm;
    @FXML
    private DatePicker dateRAm;
    @FXML
    private Button allerauaffichRA1;
    @FXML
    private Button modifierRA;
    rappel ra = new rappel();
    serviceRappel sr = new serviceRappel();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }  
    void getrappel(rappel ra){
        
    commentaireRAm.setText(ra.getReminder());
    heureRAm.setText(ra.getHeure());
 
    
    
    
}

    @FXML
    private void allerauaffichRA1(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherRappel.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauaffichRA1.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifierRA(ActionEvent event) {
        String date = dateRAm.getValue().toString();
        String reminder = heureRAm.getText();
        String commentaire = commentaireRAm.getText();
        ra.setHeure(heureRAm.getText());
        ra.setReminder(commentaireRAm.getText());
        LocalDate d = dateRAm.getValue();
        ra.setDate(java.sql.Date.valueOf(d));
        sr.modifier(ra);
        
    }
    
}
