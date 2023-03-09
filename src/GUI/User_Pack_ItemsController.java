/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Interfaces.Interface_IService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import Model.Pack;
import Util.MaConnection;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.Rating;
import services.servicePack;

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
    @FXML
    private Rating Rating;

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
        
         
       FXMLLoader loader = new FXMLLoader(getClass().getResource("payeeerrkhadija.fxml"));
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
//    MaConnection cnx = new MaConnection();
//    
//    public ObservableList<String> afficherNameAndStars() throws SQLException {
//        //  List<Feedback> res = new ArrayList<>();
//        ObservableList<String> listItems = FXCollections.observableArrayList();
//        String req = "SELECT u.email, SUM(f.stars) as total_stars FROM users u JOIN feedbacks f ON u.id_user = f.id_freelancer GROUP BY u.id_user ORDER BY total_stars DESC LIMIT 5;";
//        PreparedStatement ps = cnx.prepareStatement(req);
//
//        ResultSet res_query = ps.executeQuery(req);
//        while (res_query.next()) {
//            String nom = res_query.getString(1);
//            Double str = res_query.getDouble(2);
//            listItems.add(nom + "   Total :" + str);
//        }
//        return listItems;
//    }
    
}
