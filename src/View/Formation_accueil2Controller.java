/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.Formation;
import Interfaces.Interface_IService;
import services.FormationServices;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_accueil2Controller implements Initializable {

    
    @FXML
    private GridPane grid;
    
    private List<Formation> formations = new ArrayList<>();
    @FXML
    private ScrollPane scrol;
    @FXML
    private Button rechercher;
    @FXML
    private TextField search;
    
    FormationServices fs = new FormationServices();
    @FXML
    private VBox vbox;
    @FXML
    private Button quitter;
    @FXML
    private Button mostliked;
    @FXML
    private Button retour1;

   private List<Formation> getData() {
    List<Formation> formations = new ArrayList<>();
    FormationServices formationServices = new FormationServices();
    List<Formation> allFormations = formationServices.afficher();
    for (Formation formation : allFormations) {
        formations.add(formation);
    }
    Formation form;
    return formations;
}
    /**
     * Initializes the controller class.
     */
   private ObservableList<Node> nodesList;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        formations.addAll(getData());
        int column =0;
        int row=1;
        try {
            for(int i=0;i<formations.size();i++){
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("item.fxml"));
            AnchorPane anchorpane = fxmlloader.load();
            ItemController itemController = fxmlloader.getController();
            itemController.setData(formations.get(i));
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
            Logger.getLogger(Formation_accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
           //ex.printStackTrace();
        }
        nodesList = FXCollections.observableArrayList(grid.getChildren());
    }    



    @FXML
    private void rechercher(ActionEvent event) {
        String searchTerm = search.getText();
        Formation Formationrecherche = fs.readByName(searchTerm);
    
    vbox.getChildren().clear();
    if (Formationrecherche != null) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/item.fxml"));
            AnchorPane abc = fxmlLoader.load();
            ItemController itemcontroller = fxmlLoader.getController();
            itemcontroller.setData(Formationrecherche);
            vbox.getChildren().add(abc);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Formation_accueil2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        Label noResultsLabel = new Label("Aucune formation trouvée");
        vbox.getChildren().add(noResultsLabel);
    }
    }

    @FXML
    private void quitter(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMINHOMEENTR.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void retour(ActionEvent event) throws IOException {
        // Charger l'interface suivante à partir de son fichier FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Participation_accueil2.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();
    }

    @FXML
    private void mostliked(ActionEvent event) throws IOException {
         
    ObservableList<Formation> mostLikedFormations = fs.getMostLikedEvents();
    vbox.getChildren().clear();
    for (Formation form : mostLikedFormations) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/item.fxml"));
        AnchorPane formationCard = fxmlLoader.load();
    ItemController formationCardController = fxmlLoader.getController();
    formationCardController.setData(form);
    vbox.getChildren().add(formationCard);
          
    }
    }

    
}
