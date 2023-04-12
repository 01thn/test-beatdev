package by.tnavitski.testbeatdev.repository;

import by.tnavitski.testbeatdev.model.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    /**
     *
     * @param email for searching
     * @return optional of user
     */
    Optional<User> findByEmail(String email);
}
