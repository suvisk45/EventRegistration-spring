package bookmanagement.eventregistration.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfirmDeploy {


    @GetMapping("/")
    public String Confirm()
    {
        return " sucessfully deployed";
    }
}
