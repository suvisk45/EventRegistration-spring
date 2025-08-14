package bookmanagement.eventregistration.Service;


import bookmanagement.eventregistration.Repo.EventRepo;
import bookmanagement.eventregistration.Repo.ParticipantsRepo;
import bookmanagement.eventregistration.Repo.UserRepo;
import bookmanagement.eventregistration.execption.EventAlreadyRegsitered;
import bookmanagement.eventregistration.execption.UserNotFoundExecption;
import bookmanagement.eventregistration.model.EventModel;
import bookmanagement.eventregistration.model.Participants;
import bookmanagement.eventregistration.model.UserModel;
import jakarta.mail.Part;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EventServices {

    @Autowired
    private ParticipantsRepo participantsRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EventRepo eventRepo;

    public String registerUserToEvent(String email, Long eventId)
    {
        UserModel user = userRepo.findByEmail(email);
        if (user == null)
        {
            throw new RuntimeException("User not found with email: " + email);
        }
        Optional<EventModel> em = eventRepo.findById(eventId);
        if (em.isEmpty()) {
            throw new RuntimeException("Event with id " + eventId + " not found");
        }
        EventModel eventModel = em.get();

        Optional<Participants> existing = participantsRepo.findByUserIdAndEventId(user.getId(), eventModel.getId());
        if (existing.isPresent()) {
            throw new RuntimeException(user.getEmail() + " already registered for event " + eventModel.getTitle());
        }

        Participants participant = new Participants(user, eventModel, "registered");
        participantsRepo.save(participant);

        return "Successfully registered for event: " + eventModel.getTitle();
    }

    public List<EventModel> allEvent()
    {
        return eventRepo.findAll();
    }
}
