/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
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
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import Model.evenements;
import services.EventService;

import java.net.URL;
import java.text.ParseException;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker.State;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class DetailEvenementController implements Initializable {
public evenements e = new evenements();
EventService es= new EventService();
    @FXML
    private Label Description;
    private Button modifierPr;
    @FXML
    private Button Retour;
    @FXML
    private Label iddetails;
    @FXML
    private Label Nom_de_evenemnt;
    @FXML
    private Label TypeEvv;
    @FXML
    private Label dateEvvss;
    @FXML
    private Label lieu;

    @FXML
    private WebView webview;
    @FXML
    private Label tarifEv;
    
    
     public static double lon;
        public static double lat;

    private WebView webviews;
    private WebEngine webengine;
    @FXML
    private Label label_jours_restant;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          webengine = webview.getEngine();

        url = this.getClass().getResource("map/index.html");
        webengine.load(url.toString());

    }    

    
    
     private int CountDay( Date d) throws ParseException{
    
          SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
          Date localDates = new Date();
        String dateString = sdf.format(d);
          Date dateApres = sdf.parse(dateString);

          
         long diff = dateApres.getTime() - localDates.getTime() ;
         float res = ((diff / (1000*60*60*24))+1);
         System.out.println("Nombre de jours entre les deux dates est: "+res);        
    return (int) res ;
    
    }
    
    
    
    void getEvenement(evenements e) throws ParseException{
        
    Nom_de_evenemnt.setText(e.getNom_ev());
    TypeEvv.setText(e.getType_ev());
 tarifEv.setText(e.getTarif_Ev());
   SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String dateEnString = format.format(e.getDate_ev()); 
 
 dateEvvss.setText(dateEnString);
//e.setDate_ev(java.sql.Date.valueOf(d));

    lieu.setText(e.getLieu_ev());
    Description.setText(e.getDescription());
    
    
    String d ="Il vous reste: "+CountDay(e.getDate_ev())+"jours pour participer a cet evenement";
   
    label_jours_restant.setText(d); 
    
}
//  public void getdetails(evenements e){
//        
//        
//        iddetails.setText(String.valueOf(e.getID_ev()));
//        Nom_de_evenemnt.setText(e.getNom_ev());
//        Categoried.setText(P.getCategorie());
//        Technologied.setText(P.getTechnologie());
//        Tache_projetd.setText(P.getTache_de_projet());
//        Description.setText(e.getDescription());
//        
//    }

  

    @FXML
    private void RetourPP(ActionEvent event) throws IOException {
// Charger le fichier FXML de la nouvelle interface
        FXMLLoader loader = new FXMLLoader(getClass().getResource("HomeParticipants.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  Retour.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        
    }
    private void tt(ActionEvent event) {
      
           
             lat = (Double) webviews.getEngine().executeScript("lat");
             lon = (Double) webviews.getEngine().executeScript("lon");


        System.out.println("Lat: " + lat);
                System.out.println("LOn " + lon);


    }

// JavaScript interface object
private class JavaApp {
  public void exit() {
    Platform.exit();
  }

    }
}