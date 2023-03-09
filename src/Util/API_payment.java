/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class API_payment {
   public static boolean creditcardvalid;
    public boolean verifyCardAndPay(String cardNumber, int expMonth, int expYear, String cvc , String cardholderName ,String montant ) throws StripeException {

      

            Stripe.apiKey = "sk_test_51Mj5WoGPqV60zhBVDXkxyyCnA1pGIhsCbRuzqmFajhGfHDNamPfUHyrUNnu7HWhT7LNy2sd8oejYlT8oezwEDZ2W00HyYYijpP";

            // Create a test token for a Visa card

            Map<String, Object> cardParams = new HashMap<>();
            cardParams.put("number", cardNumber);
            cardParams.put("exp_month", expMonth);
            cardParams.put("exp_year", expYear);
            cardParams.put("cvc", cvc);
            cardParams.put("name", cardholderName);
            Map<String, Object> tokenParams = new HashMap<>();
            tokenParams.put("card", cardParams);

            try {

                Token token = Token.create(tokenParams);
                // Use the test token ID to create a charge
                Map<String, Object> chargeParams = new HashMap<>();
                chargeParams.put("amount", montant); // Charge amount in cents ya3ni namel *100
                chargeParams.put("currency", "usd"); // Charge currency
                chargeParams.put("description", "Test charge");
                chargeParams.put("source", token.getId());

                Charge charge = Charge.create(chargeParams);
                System.out.println("Charge succeeded!");
                boolean creditcardvalid = true;
            } catch (StripeException e) {
                boolean creditcardvalid = false;
                System.out.println("Charge failed: " + e.getMessage());
            }
        //boolean creditcardvalid = false;
     

            return creditcardvalid;
        }
}
