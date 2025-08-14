package bookmanagement.eventregistration.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {

    private String message;
    private HttpStatus status;
    private String error;
    private String classType;
}
