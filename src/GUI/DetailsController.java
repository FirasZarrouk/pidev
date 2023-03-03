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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DetailsController implements Initializable {

    @FXML
    private Button modifierPr;
    @FXML
    private Label Nom_de_projet;
    @FXML
    private Label Categoried;
    @FXML
    private Label Technologied;
    @FXML
    private Label Tache_projetd;
    @FXML
    private Label Description;
    
        ServiceProjet serviceProjet=new ServiceProjet();
    @FXML
    private Button Retour;
    @FXML
    private Label iddetails;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    public void getdetails(Projet P){
        
        
        iddetails.setText(String.valueOf(P.getId_Projet()));
        Nom_de_projet.setText(P.getNom_Projet());
        Categoried.setText(P.getCategorie());
        Technologied.setText(P.getTechnologie());
        Tache_projetd.setText(P.getTache_de_projet());
        Description.setText(P.getDescription());
        
    }
    
    
    
    
    

    @FXML
    private void modifier_Projet(ActionEvent event) {
        try {
            
            
            Projet selectedProjet =(Projet)
                    serviceProjet.readById(Integer.valueOf(iddetails.getText()));
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierP.fxml"));
            Parent view_2=loader.load();
            ModifierPController ModifierPController=loader.getController();
            ModifierPController.getProjet(selectedProjet);
            ModifierPController.p=selectedProjet;
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RetourPP(ActionEvent event) {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("AceuilProjet.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
}
