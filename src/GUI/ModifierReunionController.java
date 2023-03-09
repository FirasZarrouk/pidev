/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import Model.PV;
import Model.reunion;
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
    
    public reunion Reunion;
    
    reunion r = new reunion();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   
    
    public void getReunion(reunion E){


            contactinv1.setText(E.getContactReunion());
            //Description.setText(P.getDescription());
            heureinv1.setText(E.getHeureReunion());
            lieuinv1.setText(E.getLieuReunion());
            //this.evenements=EP;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(E.getDateReunion()); 
            


            Reunion=E;

    }

    @FXML
    private void modifierReunion(ActionEvent event) {
        
        
        
        LocalDate d = dateinv1.getValue(); 
        Reunion.setDateReunion(java.sql.Date.valueOf(d));
        Reunion.setHeureReunion(heureinv1.getText());
        Reunion.setLieuReunion(lieuinv1.getText());
        Reunion.setContactReunion(contactinv1.getText());
        
           serviceReunion sr= new serviceReunion();
           sr.modifier(Reunion);
    }

    @FXML
    private void retourauajout(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherReunion.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) retournermodif.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
