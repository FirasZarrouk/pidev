/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.stripe.exception.StripeException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Model.Pack;
import services.servicePack;
import services.servicerapportfinancier;
import services.servicetransaction;
import Util.API_payment_khadija;


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
    void validateOnaction(ActionEvent event) throws FileNotFoundException, DocumentException, BadElementException, IOException {
  
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
            API_payment_khadija stp = new API_payment_khadija();
            //PanierService ps = new PanierService();


            //retrive textfields
            String cardNumber = numberTextfield.getText();
            String cvc = cvcfield.getText();
            int expMonth = Integer.parseInt(expmonthfield.getText());
            int expYear = Integer.parseInt(expyearfield.getText());
            String cardholderName = namefield.getText();

            try {
               
                    stp.verifyCardAndPay(cardNumber, expMonth, expYear, cvc, cardholderName, String.valueOf((int) p.getTarif() * 100));
                //} 
                if (API_payment_khadija.creditcardvalid==false ) {
                    alertDialog("transaction done  !");
                    

       LocalDateTime now = LocalDateTime.now();
            String date = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss"));
            String fileName = "Certificat CopyRight " + date + ".pdf";

            try {
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(fileName));
                document.open();

            // Charger l'image à partir du dossier
        String imagePath = "C:/Users/MSI/Documents/NetBeansProjects/PiProjet/src/GUI/img/logo ontej.png";
                com.itextpdf.text.Image image = com.itextpdf.text.Image.getInstance(imagePath);

                // Redimensionner l'image
                image.scaleAbsolute(100f, 100f);

                // Ajouter l'image au document
                document.add(image);
                // Ajouter un en-tête avec le nom de l'entreprise et la date actuelle

                Paragraph title = new Paragraph("CERTIFICAT COPY RIGHT\n");
                title.setAlignment(Paragraph.ALIGN_CENTER);
                document.add(title);

                Paragraph content = new Paragraph("Le présent certificat de copyright confirme que l'Organisme Tunisien des Droits d'Auteur et des Droits Voisins est le titulaire exclusif des droits d'auteur sur le projet en question. Ce certificat est un document officiel qui prouve que l'Organisme Tunisien des Droits d'Auteur et des Droits Voisins a le droit exclusif de reproduire, de distribuer et d'afficher publiquement l'œuvre protégée par le copyright. De plus, ce certificat lui permet de poursuivre toute personne qui tente d'utiliser ou de reproduire cette œuvre sans autorisation, et de recevoir des compensations pour toute utilisation illégale de l'œuvre protégée par le copyright.\n" +
"\n" +
"Ce certificat est une protection juridique importante pour les auteurs et les titulaires de droits de propriété intellectuelle, car il leur permet de protéger leur travail contre l'utilisation non autorisée ou la copie illégale. L'Organisme Tunisien des Droits d'Auteur et des Droits Voisins est donc en mesure de garantir que les droits de propriété intellectuelle de l'auteur sont respectés et que toute utilisation de l'œuvre est effectuée conformément aux termes de la licence appropriée.\n" +
"\n" +
"En bref, ce certificat de copyright est un élément crucial pour protéger les droits de propriété intellectuelle et garantir que les titulaires de droits sont en mesure de contrôler et de bénéficier de leur travail de manière juste et équitable..");
                document.add(content);

                document.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
    
        
                      


                   
                 
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
