/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.evenements;
import models.sponsors;
import services.sponsorService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class ModifierSponsorController implements Initializable {
     sponsorService ss = new sponsorService();  
     sponsors s = new sponsors();
    @FXML
    private TextField text_nom_sponsor;
    @FXML
    private TextField text_prenom_sponsor;
    @FXML
    private TextField text_id_evenement;
    @FXML
    private Button R_sponsors;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    void getSponsor (sponsors s){
    text_nom_sponsor.setText(s.getNom());
    text_prenom_sponsor.setText(s.getPrenom()); 
    text_id_evenement.setText(Integer.toString(s.getEv().getID_ev()));

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
    private void Modifier_Sonsors(ActionEvent event) {
        
        if (Validechamp(text_nom_sponsor) &&Validechamp(text_prenom_sponsor) ){
        
            String nom = text_nom_sponsor.getText();
             String prenom = text_prenom_sponsor.getText();
            
            
             
           
        
        s.setNom(text_nom_sponsor.getText());
        s.setPrenom(text_prenom_sponsor.getText());
        evenements e = new evenements() ;
        e.setID_ev(Integer.parseInt(text_id_evenement.getText()));
        s.setEv(e);
        ss.modifier(s);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Sponsor modifié");
                 String content = String.format("Le sponsor est modifié avec succés.");
        a.setContentText(content);
                              
        a.show();}
        
        
        
    }

    @FXML
    private void Retourner_sponsors(ActionEvent event) throws IOException {
        
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherSponsor.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  R_sponsors.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }
    
}
