package bookmanagement.eventregistration.execption;




public class EventAlreadyRegsitered extends RuntimeException
{
    public  EventAlreadyRegsitered(String message)
    {
        super(message);
    }
    public EventAlreadyRegsitered()
    {

    }
}
