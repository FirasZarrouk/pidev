/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.AceuilProjetController;
import GUI.ItemsController;
import Model.Projet;
import Model.SessionManager;
import Services.ServiceProjet;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class HomeEntrepreneurController implements Initializable {
    @FXML
    private Button rechercherProjet;
    @FXML
    private AnchorPane scenePaneeeEN;
    @FXML
    private Button btnEquipeEN;
    @FXML
    private Button btnProjetEN;
    @FXML
    private Button btnStatEN;
    @FXML
    private Pane PaneStatis;
    @FXML
    private Pane paneEquipeEN;
    @FXML
    private Pane paneProjetEN;
    @FXML
    private Button AjouterProjetEn;
    @FXML
    private TextField rechercheEN;
    @FXML
    private Button QuitterEN;
    
    ServiceProjet serviceprojet = new ServiceProjet();
    ArrayList<Projet> Projet = new ArrayList<>();
    @FXML
    private VBox ScenepaneeEN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

         ServiceProjet serviceprojet = new ServiceProjet();
        Projet.addAll(serviceprojet.afficherbyid(SessionManager.getInstance().getCurrentUser()));
        // TODO
       ScenepaneeEN.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Projet.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemsEntrepreneurProjet.fxml"));
                AnchorPane abc = fxmlLoader.load();
                ItemsEntrepreneurProjetController itemcontroller = fxmlLoader.getController();
                itemcontroller.getProjet(Projet.get(i));
                
                
                
                
                    ScenepaneeEN.getChildren().add(abc);
                } catch (IOException ex) {
                    Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
           
        }
    }    

    @FXML
    private void GetEquipeEN(ActionEvent event) {
        
         try {
            Pane paneEquipeEN = FXMLLoader.load(getClass().getResource("AceuilEquipeEntrepreneur.fxml"));
            paneProjetEN.getChildren().clear();
            paneProjetEN.getChildren().setAll(paneEquipeEN);
        } catch (IOException ex) {
            Logger.getLogger(HomeEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    @FXML
    private void GetProjetEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GetStatistiqueEN(ActionEvent event) {
        try {
            Pane PaneStat= FXMLLoader.load(getClass().getResource("../GUI/Stat.fxml"));
            paneProjetEN.getChildren().clear();
            paneProjetEN.getChildren().setAll(PaneStat);
        } catch (IOException ex) {
            Logger.getLogger(HomeEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
        }

       
    }

    @FXML
    private void AjouterProjetEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AjouterProjetEntrep.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(HomeEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RechercheProjetEN(ActionEvent event) {
        
        String searchTerm = rechercheEN.getText();
    Projet Projetrecherche = serviceprojet.readByName(searchTerm);
    
    ScenepaneeEN.getChildren().clear();
    
    if (Projetrecherche != null) {
        
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemsEntrepreneurProjet.fxml"));
                AnchorPane abcde = fxmlLoader.load();
                ItemsEntrepreneurProjetController itemcontroller = fxmlLoader.getController();
                itemcontroller.getProjet(Projetrecherche);
                ScenepaneeEN.getChildren().add(abcde);
            } catch (IOException ex) {
                Logger.getLogger(HomeEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
            }
            } else {
        Label noResultsLabel = new Label("Aucun projet trouvé");
        ScenepaneeEN.getChildren().add(noResultsLabel);
    
    }
    }
        Stage stage;

    @FXML
    private void QuitterEN(ActionEvent event) throws IOException {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ADMINHOMEENTR.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage)  QuitterEN.getScene().getWindow();
         // Modifier la scène de la fenêtre pour la nouvelle scène
        stage.setScene(scene);
         // Afficher la nouvelle interface
        stage.show();
        }
    
    
}
