package bookmanagement.eventregistration.Repo;


import bookmanagement.eventregistration.model.EventModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepo extends JpaRepository<EventModel,Long>
{


}
