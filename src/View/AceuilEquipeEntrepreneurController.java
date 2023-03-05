/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.AceuilEquipeController;
import GUI.ItemsEquipeController;
import Model.Equipe;
import Services.ServiceEquipe;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AceuilEquipeEntrepreneurController implements Initializable {

    @FXML
    private AnchorPane AnchorPaneEquipe;
    @FXML
    private Label aceuilEquipes;
    @FXML
    private VBox scenepaneeeEN;
    
    ServiceEquipe serviceEquipe = new ServiceEquipe();
    ArrayList<Equipe> Equipe = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceEquipe serviceEquipe = new ServiceEquipe();
        Equipe.addAll(serviceEquipe.afficher());
        // TODO
       scenepaneeeEN.getChildren().clear();
       
        
        Node [] nodes = new  Node[15];
        
        
        
        for(int i = 0; i<Equipe.size() ; i++)
        {
             
                try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("ItemsEntrepreneurEquipe.fxml"));
                AnchorPane abcdd = fxmlLoader.load();
                ItemsEntrepreneurEquipeController itemcontroller = fxmlLoader.getController();
                itemcontroller.getEquipe(Equipe.get(i));
                
                    scenepaneeeEN.getChildren().add(abcdd);
                } catch (IOException ex) {
                    Logger.getLogger(AceuilEquipeEntrepreneurController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
             
           
        }
    }    

    
}
