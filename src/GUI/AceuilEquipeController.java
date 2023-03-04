/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Model.Equipe;
import Model.Projet;
import Services.ServiceEquipe;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AceuilEquipeController implements Initializable {

    @FXML
    private VBox scenepaneee;
    @FXML
    private Button AjouterEquipe;
    @FXML
    private Button rechercherEquipe;
    
    
    @FXML
    private TextField rechercheEE;
    
    ServiceEquipe serviceEquipe = new ServiceEquipe();
    ArrayList<Equipe> Equipe = new ArrayList<>();
    
    /*
    @FXML
    private Button Retourrr;
    */
    @FXML
    private Label aceuilEquipes;
    @FXML
    private AnchorPane AnchorPaneEquipe;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            
        ServiceEquipe serviceEquipe = new ServiceEquipe();
        Equipe.addAll(serviceEquipe.afficher());
        // TODO
       scenepaneee.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Equipe.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemsEquipe.fxml"));
                AnchorPane abcd = fxmlLoader.load();
                ItemsEquipeController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEquipe(Equipe.get(i));
                
                
                
                
                    scenepaneee.getChildren().add(abcd);
                } catch (IOException ex) {
                    Logger.getLogger(AceuilEquipeController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
           
        }
        
    }    

    @FXML
    private void AjouterEquipe(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AjouterEquipe.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AceuilEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void RechercheEquipe(ActionEvent event) {
        String searchTerm = rechercheEE.getText();
    Equipe Equiperecherche = serviceEquipe.readByName(searchTerm);
    
    scenepaneee.getChildren().clear();
    if (Equiperecherche != null) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ItemsEquipe.fxml"));
            AnchorPane abcd = fxmlLoader.load();
            ItemsEquipeController itemcontroller = fxmlLoader.getController();
            itemcontroller.getEquipe(Equiperecherche);
            scenepaneee.getChildren().add(abcd);
            
            
        } catch (IOException ex) {
            Logger.getLogger(AceuilEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        Label noResultsLabel = new Label("Aucun projet trouvé");
        scenepaneee.getChildren().add(noResultsLabel);
    }
    }

    
    /*
    @FXML
    private void Retourrr(ActionEvent event) {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AceuilEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
*/
        
    
    
}
