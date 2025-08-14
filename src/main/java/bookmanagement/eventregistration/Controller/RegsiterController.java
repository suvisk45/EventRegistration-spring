package bookmanagement.eventregistration.Controller;


import bookmanagement.eventregistration.Service.RegisterService;
import bookmanagement.eventregistration.model.EventModel;
import bookmanagement.eventregistration.model.Register;
import bookmanagement.eventregistration.model.RegisterModel;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("auth")
public class RegsiterController {
    @Autowired
    RegisterService  registerService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody Register register) throws MessagingException {
        String str = registerService.registerUser(register);
        if (str != null) return ResponseEntity.status(HttpStatus.CREATED).body(str);
        return ResponseEntity.ok().body("User has already registered");
    }

}
