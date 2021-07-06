package com.example.BackendAPI.controller;

import com.example.BackendAPI.service.AppService;
import com.twilio.exception.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class AppController {

    @Autowired
    AppService service;

    @Autowired
    private SimpMessagingTemplate webSocket;

    private final String  TOPIC_DESTINATION = "/topic/sms";

    // Date required in string and in this format : "03/07/2012 11:49:00 AM"
    // mobile number are required with country code
    @RequestMapping(value = "/sms", method = RequestMethod.POST)
    public String smsSubmit(@RequestParam("toMobileNumber")String toMobileNumber,
                            @RequestParam("message")String message,
                            @RequestParam("date")String dateString,
                            @RequestParam("event_id")String eventId) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
            Date date = new Date();
            try {
                date = dateFormat.parse(dateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            service.saveEvent(eventId,toMobileNumber,message,date);
        }
        catch(ApiException e){
            System.out.println(e);
        }
        webSocket.convertAndSend(TOPIC_DESTINATION, getTimeStamp() + ": SMS has been sent!: ");
        return "Successfully added event, It will be send on time.";
    }


    @RequestMapping(value = "/deleteEvent", method = RequestMethod.DELETE)
    private String deleteEvent(@RequestParam("eventId")String eventId){
        if(service.removeEvent(eventId)){
            return "Successfully deleted the event";
        }else{
            return "Error occurred ! please try again";
        }
    }

    private String getTimeStamp() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(LocalDateTime.now());
    }
}
