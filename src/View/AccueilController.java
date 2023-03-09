/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Model.User;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class AccueilController implements Initializable {

    UserService us = new UserService();
    private ListView<User> afficher;
    @FXML
    private Button AfficherUser;
    @FXML
    private Button LogIn;
    @FXML
    private Button RetourAuMenuUser;
    private TextField rech;

    int id_userr;
    @FXML
    private ScrollPane scroll;
    @FXML
    private GridPane grid;
     private Stage primaryStage;
    private myListener1 myListener1;
    private List<User> User = new ArrayList<>();
    private List<User> UserR = new ArrayList<>();
    UserService bs = new UserService();

    /**
     * Initializes the controller class.
     */
      public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }

   

    @FXML
    private void AfficherUser(ActionEvent event) {
        User = bs.afficher();

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < User.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("usercell.fxml"));
                VBox anchorPane = fxmlLoader.load();

                UsercellController UsercellController = fxmlLoader.getController();
                UsercellController.setData(User.get(i), myListener1);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        
    }

    private void ModifierUser(ActionEvent event) throws IOException {

        User selectedUser = afficher.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
        Parent view_2 = loader.load();
        ModifierUserController ModifierUserController = loader.getController();

        ModifierUserController.getUser(selectedUser);
        ModifierUserController.U = selectedUser;

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../GUI/ADMINHOME.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) RetourAuMenuUser.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

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

    private void recherche(ActionEvent event) throws SQLException {

       UserR = bs.rechercher(rech.getText());

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < User.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("usercell.fxml"));
                VBox anchorPane = fxmlLoader.load();

                UsercellController UsercellController = fxmlLoader.getController();
                UsercellController.setData(User.get(i), myListener1);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    }
}