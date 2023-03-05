/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Equipe;
import Services.ServiceEquipe;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DetailsENequipeController implements Initializable {
    @FXML
    private ImageView AnisHouriLin;
    @FXML
    private Label Nom_de_EquipeEN;
    @FXML
    private Label Membre_equipeEN;
    @FXML
    private Label Description_EquipeEN;
    @FXML
    private Button RetourrrrEN;
    @FXML
    private Label iddetailsEquipeEN;
    @FXML
    private Button lienanisEN;
    @FXML
    private Button lienkhadijaEN;
    @FXML
    private Button lienafifEN;
    @FXML
    private Button lienDorraEN;
    
        ServiceEquipe sp = new ServiceEquipe();

    @FXML
    private Button lienyossraEN;
    @FXML
    private Button lienfirasEN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
        public void getdetailsE(Equipe E){

            iddetailsEquipeEN.setText(String.valueOf(E.getId_Equipe()));
            Nom_de_EquipeEN.setText(E.getNom_Equipe());
            Membre_equipeEN.setText(E.getMembre());
            Description_EquipeEN.setText(E.getDescription());



        }

    @FXML
    private void RetourEEEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeEntrepreneur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsiteEN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite1EN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite2EN(ActionEvent event) throws URISyntaxException {
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite3EN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite4EN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite5EN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsENequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
