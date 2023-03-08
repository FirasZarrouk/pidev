/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.File;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.SessionManager;
import model.User;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Ghass
 */
public class EntrepriseController implements Initializable {

    @FXML
    private Label labelnom;
    @FXML
    private ImageView image;
    @FXML
    private Label mail;
    private Button bouttom_pack;
    @FXML
    private Button facture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        UserService sa = new  UserService();
        User f = (User)sa.readById(SessionManager.getInstance().getCurrentUser().getId());
        labelnom.setText( "     "+f.getNom());
        mail.setText(f.getEmail());
        
        
        
        
        if (f.getImg() != null)
        {
        File imagef = new File(f.getImg());
        Image imagee = new Image(imagef.toURI().toString());
        image.setImage(imagee);
        }
    }    

    @FXML
    private void deco(ActionEvent event) {
        SessionManager.getInstance().setCurrentUser(null);
         try {

            Parent page1 = FXMLLoader.load(getClass().getResource("SeConnecter.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

        } catch (IOException ex) {

           System.out.println(ex.getMessage());

        }
    }

    @FXML
    private void modif(ActionEvent event) throws IOException {
        Parent page1 = FXMLLoader.load(getClass().getResource("ModifUserFront.fxml"));

            Scene scene = new Scene(page1);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

            stage.setScene(scene);

            stage.show();

         
        
    }

    private void bouttom_pack(ActionEvent event) throws IOException {
               // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User_Pack.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) bouttom_pack.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void facture(ActionEvent event) throws IOException {
                 // Charger l'interface suivante à partir de son fichier FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu_User.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) facture.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
