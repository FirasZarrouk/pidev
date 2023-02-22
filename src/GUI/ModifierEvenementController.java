/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import models.evenements;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class ModifierEvenementController implements Initializable {

    EventService es= new EventService();
    evenements e = new evenements();
    
   @FXML   
    private Button boutton_modifier;
    @FXML
    private TextField nomEv;
    @FXML
    private DatePicker date_ev;
    @FXML
    private TextField Type_ev;
    @FXML
    private TextField lieu_ev;
    @FXML
    private TextArea description_ev;
    @FXML
    private Button ButtonRetour;
 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     private boolean ValidDate() {
         
        if (date_ev.getValue().compareTo(LocalDate.now()) < 0 ){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("La date ne doit pas etre fixer avant la date actuelle");
            alert.showAndWait();
            return false;
        } return true ;
     }

    void getEvenement(evenements e){
        
    nomEv.setText(e.getNom_ev());
    Type_ev.setText(e.getType_ev());
 
// e.setDate_ev(java.sql.Date.valueOf(d));
    lieu_ev.setText(e.getLieu_ev());
    description_ev.setText(e.getDescription());
    
    
}
     
    
    
    @FXML
    private void modifierEv(ActionEvent event) {
        
        if (ValidDate()){
         String nom = nomEv.getText();
        //LocalDate k = date_ev.getDate(); 
       //Date k = date_ev.getDate();
       String date = date_ev.getValue().toString();
         String type = Type_ev.getText();
         String lieu = lieu_ev.getText();
         String description =  description_ev.getText();
       
        e.setNom_ev(nomEv.getText());
        e.setType_ev(Type_ev.getText());
        LocalDate d = date_ev.getValue(); 
        e.setDate_ev(java.sql.Date.valueOf(d));
        e.setLieu_ev(lieu_ev.getText());
        e.setDescription(description_ev.getText());
      
           es.modifier(e);
           Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Evenement modifié");
                 String content = String.format("L'evenement est modifié avec succés.");
        a.setContentText(content);
                              
        a.show();
    }}

    @FXML
    private void retourner_eve(ActionEvent event) throws IOException {
        
          // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficheEvenemenet.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  ButtonRetour.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
    }
    
}
