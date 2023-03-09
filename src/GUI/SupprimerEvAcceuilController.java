/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.evenements;
import services.EventService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class SupprimerEvAcceuilController implements Initializable {
//Connection cnx;
    @FXML
    private Button SuppEvid;
    @FXML
    private Button btnSUPPev;
    @FXML
    private TextField ChercheSupprime;
    @FXML
    private Label ErreurRechercheS;
    @FXML
    private Button cherchebtnupp;
    @FXML
    private Label IDsuppEV;
  EventService es= new EventService();
   public evenements e = new evenements();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
   
    
    

    @FXML
    private void RetourBTNsupp(ActionEvent event) throws IOException {
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homeEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  btnSUPPev.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void chercherBTNSupp(ActionEvent event) {
        String name =   ChercheSupprime.getText();
        e=es.readbyName(name);
   if (e.getID_ev() != 0  ) {IDsuppEV.setText(String.valueOf(e.getID_ev()));
 

       String d ="L'evenement existe  ";
      ErreurRechercheS.setText(d); 
      }
    
   else {
     String d ="L'evenement n'existe pas ! ";
    ErreurRechercheS.setText(d); 
}
    }

 @FXML
    private void SupprimerEvAcc(ActionEvent event) {
          // Récupérer le evenement sélectionné
    
 int idev = Integer.parseInt(IDsuppEV.getText());
      e.setID_ev(idev);
       if (e!= null) { 
     

//
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir supprimer cette ligne ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {


               // EventService ps = new EventService();
           //   for (String email : emails) {

                

es.evoyerEmailToParticipantWhenEventDeleted("y.dorra.yahia@gmail.com", e);
                
           es.supprimer(e.getID_ev());
          
          Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Evenement supprimé");
                 String content = String.format("L'evenement est supprimé avec succés.");
        a.setContentText(content);
                              
        a.show();
            }}}}

//Alert info = new Alert(Alert.AlertType.INFORMATION);
//                info.setTitle("Information");
//                info.setHeaderText(null);
//                info.setContentText("L'évenement a été supprimée avec succès.");
//                Optional<ButtonType> result2 = info.showAndWait();
  
        