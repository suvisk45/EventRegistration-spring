package bookmanagement.eventregistration.execption;

public class EventNotFoundException extends RuntimeException{

    public EventNotFoundException(String message)
    {
        super(message);
    }
    public EventNotFoundException()
    {

    }

}
