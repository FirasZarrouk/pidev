package services;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
    // Find your Account SID and Auth Token at twilio.com/console
    // and set the environment variables. See http://twil.io/secure
    public static final String ACCOUNT_SID = System.getenv("AC7477715e7a1eed07b7353112fa719a95");
    public static final String AUTH_TOKEN = System.getenv("64a62c8286bd49520c05213c4fcbbbb6");

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+12765829056"),
                new com.twilio.type.PhoneNumber("+21694134523"),
                "test")
            .create();

        System.out.println(message.getSid());
    }
}