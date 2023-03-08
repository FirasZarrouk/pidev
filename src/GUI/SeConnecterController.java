/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.SessionManager;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class SeConnecterController implements Initializable {

    @FXML
    private TextField email3;
    @FXML
    private TextField password3;
    @FXML
    private Button log;
    @FXML
    private Button inscription2;
    @FXML
    private Button RetourrAuAccueil3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {
        String page = ""; 
        String email = email3.getText();
        String password = password3.getText();
        int id = -1;
        UserService sa = new UserService();
        Alert alert = new Alert(Alert.AlertType.NONE);
        SessionManager sessionManager = SessionManager.getInstance();
        id = sa.authentification(email, password);
        String role = "";
        
        if (id == -1)
        {
              alert.setAlertType(Alert.AlertType.WARNING);
                alert.setContentText(" erroné ! ");
                alert.show();
        }
        else {
            sessionManager.setCurrentUser(sa.readById(id));
            role = sa.readById(id).getRole();
            switch (role) {
            case "Admin":
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Admin connecté");
                alert.show();
                page = "Menu.fxml" ;
                break;
            case "Entrepreneur":
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Entreprise connecté");
                alert.show();
                page = "Entreprise.fxml" ;

                break;
            case "Investiseur":
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setContentText("Investisseur connecté");
                alert.show(); 
                page = "InvestiseurFXML.fxml" ;
                
                break;
        }
            try {

            Parent page1 = FXMLLoader.load(getClass().getResource(page));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
           // scene.getStylesheets().add("https://cdn.jsdelivr.net/openjfx/8u40-b25/rt/styles/modena/modena.css");

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
        
    }
    }

    @FXML
    private void inscrip2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterUser.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) inscription2.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void RetourrAuAccueil3(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetourrAuAccueil3.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void forgetpass(ActionEvent event) {
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }
    }
    
    

