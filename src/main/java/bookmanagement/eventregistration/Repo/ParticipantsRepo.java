package bookmanagement.eventregistration.Repo;

import bookmanagement.eventregistration.model.EventModel;
import bookmanagement.eventregistration.model.Participants;
import bookmanagement.eventregistration.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ParticipantsRepo extends JpaRepository<Participants, Integer>
{
    @Query("SELECT p FROM Participants p WHERE p.user.id = :userId AND p.event.id = :eventId")
    Optional<Participants> findByUserIdAndEventId(@Param("userId") Long userId, @Param("eventId") Long eventId);


    EventModel event(EventModel event);
}
