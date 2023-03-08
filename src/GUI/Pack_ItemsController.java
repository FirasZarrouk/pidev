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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
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
public class Pack_ItemsController implements Initializable {

    @FXML
    private Label IDRap;
    @FXML
    private Button BouttonSupp;
    @FXML
    private Button ModifierItems;
    @FXML
    private AnchorPane abc;
    @FXML
    private TextField CategorieText;
    @FXML
    private TextField TarifText;
    @FXML
    private TextField NomText;
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
    private void SuppItems(ActionEvent event) throws IOException {
           sp.supprimer(Integer.valueOf(IDRap.getText()));
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Pack_acceuil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
       
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BouttonSupp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void bouttonMod(ActionEvent event) throws IOException {
        
        Pack selectedPack= (Pack) sp.readById(Integer.valueOf(IDRap.getText()));
        
        
       
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Pack_modifier.fxml"));
        Parent view_2=loader.load();
        Pack_modifierController ModifierController=loader.getController();
        ModifierController.getPack(selectedPack);
        ModifierController.p=selectedPack;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
//        
//       FXMLLoader loader = new FXMLLoader(getClass().getResource("Pack_modifier.fxml"));
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//       
//        
//        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
//        Stage stage = (Stage) ModifierItems.getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
    }
    
}
