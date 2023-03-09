/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Model.evenements;
import services.EventService;





/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class itemEvenementController implements Initializable {

    @FXML
    private AnchorPane abc;
    @FXML
    private Label NomEvenementss;
    @FXML
    private Label TypeEvenetss;
    @FXML
    private Label DescEvents;
    @FXML
    private ImageView Imgqr;
    @FXML
    private Button delete;
    @FXML
    private Label dateEvs;
    @FXML
    private Label LieuEvss;
    public evenements Event ;
    @FXML
    private Label TarifEvenetss1;
    @FXML
    private Button ModifEVts;
    @FXML
    private Button details1;
    @FXML
    private Label IDeven;

    evenements E = new evenements();
     EventService es= new EventService();
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 public void getEvent(evenements E){
        
        
           NomEvenementss.setText(E.getNom_ev());
            //Description.setText(P.getDescription());
            TypeEvenetss.setText(E.getType_ev());
            DescEvents.setText(E.getDescription());
            LieuEvss.setText(E.getLieu_ev());
            TarifEvenetss1.setText(E.getTarif_Ev());
            //this.evenements=EP;
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(E.getDate_ev()); 
            dateEvs.setText(dateEnString);
            
           
            Event=E;
        
    }
    @FXML
    private void btndetailsEv(ActionEvent event) throws IOException, ParseException {
         evenements selectedEvenements =(evenements) es.readById(Event.getID_ev());
         
         FXMLLoader loader = new FXMLLoader(getClass().getResource("DetailEvenement.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        DetailEvenementController ModifierEventController=loader.getController();
        ModifierEventController.getEvenement(selectedEvenements);
        ModifierEventController.e=selectedEvenements;
        
        
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  details1.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
    }

    @FXML
    private void deletevv(ActionEvent event) throws IOException {
        
               es.supprimer(Event.getID_ev());
                FXMLLoader loader= new FXMLLoader(getClass().getResource("/GUI/homeEvenement.fxml"));
                Parent root = loader.load();
        Scene scene = new Scene(root);
        
         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  delete.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
        
               
    }
    
   

    @FXML
    private void BTNmodifEves(ActionEvent event) throws IOException {
     
//      int idev = Integer.parseInt(IDeven.getText());
//       E.setID_ev(idev);
       evenements selectedEvenements =(evenements) es.readById(Event.getID_ev());
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierEvent.fxml"));
             Parent root = loader.load();
        Scene scene = new Scene(root);
           ModifierEventController ModifierEventController=loader.getController();
        ModifierEventController.getEvenement(selectedEvenements);
        ModifierEventController.e=selectedEvenements;

//             ModifierEventController=loader.getController();
//            ModifierEventController.getProjet(selectedProjet);
//            ModifierEventController.p=selectedProjet;
         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  ModifEVts.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
      //  String
//        evenements selectedEvenement = (evenements)es.readById(Integer.valueOf(IDeven.getText()));
//        
//        
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("modifierEvenement.fxml"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        
//        
//          ModifierEvenementController ModifierEvenementController=loader.getController();
//      
//        ModifierEvenementController.getEvenement(selectedEvenement);
//        ModifierEvenementController.e=selectedEvenement;
//        
//        
//        
//         // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
//        Stage stage = (Stage)  ModifEVts.getScene().getWindow();
//         // Modifier la scène de la fenêtre pour la nouvelle scène
//        stage.setScene(scene);
//         // Afficher la nouvelle interface
//        stage.show();
        
    }
    
    
}
