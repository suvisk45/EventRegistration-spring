package bookmanagement.eventregistration.Controller;


import bookmanagement.eventregistration.Service.EventServices;
import bookmanagement.eventregistration.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
@CrossOrigin(origins = "*")
public class EventController {
    @Autowired
    EventServices  eventServices;

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/loadAllEvent")
    public List<EventModel> loadAllEvent()
    {
        return eventServices.allEvent();
    }
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/registerUser/{eventId}")
    public ResponseEntity registerEvent(@PathVariable Long eventId)
    {
       Authentication auth= SecurityContextHolder.getContext().getAuthentication();
       System.out.println(auth.getPrincipal());
       eventServices.registerUserToEvent((String)auth.getPrincipal(),eventId);
        return ResponseEntity.ok().body("success");
    }
}
