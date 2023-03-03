/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Projet;
import Services.ServiceProjet;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AceuilProjetController implements Initializable {

    @FXML
    private VBox Scenepanee;
    @FXML
    private Button btnProjet;
    @FXML
    private Button btnEquipe;
    @FXML
    private Pane paneEquipe;
    @FXML
    private Button AjouterProjet;
    @FXML
    private Button rechercherProjet;
    
    ServiceProjet serviceprojet = new ServiceProjet();
    ArrayList<Projet> Projet = new ArrayList<>();
    @FXML
    private TextField recherchePP;
    @FXML
    private Button btnStat;
    @FXML
    private Pane paneProjet;
    @FXML
    private Button QuitterP;
    @FXML
    private AnchorPane scenePaneee;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
        ServiceProjet serviceprojet = new ServiceProjet();
        Projet.addAll(serviceprojet.afficher());
        // TODO
       Scenepanee.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Projet.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/GUI/Items.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemsController itemcontroller = fxmlLoader.getController();
                itemcontroller.getProjet(Projet.get(i));
                
                
                
                
                    Scenepanee.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
           
        }  
        
        
             
        
    }   
    
    
    
    

    @FXML
    private void AjouterProjet(ActionEvent event) {
        
        
            try {
                FXMLLoader loader= new FXMLLoader(getClass().getResource("AjouterP.fxml"));
                Parent view_2=loader.load();
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        
    }


    @FXML
    private void RechercheProjet(ActionEvent event) {
        
    String searchTerm = recherchePP.getText();
    Projet Projetrecherche = serviceprojet.readByName(searchTerm);
    
    Scenepanee.getChildren().clear();
    if (Projetrecherche != null) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/GUI/Items.fxml"));
            AnchorPane abc = fxmlLoader.load();
            ItemsController itemcontroller = fxmlLoader.getController();
            itemcontroller.getProjet(Projetrecherche);
            Scenepanee.getChildren().add(abc);
            
            
        } catch (IOException ex) {
            Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        Label noResultsLabel = new Label("Aucun projet trouvé");
        Scenepanee.getChildren().add(noResultsLabel);
    }
    }

    @FXML
    private void GetProjet(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GetEquipe(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilEquipe.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GetStatistique(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("stat.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    Stage stage;

    @FXML
    private void QuitterP(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Vous êtes sur de quitter!");
        
        
        if(alert.showAndWait().get()== ButtonType.OK){
        stage = (Stage) scenePaneee.getScene().getWindow();
        System.out.println("Quitter avec succès");
        stage.close();
        }
        
    }

    
    
}
