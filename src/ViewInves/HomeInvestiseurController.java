/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInves;

import GUI.AceuilProjetController;
import Model.Projet;
import Services.ServiceProjet;
import View.ItemsEntrepreneurProjetController;
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
public class HomeInvestiseurController implements Initializable {

    @FXML
    private AnchorPane scenePaneeeEN;
    private Pane paneProjetEN;
    @FXML
    private Button btnEquipeIN;
    @FXML
    private Button btnProjetIN;
    @FXML
    private Button btnStatIN;
    @FXML
    private Button rechercherProjetIN;
    @FXML
    private TextField rechercheIN;
    @FXML
    private Button QuitterProjetIN;
    
    ServiceProjet serviceprojet = new ServiceProjet();
    ArrayList<Projet> Projet = new ArrayList<>();
    @FXML
    private VBox ScenepaneeIN;
    @FXML
    private Pane PaneStatisIN;
    @FXML
    private Pane paneEquipeIN;
    @FXML
    private Pane paneProjetIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceProjet serviceprojet = new ServiceProjet();
        Projet.addAll(serviceprojet.afficher());
        // TODO
       ScenepaneeIN.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Projet.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemsInvestiProjet.fxml"));
                AnchorPane abcddd = fxmlLoader.load();
                ItemsInvestiProjetController itemcontroller = fxmlLoader.getController();
                itemcontroller.getProjet(Projet.get(i));
                
                
                
                
                    ScenepaneeIN.getChildren().add(abcddd);
                } catch (IOException ex) {
                    Logger.getLogger(AceuilProjetController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
           
        }
    }    


    @FXML
    private void RechercheProjetEN(ActionEvent event) {
        
        String searchTerm = rechercheIN.getText();
    Projet Projetrecherche = serviceprojet.readByName(searchTerm);
    
    ScenepaneeIN.getChildren().clear();
    
    if (Projetrecherche != null) {
        
            
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemsInvestiProjet.fxml"));
                AnchorPane abcdee = fxmlLoader.load();
                ItemsInvestiProjetController itemcontroller = fxmlLoader.getController();
                itemcontroller.getProjet(Projetrecherche);
                ScenepaneeIN.getChildren().add(abcdee);
            } catch (IOException ex) {
                Logger.getLogger(HomeInvestiseurController.class.getName()).log(Level.SEVERE, null, ex);
            } 
    }else {
        Label noResultsLabel = new Label("Aucun projet trouvé");
        ScenepaneeIN.getChildren().add(noResultsLabel);
    
    }
    
    }

    @FXML
    private void GetEquipeIN(ActionEvent event) {
        
        try {
            Pane paneEquipeIN = FXMLLoader.load(getClass().getResource("AceuilEquipeInvesti.fxml"));
            paneProjetIN.getChildren().clear();
            paneProjetIN.getChildren().setAll(paneEquipeIN);
        } catch (IOException ex) {
            Logger.getLogger(HomeInvestiseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GetProjetIN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeInvestiseur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(HomeInvestiseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void GetStatistiqueIN(ActionEvent event) {
        
        try {
            Pane PaneStat= FXMLLoader.load(getClass().getResource("../GUI/Stat.fxml"));
            paneProjetIN.getChildren().clear();
            paneProjetIN.getChildren().setAll(PaneStat);
        } catch (IOException ex) {
            Logger.getLogger(HomeInvestiseurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     Stage stage;
    @FXML
    private void QuitterProjetIN(ActionEvent event) {
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Quitter");
        alert.setHeaderText("Vous êtes sur de quitter!");
        
        
        if(alert.showAndWait().get()== ButtonType.OK){
        stage = (Stage) scenePaneeeEN.getScene().getWindow();
        System.out.println("Quitter avec succès");
        stage.close();
    }
    }
    
}
