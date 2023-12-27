package com.sms.controller;
import com.sms.controller.payload.SmsRequest;
import com.sms.service.TwilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/sms")
public class SmsController {

    private final TwilioService twilioService;

    @Autowired
    public SmsController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    //http://localhost:8080/api/sms/send
    @PostMapping("/send")
    public String sendSms(@RequestBody SmsRequest smsRequest) {
        try {
            // Assuming SmsRequest has 'to' and 'message' properties
            twilioService.sendSms(smsRequest.getTo(), smsRequest.getMessage());
            return "SMS sent successfully!";
        } catch (Exception e) {
            return "Error sending SMS: " + e.getMessage();
        }
    }
}
