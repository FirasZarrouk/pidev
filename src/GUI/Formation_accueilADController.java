/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.ItemADMINController;
import View.Formation_accueil2Controller;
import View.ItemController;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
import javafx.scene.Parent;
import services.FormationServices;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Formation_accueilADController implements Initializable {

    @FXML
    private ScrollPane scrol;
    @FXML
    private GridPane grid;
    @FXML
    private Button ajouter;
    
    private List<Formation> formations = new ArrayList<>();
    FormationServices fs = new FormationServices();
    @FXML
    private TextField search;
    @FXML
    private Button rechercher;
    @FXML
    private VBox vbox;
    @FXML
    private Button quitter;

    /**
     * Initializes the controller class.
     */
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        formations.addAll(getData());
        int column =0;
        int row=1;
        try {
            for(int i=0;i<formations.size();i++){
        FXMLLoader fxmlloader = new FXMLLoader();
        fxmlloader.setLocation(getClass().getResource("itemADMIN.fxml"));
            AnchorPane anchorpane = fxmlloader.load();
            ItemADMINController itemController = fxmlloader.getController();
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
            Logger.getLogger(Formation_accueilADController.class.getName()).log(Level.SEVERE, null, ex);
           //ex.printStackTrace();
        }
    }    

    @FXML
    private void ajouter(ActionEvent event) throws IOException {
           // Charger l'interface suivante à partir de son fichier FXML
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Formation_ajouter.fxml"));

    // Create a new stage for the new view
    Stage stage = new Stage();
    stage.setScene(new Scene(loader.load()));

    // Show the new stage and hide the current stage
    stage.show();
    Stage currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
    currentStage.hide();

    }



    @FXML
    private void rechercher(ActionEvent event) {
         String searchTerm = search.getText();
        Formation Formationrecherche = fs.readByName(searchTerm);
    
    vbox.getChildren().clear();
    if (Formationrecherche != null) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("itemADMIN.fxml"));
            AnchorPane abc = fxmlLoader.load();
            ItemADMINController itemcontroller = fxmlLoader.getController();
            itemcontroller.setData(Formationrecherche);
            vbox.getChildren().add(abc);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Formation_accueilADController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
       /* Label noResultsLabel = new Label("Aucun projet trouvé");
        vbox.getChildren().add(noResultsLabel);*/
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Formation_accueilAD.fxml"));
        try {
            VBox vboxAccueil = fxmlLoader.load();
            vbox.getChildren().add(vboxAccueil);
        } catch (IOException ex) {
            Logger.getLogger(Formation_accueilADController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }

    @FXML
    private void quitter(ActionEvent event) throws IOException {
            // Récupérer le stage actuel et le fermer
    
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMINHOME.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) quitter.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }


    
}