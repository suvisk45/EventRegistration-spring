package bookmanagement.eventregistration.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Participants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UserModel user;

    @ManyToOne
    private EventModel event;

    private String registrationStatus;

    public Participants(UserModel user, EventModel eventModel, String sucess) {
        this.user=user;
        this.event=eventModel;
        this.registrationStatus=sucess;
    }
}



