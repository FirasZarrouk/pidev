/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.io.IOException;
import models.evenements;
import services.EventService ;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class AjouterEvenementController implements Initializable {

     EventService es= new EventService();
    
    @FXML
    private TextField nomEv;
    @FXML
    private Button boutton_ajouter;
    @FXML
    private DatePicker date_ev;
    @FXML
    private TextField Type_ev;
    @FXML
    private TextField lieu_ev;
    @FXML
    private TextArea description_ev;
    @FXML
    private Button ButtonAfficher;
    @FXML
    private TextField tarifEvs;
    
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
    
     private boolean Validechamp(TextField T){
         if(T.getText().isEmpty() | T.getLength() <2 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez tout remplir svp");
            alert.showAndWait();
      return false;
    }return true;
}
      private boolean Validechamps(TextArea T){
         if(T.getText().isEmpty() | T.getLength() <2 ){
          Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Erreur de champ");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez tout remplir svp");
            alert.showAndWait();
      return false;
    }return true;
}
    
    @FXML
    private void ajoutEv(ActionEvent event) {
       
      if (Validechamp(nomEv) &&Validechamp(Type_ev) &&Validechamp(lieu_ev) && Validechamp(tarifEvs) && Validechamps(description_ev)&&ValidDate()){
        evenements e = new evenements();
       
        e.setNom_ev(nomEv.getText());
        e.setType_ev(Type_ev.getText());
        LocalDate d = date_ev.getValue(); 
        e.setDate_ev(java.sql.Date.valueOf(d));
        e.setLieu_ev(lieu_ev.getText());
        e.setTarif_Ev(tarifEvs.getText());
        e.setDescription(description_ev.getText());
        
          
           es.ajouter(e);

 Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Evenement ajoutée");
                 String content = String.format("L'evenemet est ajoutée avec succés.");
        a.setContentText(content);
                              
        a.show();
    }}

    @FXML
    private void afficher_eve(ActionEvent event) throws IOException  {
    
       

// Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("homeEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) ButtonAfficher.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
        
    }

   
    
}
