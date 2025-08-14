package bookmanagement.eventregistration.Controller;


import bookmanagement.eventregistration.Service.UserDServices;
import bookmanagement.eventregistration.Service.UserServices;
import bookmanagement.eventregistration.model.SigninModel;
import bookmanagement.eventregistration.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
@CrossOrigin(origins = "*")
public class SiginController {

    @Autowired
    private UserServices userServices;

    @PostMapping("/signin")
    public ResponseEntity<?> checkuser(@RequestBody SigninModel signinModel) {
        try {
            String str = userServices.AuthenticateUser(signinModel);
            return ResponseEntity.ok(str); // Login success
        }
        catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("User not found");
        }
        catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong");
        }
    }
}
