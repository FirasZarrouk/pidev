/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.User;
import service.UserService;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class AccueilController implements Initializable {

        UserService us =  new UserService();
    @FXML
    private ListView<User> afficher;
    @FXML
    private Button AfficherUser;
    @FXML
    private Button ModifierUser;
    @FXML
    private Button LogIn;
    @FXML
    private Button RetourAuMenuUser;
    @FXML
    private TextField rech;
    
    int id_userr;
    @FXML
    private Button bfgbfg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AfficherUser(ActionEvent event) {
         ObservableList<User> Users =FXCollections.observableArrayList(us.afficher());
       afficher.setItems(Users);
    }

    @FXML
    private void ModifierUser(ActionEvent event) throws IOException {
        
        
        
       User selectedUser=afficher.getSelectionModel().getSelectedItem();
            
            
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
             Parent view_2=loader.load();
            ModifierUserController ModifierUserController=loader.getController();
           
            ModifierUserController.getUser(selectedUser);
             ModifierUserController.U =selectedUser;
           
            
           Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
            stage.show();
        
      
    }

    @FXML
    private void LogIn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SeConnecter.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) LogIn.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void RetourAuMenuUser(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetourAuMenuUser.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void desactiverUser(ActionEvent event) {
                // Récupérer le pack sélectionné
    User UserSelectionne = afficher.getSelectionModel().getSelectedItem();

    if (UserSelectionne != null) {
        // Appeler le service pour supprimer le pack
        us.supprimer(UserSelectionne.getId());

        // Retirer le pack de la ListView
        afficher.getItems().remove(UserSelectionne);
    }
    
}

    @FXML
    private void recherche(ActionEvent event) throws SQLException {
        
        
        ObservableList<User> Users;
            Users = FXCollections.observableArrayList(us.rechercher(rech.getText()));
       afficher.setItems(Users);
}

    @FXML
    private void bfbf(ActionEvent event) {
    }
}
