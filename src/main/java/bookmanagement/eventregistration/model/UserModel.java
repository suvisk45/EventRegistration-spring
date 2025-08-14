package bookmanagement.eventregistration.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    private String organizationName;

    @ToString.Exclude
    @JsonManagedReference
    @ManyToMany
    @JoinTable(
            name = "user_event_registration",        // name of join table
            joinColumns = @JoinColumn(name = "user_id"),   // foreign key for UserModel
            inverseJoinColumns = @JoinColumn(name = "event_id")  // foreign key for EventModel
    )
    private List<EventModel> registeredEvents;
}
