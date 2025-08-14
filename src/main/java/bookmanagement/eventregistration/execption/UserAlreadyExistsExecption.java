package bookmanagement.eventregistration.execption;


public class UserAlreadyExistsExecption extends RuntimeException
{
    public UserAlreadyExistsExecption()
    {
        super();
    }
    public UserAlreadyExistsExecption(String message)
    {
        super(message);
    }
}