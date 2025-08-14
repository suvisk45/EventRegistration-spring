package bookmanagement.eventregistration.Controller;


import bookmanagement.eventregistration.Service.AdminService;
import bookmanagement.eventregistration.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("admin")
public class AdminController
{
    @Autowired
    AdminService  adminService;
    @PostMapping("/uploadEvent")
    public ResponseEntity uploadEvent(
        @RequestParam("eventTitle") String eventTitle,
        @RequestParam("eventDescription") String eventDescription,
        @RequestParam("eventDate") String eventDate,
        @RequestParam("eventTime") String eventTime,
        @RequestParam("eventLocation") String eventLocation,
        @RequestParam("eventType") String eventType,
        @RequestParam("eventCapacity") int eventCapacity,
        @RequestParam("eventImage") MultipartFile eventImage
){
    EventModel eventModel = new EventModel();
    eventModel.setTitle(eventTitle);
    eventModel.setDescription(eventDescription);
    eventModel.setDateTime(eventTime);
    eventModel.setLocation(eventLocation);
    eventModel.setEventType(eventType);
    eventModel.setDateTime(eventDate);
    eventModel.setMaxParticipants(eventCapacity);
   try{
       eventModel.setImageData(eventImage.getBytes());
   }catch(IOException e){
       System.out.println(e.getMessage());
   }
    adminService.addEvents(eventModel);
   try
   {
       eventModel.setImageData(eventImage.getBytes());
   }catch (IOException e)
   {
       System.out.println(e.getMessage());
   }

    return ResponseEntity.status(HttpStatus.CREATED).body("event uploaded successfully");
}

}
