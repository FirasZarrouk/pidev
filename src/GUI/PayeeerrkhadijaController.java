/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.stripe.exception.StripeException;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.Pack;
import service.servicePack;
import util.API_payment;


/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class PayeeerrkhadijaController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private Button cancel;

    @FXML
    private TextField cvcfield;

    @FXML
    private TextField expmonthfield;

    @FXML
    private TextField expyearfield;

    @FXML
    private TextField namefield;

    @FXML
    private TextField numberTextfield;

    @FXML
    private Button validate;
    servicePack sp =new servicePack();
   Pack p = new Pack();
    
    @FXML
    private Label prix;
    @FXML
    private Label id;

 
      void getPack(Pack p){
          id.setText(Integer.toString(p.getID_Pack()));
          prix.setText(Float.toString(p.getTarif()));
    
}
    @FXML
    void cancelOnaction(ActionEvent event) {
    
        servicePack sp =new servicePack();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("User_Pack.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Scene scene = new Scene(root);
        Stage stage = (Stage) cancel.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        //formServ.deleteCommande(PanierController.id_panierlistview); //static value of id_panier mel classe PanierController //where status = "en attente"
        //alertDialog("You've canceled the Order");
    }


    @FXML
    void validateOnaction(ActionEvent event) {
  
        if (namefield.getText().length() == 0 ||cvcfield.getText().length() == 0||expyearfield.getText().length() == 0||expmonthfield.getText().length() == 0||numberTextfield.getText().length()==0){

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Please remplir tous les champs"+ "");
            alert.show();

        } else if (numberTextfield.getText().length()!=16) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("Card number must contain 16 digits "+ "");
            alert.show();

        } else if (expmonthfield.getText().length()!= 2 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("expiry month must contain 2 digits from 1 to 12 "+ "");
            alert.show();
        }else if ( Integer.parseInt(expmonthfield.getText()) >13 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("expiry month must be <13 "+ "");
            alert.show();
        }else if (Integer.parseInt(expmonthfield.getText()) < 0 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("expiry month must be > 0 "+ "");
            alert.show();
        } else if (expyearfield.getText().length()!= 2  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("expiry year must contain 2 digits  "+ "");
            alert.show();
        }else if ( Integer.parseInt(expyearfield.getText()) <23 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("expiry year must be >22  "+ "");
            alert.show();
        } else if (cvcfield.getText().length()!= 3 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("cvc  must contain 3 digits "+ "");
            alert.show();
        }else if ( Integer.parseInt(cvcfield.getText()) >999  ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("cvc  must be <1000 "+ "");
            alert.show();
        }else if ( Integer.parseInt(cvcfield.getText())<100 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur de saisie !");
            alert.setContentText("cvc  must be > 99 "+ "");
            alert.show();
        } else {
            //services
            servicePack sp = new servicePack();
            API_payment stp = new API_payment();
            //PanierService ps = new PanierService();


            //retrive textfields
            String cardNumber = numberTextfield.getText();
            String cvc = cvcfield.getText();
            int expMonth = Integer.parseInt(expmonthfield.getText());
            int expYear = Integer.parseInt(expyearfield.getText());
            String cardholderName = namefield.getText();

            try {
               /* if (PanierController.promocodeEtat==true) { //ken promocode activee twali montant b discount
                    stp.verifyCardAndPay(cardNumber, expMonth, expYear, cvc, String.valueOf((int) ps.totalmontantPanierWith20Discount(3) * 100), cardholderName);
                    if (Stripeapi.creditcardvalid==true) {
                        alertDialog("transaction done  !");
                        //System.out.println(PanierController.id_panierlistview);
                        //commandeService.deleteCommande(PanierController.id_panierlistview); //4
                        //lps.deleteAllFromLigne_panier(PanierController.id_panierlistview);//4
                        System.out.println(PanierController.id_panierlistview);
                        cs.updateStauts(PanierController.id_panierlistview);
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("ComfirmerCommandeView.fxml"));
                        Parent root = null;
                        try {
                            root = loader.load();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        Scene scene = new Scene(root);
                        Stage stage = (Stage) validate.getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                    }else {
                        alertDialog("transaction failed, enter a valid card number  !");
                    }
                }else {*/
                    stp.verifyCardAndPay(cardNumber, expMonth, expYear, cvc, cardholderName, String.valueOf((int) p.getTarif() * 100));
                //}
                if (API_payment.creditcardvalid==false ) {
                    alertDialog("transaction done  !");
                    //System.out.println(PanierController.id_panierlistview);
                    //commandeService.deleteCommande(PanierController.id_panierlistview); //4
                    //lps.deleteAllFromLigne_panier(PanierController.id_panierlistview);//4
                    //System.out.println(PanierController.id_panierlistview);
                    //cs.updateStauts(PanierController.id_panierlistview);
//                    FXMLLoader loader = new FXMLLoader(getClass().getResource("confirmation.fxml"));
//                    Parent root = null;
//                    try {
//                        root = loader.load();
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                    Scene scene = new Scene(root);
//                    Stage stage = (Stage) validate.getScene().getWindow();
//                    stage.setScene(scene);
//                    stage.show();
                }else {
                    alertDialog("transaction failed, enter a valid card number  !");
                }

                //PanierController.id_panierlistview=  ps.getPanierIdByIDUser(3); //lezem n7ot id bel methode hethi alkhtr valeur static mesh ywali null w twli errors



            } catch (StripeException e) {
                throw new RuntimeException(e);
            }
        }

    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    void alertDialog(String msg){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.show();
    }

   

}
