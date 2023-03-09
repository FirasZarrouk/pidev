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
import Model.Participant;
import Model.evenements;
import services.participantServices;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class ModifierParticipantsController implements Initializable {

     participantServices ps = new participantServices();
  Participant p = new Participant();
            evenements e = new evenements() ;

    @FXML
    private TextField NomParticipant;
    @FXML
    private TextField PrenomParticipant;
    @FXML
    private TextField RoleParticipant;
    @FXML
    private TextField NomEvenementP;
    private TextField IdEvenementParticipant;
    @FXML
    private Button RetournerPs;
    @FXML
    private TextField TextChercherPart;
    @FXML
    private Label IDparticipant;
    @FXML
    private Label IDevenement;

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
      
      
     void getParticipant (Participant p){
   NomParticipant.setText(p.getNom());
    PrenomParticipant.setText(p.getPrenom()); 
    RoleParticipant.setText(p.getRole()); 
    NomEvenementP.setText(p.getNom_event().getNom_ev());
//    IdEvenementParticipant.setText(Integer.toString(p.getEvent().getID_ev()));
 IDevenement.setText(String.valueOf(p.getEvent().getID_ev()));
    }
    @FXML
    private void ModifierParticipant(ActionEvent event) {
          if (Validechamp(NomParticipant ) &&Validechamp(PrenomParticipant) &&Validechamp(RoleParticipant) &&Validechamp(NomEvenementP)){
          
              String nom = NomParticipant.getText();
             String prenom = PrenomParticipant.getText();
             String Role = RoleParticipant.getText();
            
                p.setNom(NomParticipant.getText());
        p.setPrenom(PrenomParticipant.getText());
        p.setRole(RoleParticipant.getText());
         int idev = Integer.parseInt(IDparticipant.getText());
        p.setID_part(idev);
       
          int idev1 = Integer.parseInt(IDevenement.getText());     
         e.setID_ev(idev1);
      
      
      e.setNom_ev(NomEvenementP.getText() );
        p.setNom_event(e);
        p.setEvent(e);
      
     
     
     ps.modifier(p);
        
         Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Participant modifié");
                 String content = String.format("Le participant est modifié avec succés.");
        a.setContentText(content);
                              
        a.show();
              
          
          }
        
        
    }

    @FXML
    private void RetournerParticipantM(ActionEvent event) throws IOException {
        
        
        // Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetournerPs.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
    }

    @FXML
    private void BTNchercherPart(ActionEvent event) {
        
        
        String name =   TextChercherPart.getText();
    // Appeler le service pour récupérer le evenement correspondant à l'ID
  
   
//evenements evenementsRechercher = (evenements) es.readbyName(name); 
p=ps.readbyName(name);
  if (p != null  ) {
        // Afficher le evenements trouvé dans la ListView
       
        getParticipant(p);
        IDparticipant.setText(String.valueOf(p.getID_part()));
        IDevenement.setText(String.valueOf(p.getEvent().getID_ev()));
        
    }
    }
}
