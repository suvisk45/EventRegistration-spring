package bookmanagement.eventregistration.Service;


import bookmanagement.eventregistration.configurations.JwtUtil;
import bookmanagement.eventregistration.execption.UserNotFoundExecption;
import bookmanagement.eventregistration.model.SigninModel;
import bookmanagement.eventregistration.model.UserModel;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    AuthenticationManager  authenticationManager;

    public String AuthenticateUser(SigninModel signinModel) {

        Authentication auth = authenticationManager.
                authenticate
                        (new UsernamePasswordAuthenticationToken
                                (signinModel.getEmail(), signinModel.getPassword()));
        System.out.println("Username: " + auth.getPrincipal());

        if (auth.isAuthenticated()) {
            return jwtUtil.generateToken((UserDetails) (auth.getPrincipal()));
        }
        return "Invalid username or password";
    }

}
