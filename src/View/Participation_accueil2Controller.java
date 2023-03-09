/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.Formation_accueilADController;
import GUI.ItemADMINController;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.Formation;
import Model.Participation;
import services.FormationServices;
import services.ParticipationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Participation_accueil2Controller implements Initializable {

    @FXML
    private Button quitter;
    @FXML
    private Button rechercher;
    @FXML
    private VBox vbox;
    @FXML
    private ScrollPane scrol;
    @FXML
    private GridPane grid;
    
    private List<Participation> participations = new ArrayList<>();
    
    FormationServices fs = new FormationServices();
    ParticipationServices ps = new ParticipationServices();
    
    @FXML
    private Button ajouter;
    @FXML
    private DatePicker date1;
    @FXML
    private DatePicker date2;
    
    
    
     private List<Participation> getData() {
    List<Participation> participations = new ArrayList<>();
    ParticipationServices participationServices = new ParticipationServices();
    List<Participation> allParticipations = participationServices.afficher();
    for (Participation participation : allParticipations) {
        participations.add(participation);
    }
    Participation par;
 
    return participations;
}
     private ObservableList<Node> nodesList;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          // TODO
          participations.addAll(getData());
          
        int column =0;
        int row=1;
        try {
            for(int i=0;i<participations.size();i++){
                
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("itemPAR.fxml"));
            AnchorPane anchorpane = fxmlloader.load();
            ItemPARController itemController = fxmlloader.getController();
            itemController.setData(participations.get(i));
            if (column==3)
            { 
                column=0;
                row++;
            }
            grid.add(anchorpane , column++ , row);
            
            //set gridWidth
            grid.setMinWidth(Region.USE_COMPUTED_SIZE);
            grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
            grid.setMaxWidth(Region.USE_PREF_SIZE);
            
            //SET GRIDhEIGHT
            grid.setMinHeight(Region.USE_COMPUTED_SIZE);
            grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
            grid.setMaxHeight(Region.USE_PREF_SIZE);
        
            GridPane.setMargin(anchorpane,new Insets(18));
            }
        } catch (IOException ex) {
            Logger.getLogger(Participation_accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
           //ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(Participation_accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        nodesList = FXCollections.observableArrayList(grid.getChildren());
        
    }    


    @FXML
    private void quitter(ActionEvent event) {
         // Récupérer le stage actuel et le fermer
    Stage stage = (Stage) quitter.getScene().getWindow();
    stage.close();
    }

    @FXML
    private void rechercher(ActionEvent event) throws SQLException, IOException {
        // Récupérer les dates à partir des champs de texte
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate datee1 = date1.getValue();
        LocalDate datee2 = date2.getValue();
        // Appeler la méthode betweenDates pour récupérer les participations entre les deux dates

         ObservableList<Participation> participations = ps.betweenDates(datee1, datee2);;
        vbox.getChildren().clear();
    for (Participation par : participations) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/itemPAR.fxml"));
        AnchorPane formationCard = fxmlLoader.load();
    ItemPARController formationCardController = fxmlLoader.getController();
    formationCardController.setData(par);
    vbox.getChildren().add(formationCard);
          
    }

    }

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
        // Charger l'interface suivante à partir de son fichier FXML
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_accueil2.fxml"));
         
    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    
}
