/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author afifa
 */
public class NotificationController implements Initializable {

    @FXML
    private TextField numero;
    @FXML
    private TextField text;
    public static final String ACCOUNT_SID = "AC7477715e7a1eed07b7353112fa719a95";     /// 
    public static final String AUTH_TOKEN = "e3406c11de2737583182d1c3bf2b1aa4"; ///   
    public static final String TWILIO_NUMBER = "+12765829056";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void envoyernotif(ActionEvent event) {
         

    
       Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Remplacez le numéro de téléphone ci-dessous par le numéro de téléphone tunisien que vous voulez envoyer le SMS
       String phoneNumber = "+21694134523";
      
      //  Message message = Message.creator(new PhoneNumber(phoneNumber),new PhoneNumber(TWILIO_NUMBER),"garage ajouter").create();
         Message message = Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(TWILIO_NUMBER), "Garage Ajoutee avec succes").create();
        
        System.out.println(message.getSid());
    }
    }
    

