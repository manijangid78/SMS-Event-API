package com.example.BackendAPI.entity;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Component
public class Contact {

    @GeneratedValue
    @Id
    private int id;
    private String eventId;
    private String mobileNumber;
    private String senderMobileNumber;
    private String message;
    private Date date;

    public Contact() {}

    public Contact(String eventId,String mobileNumber, String senderMobileNumber, String message, Date date) {
        this.eventId = eventId;
        this.mobileNumber = mobileNumber;
        this.senderMobileNumber = senderMobileNumber;
        this.message = message;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getSenderMobileNumber() {
        return senderMobileNumber;
    }

    public void setSenderMobileNumber(String senderMobileNumber) {
        this.senderMobileNumber = senderMobileNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", senderMobileNumber='" + senderMobileNumber + '\'' +
                ", message='" + message + '\'' +
                ", date=" + date +
                '}';
    }
}
