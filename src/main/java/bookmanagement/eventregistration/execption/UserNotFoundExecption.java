package bookmanagement.eventregistration.execption;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(code= HttpStatus.NOT_FOUND)
public class UserNotFoundExecption extends RuntimeException
{

                     public UserNotFoundExecption()
                     {
                         super();
                     }
                     public UserNotFoundExecption(String message)
                     {
                         super(message);
                     }
}

