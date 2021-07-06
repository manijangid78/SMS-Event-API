package com.example.BackendAPI.service;

import com.example.BackendAPI.entity.Contact;
import com.example.BackendAPI.repository.ContactRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AppService {

    @Autowired
    private ContactRepository contactRepository;

    @Value("${TWILIO_ACCOUNT_SID}")
    private String ACCOUNT_SID;
//
    @Value("${TWILIO_AUTH_TOKEN}")
    private String AUTH_TOKEN;

    @Value("${SENDER_MOBILE_NUMBER}")
    private String SENDER_MOBILE_NUMBER;

    public void saveEvent(String eventId,String toMobileNumber, String message, Date date){
        Contact contact = new Contact(eventId,SENDER_MOBILE_NUMBER,toMobileNumber,message,date);
        contactRepository.save(contact);
    }

    public void send(String fromMobileNumber,String toMobileNumber, String message, Date date) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message msg = Message.creator(new PhoneNumber("+"+toMobileNumber), new PhoneNumber("+12162086475"), message)
                .create();
        System.out.println("here is my id:"+msg.getSid());// Unique resource ID created to manage this transaction
    }

    public List<Contact> getAllContacts(){
        return contactRepository.findAll();
    }

    public boolean removeEvent(String eventId){
        try{
            contactRepository.deleteByEventId(eventId);
            return true;
        }catch (Exception e){
            System.out.println("Hello");
            System.out.println(e);
            return false;
        }
    }
}