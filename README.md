# SMS-Event-API
## SMS based event API. Sends sms to event based mobile number with a text.  
API is developed with SpringBoot and Hibernate framework. To send text messages **Twillio** is used. **Twillio** is a messaging API that helps to sends and receive the text messages. 

Here is some test using PostMan
## 1. Add New Event
In this section can be added new event. Using the postman, have to pass eventId, receiver mobile number, text message and date and time. These for requirement makes a new event. A timer is running with in 30 seconds so when time and date are match the message event will occure and event will remove from the database.
![Add Image](https://github.com/manijangid78/SMS-Event-API/blob/master/img/addEvent.PNG "Add New Event")

## 2. Remove Event
To remove the event, have to pass eventId. And using the event id, that event will be removed from the database. 
![Add Image](https://github.com/manijangid78/SMS-Event-API/blob/master/img/delete.PNG "Delete Event")

### Here is the collection of PostMan tests
Collection Link : https://www.getpostman.com/collections/645d09e0e2cdd47cb6e2
