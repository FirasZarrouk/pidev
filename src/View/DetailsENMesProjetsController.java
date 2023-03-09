/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class DetailsENMesProjetsController implements Initializable {

    @FXML
    private Label Nom_de_projetEN;
    @FXML
    private Label CategoriedEN;
    @FXML
    private Label TechnologiedEN;
    @FXML
    private Label Tache_projetdEN;
    @FXML
    private Label DescriptionEN;
    @FXML
    private Button RetourEN;
    @FXML
    private Label iddetailsEN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void RetourPP(ActionEvent event) {
    }
    
}
