package bookmanagement.eventregistration.Service;


import bookmanagement.eventregistration.Repo.RegisterRepo;
import bookmanagement.eventregistration.Repo.UserRepo;
import bookmanagement.eventregistration.execption.UserAlreadyExistsExecption;
import bookmanagement.eventregistration.execption.UserNotFoundExecption;
import bookmanagement.eventregistration.model.Register;
import bookmanagement.eventregistration.model.UserModel;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Random;

@Service
public class RegisterService {

    @Autowired
    RegisterRepo registerRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    RegsiterEmailConfirm regsiterEmailConfirm;
    @Autowired
    PasswordEncoder  passwordEncoder;

    public String registerUser(Register register) throws MessagingException {
        if(userRepo.findByEmail(register.getEmail())!=null){
            throw new UserAlreadyExistsExecption("Email Already Exists");
        }
        String hashedPassword = passwordEncoder.encode(register.getPassword());
        UserModel user=UserModel.builder().id(register.getId()).email(register.getEmail()).
                role("ROLE_USER").password(hashedPassword)
                .organizationName(register.getOrganization()).build();
       UserModel user1= registerRepo.findByEmail(register.getEmail());
          UserModel u = registerRepo.save(user);
         String mailmessage= regsiterEmailConfirm.sendMail(register.getEmail());
         System.out.println(mailmessage);
          return u.getEmail() + " is registered successfully";
    }


}
