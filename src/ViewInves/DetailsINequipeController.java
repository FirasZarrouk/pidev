/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewInves;

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
public class DetailsINequipeController implements Initializable {

    @FXML
    private ImageView AnisHouriLin;
    @FXML
    private Label Nom_de_EquipeIN;
    @FXML
    private Label Membre_equipeIN;
    @FXML
    private Label Description_EquipeIN;
    @FXML
    private Button RetourrrrIN;
    @FXML
    private Button lienanisIN;
    @FXML
    private Button lienkhadijaIN;
    @FXML
    private Button lienafifIN;
    @FXML
    private Button lienDorraIN;
    @FXML
    private Button lienyossraIN;
    @FXML
    private Button lienfirasIN;
    ServiceEquipe sp = new ServiceEquipe();
    @FXML
    private Label iddetailsEquipeIN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void getdetailsE(Equipe E){
        
        iddetailsEquipeIN.setText(String.valueOf(E.getId_Equipe()));
        Nom_de_EquipeIN.setText(E.getNom_Equipe());
        Membre_equipeIN.setText(E.getMembre());
        Description_EquipeIN.setText(E.getDescription());
        
       
        
    }

    @FXML
    private void RetourEEEN(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("HomeInvestiseur.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsiteIN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite1IN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite2IN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite3IN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite4IN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openWebsite5IN(ActionEvent event) throws URISyntaxException {
        
        try {
            String url = "https://www.linkedin.com/in/mohamed-anis-houri-8952571ba/";
            Desktop.getDesktop().browse(new URI(url));
        } catch (IOException ex) {
            Logger.getLogger(DetailsINequipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
