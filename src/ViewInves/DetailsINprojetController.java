/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInves;

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
public class DetailsINprojetController implements Initializable {
    
    @FXML
    private Label Nom_de_projetIN;
    @FXML
    private Label CategoriedIN;
    @FXML
    private Label TechnologiedIN;
    @FXML
    private Label Tache_projetdIN;
    @FXML
    private Label DescriptionIN;
    @FXML
    private Button RetourIN;
    ServiceProjet serviceProjet=new ServiceProjet();
    @FXML
    private Label iddetailsIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void getdetails(Projet P){
        
        
        iddetailsIN.setText(String.valueOf(P.getId_Projet()));
        Nom_de_projetIN.setText(P.getNom_Projet());
        CategoriedIN.setText(P.getCategorie());
        TechnologiedIN.setText(P.getTechnologie());
        Tache_projetdIN.setText(P.getTache_de_projet());
        DescriptionIN.setText(P.getDescription());
        
    }

    @FXML
    private void RetourPP(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeInvestiseur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsINprojetController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
