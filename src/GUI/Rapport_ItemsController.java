/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import Model.rapport_financier;
import Model.transaction;
import services.servicerapportfinancier;

/**
 * FXML Controller class
 *
 * @author LENOVO
 */
public class Rapport_ItemsController implements Initializable {

  
    @FXML
    private Button BouttonSupp;
    @FXML
    private Button ModifierItems;
    @FXML
    private AnchorPane abc;
    @FXML
    private DatePicker DateRapp;
    @FXML
    private TextField RevenusRapp;
    @FXML
    private TextField DepenseRapp;
    
    Interface_IService sr= new servicerapportfinancier();
    @FXML
    private Label IDRap;
    @FXML
    private TextField typeRapChoice;
    @FXML
    private TextField ResultatText;
    @FXML
    private TextField TaxesText;
    @FXML
    private DatePicker date_debut_T_text;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        typeRapChoiceBox.getItems().add("Bilan annuel");
//     typeRapChoiceBox.getItems().add("Bilan mensuel");
        // TODO
    }    
    void getRapport(rapport_financier r){
         
    IDRap.setText(String.valueOf(r.getID_rap()));
    DateRapp.setValue(r.getDate_rap().toLocalDate());
    //typeRapChoiceBox.setValue(r.getType_rap());
    typeRapChoice.setText(r.getType_rap());
    RevenusRapp.setText(Float.toString(r.getRevenus()));
    DepenseRapp.setText(Float.toString(r.getDepences()));
    ResultatText.setText(Float.toString(r.getResultat()));
    TaxesText.setText(Float.toString(r.getTaxes()));
    date_debut_T_text.setValue(r.getDate_debut_T().toLocalDate());
   //  IDtransRapText111.setText(Integer.toString(r.getTransaction().getID_trans()));


    
  }
    

    @FXML
    private void SuppItems(ActionEvent event) throws IOException {
 
       sr.supprimer(Integer.valueOf(IDRap.getText()));
       FXMLLoader loader = new FXMLLoader(getClass().getResource("Rapport_accueil.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
       
        
        // Récupérer le stage actuel et changer sa scène pour la nouvelle interface
        Stage stage = (Stage) BouttonSupp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    private void bouttonMod(ActionEvent event) throws IOException {
         
   
        rapport_financier selectedRapport=(rapport_financier)
                sr.readById(Integer.valueOf(IDRap.getText()));
        
        
       
        FXMLLoader loader= new FXMLLoader(getClass().getResource("Rapport_modifier.fxml"));
        Parent view_2=loader.load();
        Rapport_modifierController ModifierController=loader.getController();
        ModifierController.getRapport(selectedRapport);
        ModifierController.r=selectedRapport;
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(view_2);
        stage.setScene(scene);
        stage.show();
    
       
    }
    
    
}
