package bookmanagement.eventregistration.execption;


import bookmanagement.eventregistration.Repo.EventRepo;
import bookmanagement.eventregistration.model.ErrorModel;
import bookmanagement.eventregistration.model.UserModel;
import org.springframework.boot.autoconfigure.batch.BatchTaskExecutor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ExecptionHandler {

    @ExceptionHandler(UserNotFoundExecption.class)
    public ResponseEntity<ErrorModel> handleError(UserNotFoundExecption e)
    {
        return new  ResponseEntity<ErrorModel>(
                new ErrorModel(e.getMessage(), HttpStatus.BAD_REQUEST,"invalid user or password",
                        "UserModel"),HttpStatus.BAD_REQUEST
        );
    }
    @ExceptionHandler(UserAlreadyExistsExecption.class)
    public ResponseEntity<ErrorModel> handleException(UserAlreadyExistsExecption e)
    {
        return new ResponseEntity<ErrorModel>(
                new ErrorModel
                        (e.getMessage(),HttpStatus.CONFLICT,
                                "User already found", "Errormodel"),HttpStatus.CONFLICT
                );
    }
   @ExceptionHandler(DatabaseNotSaveExecption.class)
   public ResponseEntity<ErrorModel> handleException(Exception e)
   {
        return new ResponseEntity<ErrorModel>(new ErrorModel(
                e.getMessage(),HttpStatus.BAD_REQUEST,"enter all valid input","ErrorModel"
        ), HttpStatus.BAD_REQUEST);
   }
   @ExceptionHandler(EventAlreadyRegsitered.class)
   public ResponseEntity<ErrorModel> handle(EventAlreadyRegsitered e)
   {
       return new ResponseEntity<ErrorModel>(new ErrorModel(e.getMessage(),HttpStatus.BAD_REQUEST,"enter all valid input","ErrorModel"),HttpStatus.BAD_REQUEST);
   }
   @ExceptionHandler(RuntimeException.class)
   public ResponseEntity<ErrorModel> handleRunTimeException(RuntimeException e)
   {
       return new ResponseEntity<ErrorModel>(new ErrorModel(e.getMessage(),HttpStatus.BAD_REQUEST,"enter all valid input","ErrorModel"),HttpStatus.BAD_REQUEST);
   }





}

