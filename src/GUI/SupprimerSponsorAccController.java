/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
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
import Model.sponsors;
import services.sponsorService;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class SupprimerSponsorAccController implements Initializable {

    @FXML
    private Label IDsuppEV;
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
    sponsorService ss = new sponsorService();  
     sponsors s = new sponsors();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprimerEvAcc(ActionEvent event) {
          int idev = Integer.parseInt(IDsuppEV.getText());
      s.setID_sponsors(idev);
       if (s != null) { 
     

//
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Confirmation de suppression");
            alert.setHeaderText(null);
            alert.setContentText("Êtes-vous sûr de vouloir annuler votre sponsorisation ?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {


               // EventService ps = new EventService();
           //   for (String email : emails) {

                


                
           ss.supprimer(s.getID_sponsors());
          
          Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Participation annulé");
                 String content = String.format("Participation est annulé avec succès.");
        a.setContentText(content);
                              
        a.show();
            }}
    }

    @FXML
    private void RetourBTNsupp(ActionEvent event) throws IOException {
          // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeSponsors.fxml"));
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
        s=ss.readbyName(name);
   if (s.getID_sponsors() != 0  ) {IDsuppEV.setText(String.valueOf(s.getID_sponsors()));
 

       String d ="Vous etes sponsorisé a l'evenement "+s.getNom_Evenement().getNom_ev();
      ErreurRechercheS.setText(d); 
      }
    
   else {
     String d ="Vous n'etes pas un sponsor! ";
    ErreurRechercheS.setText(d); 
    }
    
}
}