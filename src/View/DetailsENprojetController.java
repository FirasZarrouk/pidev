/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import GUI.ModifierPController;
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
public class DetailsENprojetController implements Initializable {

    @FXML
    private Label Nom_de_projetEN;
    @FXML
    private Label CategoriedEN;
    @FXML
    private Label TechnologiedEN;
    @FXML
    private Label Tache_projetdEN;
    @FXML
    private Label DescriptionEN;
    @FXML
    private Button modifierPrEN;
    @FXML
    private Button RetourEN;
    @FXML
    private Label iddetailsEN;
    
    ServiceProjet serviceProjet=new ServiceProjet();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void getdetails(Projet P){
        
        
        iddetailsEN.setText(String.valueOf(P.getId_Projet()));
        Nom_de_projetEN.setText(P.getNom_Projet());
        CategoriedEN.setText(P.getCategorie());
        TechnologiedEN.setText(P.getTechnologie());
        Tache_projetdEN.setText(P.getTache_de_projet());
        DescriptionEN.setText(P.getDescription());
        
    }

    @FXML
    private void modifier_Projet(ActionEvent event) {
        
        try {
            Projet selectedProjet =(Projet)
                    serviceProjet.readById(Integer.valueOf(iddetailsEN.getText()));
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierProjetEntrep.fxml"));
            Parent view_2=loader.load();
            ModifierProjetEntrepController ModifierPController=loader.getController();
            ModifierPController.getProjet(selectedProjet);
            ModifierPController.p=selectedProjet;
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsENprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void RetourPP(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsENprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
