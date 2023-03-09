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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.sponsors;
import Model.evenements;
import services.EventService;
import services.sponsorService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AjouterSponsorController implements Initializable {
    sponsorService ss = new sponsorService(); 
    @FXML
    private TextField text_nom_sponsor;
    @FXML
    private TextField text_prenom_sponsor;
    private TextField text_id_evenement;
    @FXML
    private Button R_sponsor;
    @FXML
    private Label idSpon;
    @FXML
    private Label idEv;
    @FXML
    private TextField text_Nom_evenement;
EventService es= new EventService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void Ajouter_Sonsors(ActionEvent event) {
    if (Validechamp(text_nom_sponsor) &&Validechamp(text_prenom_sponsor) ){
        sponsors s = new sponsors();
        
        s.setNom(text_nom_sponsor.getText());
        s.setPrenom(text_prenom_sponsor.getText());
        evenements e = new evenements() ;
     //   e.setID_ev(Integer.parseInt(text_id_evenement.getText()));
      
        
        e.setNom_ev( text_Nom_evenement.getText() );

      evenements k = es.readbyName(text_Nom_evenement.getText());
               // int idev = Integer.parseInt(IDEvenementPP.getText());
      if(k.getID_ev()==0){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("L'evenement n'existe pas ! ");
            alert.showAndWait();
      
      }
      else { 
               
               e.setID_ev(k.getID_ev()); 
       
       
       
                s.setNom_Evenement(e);
                s.setEv(e);
        
        s.setEv(e);
        ss.ajouter(s);
        
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Sponsor ajoutée");
                 String content = String.format("Le sponsor est ajoutée avec succés.");
        a.setContentText(content);
                              
        a.show();
    }}}

    @FXML
    private void Retourner_sponsor(ActionEvent event) throws IOException {
          // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeSponsors.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) R_sponsor.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }
    
}
