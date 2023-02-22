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
import models.PV;
import models.reunion;
import services.servicePV;
import services.serviceReunion;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AjouterPVController implements Initializable {

    @FXML
    private TextField nompv;
    @FXML
    private TextField commentairepv;
    @FXML
    private TextField prenompv;
    @FXML
    private DatePicker datepv;
    @FXML
    private Button ajouterpv;
    @FXML
    private TextField IDpv;
    @FXML
    private Button modifpv;
    @FXML
    private Button allerauaffichPV;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterpv(ActionEvent event) {
         PV r = new PV();
       
        r.setNom(nompv.getText());
        r.setPrenom(prenompv.getText());
        LocalDate d = datepv.getValue(); 
        r.setDate(java.sql.Date.valueOf(d));
        r.setCommentaire(commentairepv.getText());
        reunion re = new reunion();
        re.setId_reunion(Integer.parseInt(IDpv.getText()));
        r.setId_reunion(re);
           servicePV sr= new servicePV();
           sr.ajouter(r);
//             Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//        a.setTitle("Localisation ajoutée");
//        a.show();
//        
    }

    @FXML
    private void modifpv(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierPV.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) modifpv.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void allerauaffichPV(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherPV.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauaffichPV.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
