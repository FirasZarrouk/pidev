/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import models.Participant;
import services.participantServices;

/**
 * FXML Controller class
 *
 * @author ydorr
 */
public class ItemAfficheParticipantsController implements Initializable {

    @FXML
    private AnchorPane abc;
    @FXML
    private Label NomParticipantss;
    @FXML
    private Label PrenomP;
    @FXML
    private ImageView Imgqr;
    @FXML
    private Label RolePart;
    @FXML
    private Label NomEVv;
    @FXML
    private Label IDeven;
participantServices ps = new participantServices();
  Participant p = new Participant();
  public Participant Part ;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void getParticipant(Participant P){
        
        
           NomParticipantss.setText(P.getNom());
            //Description.setText(P.getDescription());
            PrenomP.setText(P.getPrenom());
            RolePart.setText(P.getRole());
            NomEVv.setText(P.getNom_event().getNom_ev());
            
           
            Part=P;
        
    }
}
