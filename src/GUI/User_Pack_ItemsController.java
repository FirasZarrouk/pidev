/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interface.Interface_IService;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Pack;
import service.servicePack;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class User_Pack_ItemsController implements Initializable {

    @FXML
    private AnchorPane abc;
    @FXML
    private TextField CategorieText;
    @FXML
    private TextField TarifText;
    @FXML
    private TextField NomText;
    @FXML
    private Label IDRap;
    @FXML
    private Button ResserverSupp;
        Interface_IService sp= new servicePack();
    @FXML
    private TextField RoleUText;

    /**
     * Initializes the controller class.
     */
     void getPack(Pack p){
    IDRap.setText(String.valueOf(p.getID_Pack()));
    NomText.setText(p.getNomPack());
    CategorieText.setText(p.getCategorie());
    TarifText.setText(Float.toString(p.getTarif()));
    RoleUText.setText(p.getRoleU());

  
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ResItems(ActionEvent event) throws IOException {
            Pack selectedForm =(Pack)
             sp.readById(Integer.valueOf(IDRap.getText()));
        
         
       FXMLLoader loader = new FXMLLoader(getClass().getResource("payeeerr.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
       
      PayeeerrkhadijaController ModifierForm=loader.getController();
      ModifierForm.getPack(selectedForm);
      ModifierForm.p=selectedForm;
    // Create a new stage for the new view
    Stage stage = new Stage();
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        //   Stage stage = (Stage) ResserverSupp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        
    }

    
}
