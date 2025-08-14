package bookmanagement.eventregistration.execption;

public class DatabaseNotSaveExecption extends RuntimeException {
    public DatabaseNotSaveExecption() {
        super();
    }
    public DatabaseNotSaveExecption(String message)
    {
        super(message);
    }
}
