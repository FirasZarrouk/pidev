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
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.PV;
import models.reunion;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class ModifierReunionController implements Initializable {

    @FXML
    private TextField nominv1;
    @FXML
    private TextField contactinv1;
    @FXML
    private TextField lieuinv1;
    @FXML
    private TextField heureinv1;
    @FXML
    private TextField prenominv1;
    @FXML
    private TextField entrepriseinv1;
    @FXML
    private DatePicker dateinv1;
    @FXML
    private Button planifierinv1;
    @FXML
    private TextField IDinv1;
    @FXML
    private Button retournermodif;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void modifierReunion(ActionEvent event) {
        reunion r = new reunion();
        
        r.setId_reunion(Integer.parseInt(IDinv1.getText()));
        r.setNom(nominv1.getText());
        r.setPrenom(prenominv1.getText());
        r.setEntreprise(entrepriseinv1.getText());
        LocalDate d = dateinv1.getValue(); 
        r.setDate(java.sql.Date.valueOf(d));
        r.setHeure(heureinv1.getText());
        r.setLieu(lieuinv1.getText());
        r.setContact(contactinv1.getText());
        
           serviceReunion sr= new serviceReunion();
           sr.modifier(r);
    }

    @FXML
    private void retourauajout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ajouterReunion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) retournermodif.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
