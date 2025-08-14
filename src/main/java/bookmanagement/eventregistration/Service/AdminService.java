package bookmanagement.eventregistration.Service;


import bookmanagement.eventregistration.Repo.EventRepo;
import bookmanagement.eventregistration.Repo.RegisterRepo;
import bookmanagement.eventregistration.execption.DatabaseNotSaveExecption;
import bookmanagement.eventregistration.model.EventModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    RegisterRepo registerRepo;
    @Autowired
    EventRepo  eventRepo;
    public EventModel addEvents(EventModel eventModel)
    {
       try{
           EventModel event=eventRepo.save(eventModel);
           return event;
       }catch(DataAccessException e)
       {
           throw new DatabaseNotSaveExecption("Database not save successfully please try again");
       }

    }
}
