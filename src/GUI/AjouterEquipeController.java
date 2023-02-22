

package GUI;

import Interfaces.Interface_IService;
import Model.Equipe;
import Services.ServiceEquipe;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MSI
 */
public class AjouterEquipeController implements Initializable {
    
    Interface_IService serviceEquipe = new ServiceEquipe() ;

    @FXML
    private TextArea txtnomEquipe;
    @FXML
    private TextArea txtTache;
    @FXML
    private TextArea txtMembre;
    @FXML
    private Button AjouterE;
    @FXML
    private ImageView imglogo;
    @FXML
    private TextArea txtDescription;
    @FXML
    private Button RetourE;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter_Equipe(ActionEvent event) {
        
        if (txtnomEquipe.getText().length() == 0||txtDescription.getText().length() == 0||txtMembre.getText().length() == 0||txtTache.getText().length() == 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please remplir tous les champs"+ "");
            alert.show();
            
        }else{
            
            try {
                Equipe E= new Equipe();
                E.setNom_Equipe(txtnomEquipe.getText());
                E.setDescription(txtDescription.getText());
                E.setMembre(txtMembre.getText());
                E.setTache(txtTache.getText());
                
                serviceEquipe.ajouter(E);
                
                
                FXMLLoader loader= new FXMLLoader(getClass().getResource("ListeEquipe.fxml"));
                Parent view_2=loader.load();
                
                Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(view_2);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                Logger.getLogger(AjouterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @FXML
    private void RetourE(ActionEvent event) {
        
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("ListeEquipe.fxml"));
            Parent view_2=loader.load();
            
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(view_2);
            stage.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(AjouterEquipeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
