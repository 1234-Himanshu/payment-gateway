package com.sms.service;

import com.twilio.Twilio;
import com.twilio.exception.TwilioException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public void sendSms(String to, String message) {
        try {
            // Initialize Twilio with your credentials
            Twilio.init(accountSid, authToken);

            // Create and send SMS message
            Message.creator(
                            new PhoneNumber(to),
                            new PhoneNumber(twilioPhoneNumber),
                            message)
                    .create();

            System.out.println("SMS sent successfully!");
        } catch (TwilioException e) {
            System.err.println("Error sending SMS: " + e.getMessage());
        }
    }
}


