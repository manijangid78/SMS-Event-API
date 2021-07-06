package com.example.BackendAPI.service;

import com.example.BackendAPI.entity.Contact;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.TimerTask;

@Component
public class IntervalProcess extends TimerTask {

    private AppService service;

    public IntervalProcess(AppService service) {
        this.service = service;
    }

    @Override
    public void run() {
        Date date = new Date();
        List<Contact> contacts = service.getAllContacts();

        for (Contact contact:contacts) {
            Date msgTime = contact.getDate();
            if(msgTime.getMonth()==date.getMonth()
                    && msgTime.getYear() == date.getYear()
                    && msgTime.getDay() == date.getDay()
                    && msgTime.getHours() == date.getHours()
                    && msgTime.getMinutes() == date.getMinutes()){
                System.out.println(contact.toString());
                service.send(contact.getMobileNumber(),contact.getSenderMobileNumber(),contact.getMessage(),contact.getDate());
                service.removeEvent(contact.getEventId());
            }
        }
    }
}
