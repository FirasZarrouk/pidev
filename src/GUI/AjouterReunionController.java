/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Interfaces.Interface_IService;
import Model.Projet;
import Model.SessionManager;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.reunion;
import services.serviceReunion;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class AjouterReunionController implements Initializable {

    @FXML
    private TextField contactinv;
    @FXML
    private TextField lieuinv;
    @FXML
    private TextField heureinv;
    @FXML
    private DatePicker dateinv;
    @FXML
    private Button planifierinv;
    private Button modif;
    @FXML
    private Button allerauaffichR;
    Interface_IService sp= new serviceReunion();
    @FXML
    private Button Home;
    @FXML
    private Button allerauprojet;
    
    public Projet projet ;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getProjet(Projet P){
        
        projet=P;
        
        
    }
    private boolean ValidDate() {

        if (dateinv.getValue().compareTo(LocalDate.now()) < 0 ){
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
            alert.setContentText("Veuillez vérifier votre saisie s'il vous plait!!");
            alert.showAndWait();
      return false;
    }return true;
}
    
    
    
    @FXML
    private void ajouterReunion(ActionEvent event) {
        
        
        
        reunion r = new reunion();
         Date d;
        LocalDate dr = dateinv.getValue();
        d = (java.sql.Date.valueOf(dr));
        
    
    reunion i= sp.readbyd(d);

    if  (i.getDateReunion()==null) {
        r.setId(SessionManager.getInstance().getCurrentUser());
//        int c ;
//         c = projet.getId().getId();
//         System.out.println(c);
        r.setDateReunion(d);
        r.setHeureReunion(heureinv.getText());
        r.setLieuReunion(lieuinv.getText());
        r.setContactReunion(contactinv.getText());
        r.setValider("non validée");
        r.setId_projet(projet);
        
       //r.setID_enrepreneur(projet.getId().getId());
        serviceReunion sr= new serviceReunion();
        sr.ajouter(r);
        Image image=new Image("file://C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/GUI/img/logo.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("reunion planifiée");
        notifications.title("reunion");
        notifications.hideAfter(Duration.seconds(4));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
        
        
        
    } else {
        System.out.println("date reservée");
        Image image=new Image("file://C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/GUI/img/logo.png");

        Notifications notifications=Notifications.create();
        notifications.graphic(new ImageView(image));
        notifications.text("date reservée");
        notifications.title("date");
        notifications.hideAfter(Duration.seconds(4));
        /*notifications.darkStyle();*/
     /*   notifications.position(Pos.BOTTOM_CENTER);*/
        notifications.show();
        
        
//             Alert a = new Alert(Alert.AlertType.CONFIRMATION);
//        a.setTitle("Localisation ajoutée");
//        a.show();
    }  }

    

    @FXML
    private void allerauaffichR(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("afficherReunioninvestisseur.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauaffichR.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void allezauHomeR(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../ViewInves/ADMINHOMEINVES.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) allerauaffichR.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    @FXML
    private void allerauprojet(ActionEvent event) {
    }
    
}
