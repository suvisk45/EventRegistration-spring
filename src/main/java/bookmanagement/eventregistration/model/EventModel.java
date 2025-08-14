package bookmanagement.eventregistration.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@Entity
@Table(name = "events")
public class EventModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String dateTime;
    private String location;
    private int maxParticipants;
    private String eventType;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] imageData;

    @ToString.Exclude
    @JsonBackReference
    @ManyToMany(mappedBy = "registeredEvents")
    private List<UserModel> registeredUsers;
}
