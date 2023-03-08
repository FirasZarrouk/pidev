/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.User;
import models.Wallet;
import services.UserService;
import services.WalletService;

/**
 * FXML Controller class
 *
 * @author Firas
 */
public class AjouterWalletController implements Initializable {

    @FXML
    private Button Reettouur;
    @FXML
    private ComboBox<String> MethodeDePayment;
    @FXML
    private Button AjouteerWalleet;
    @FXML
    private TextField idd;
    @FXML
    private TextField nummcarte;
    @FXML
    private DatePicker dattee;
    WalletService uw=new WalletService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        MethodeDePayment.getItems().add("Paypal");
        MethodeDePayment.getItems().add("MasterCard");
        MethodeDePayment.getItems().add("VisaCard");
        // TODO
    }    

    @FXML
    private void Reettouur(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccueilWallet.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) Reettouur.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
  
    private void AjouteerWalleet(ActionEvent event) {
        if(idd.getText().isEmpty() || nummcarte.getText().isEmpty() || MethodeDePayment.getValue().isEmpty())
        {
            Alert a = new Alert(Alert.AlertType.ERROR,"Champs vides",ButtonType.OK);
        a.showAndWait();
        }
        
        LocalDate d = dattee.getValue(); 
        Wallet w = new Wallet(Integer.parseInt(idd.getText()),Integer.parseInt(nummcarte.getText()),MethodeDePayment.getValue(),java.sql.Date.valueOf(d));
        uw.ajouter(w);
        Alert a = new Alert(Alert.AlertType.INFORMATION,"wallet ajoutée",ButtonType.OK);
        a.showAndWait();
        
        
         
    }
    
}
