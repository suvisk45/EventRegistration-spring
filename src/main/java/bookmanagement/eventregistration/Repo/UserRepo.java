package bookmanagement.eventregistration.Repo;

import bookmanagement.eventregistration.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<UserModel,Long> {

    UserModel findByEmail(String email);
}
