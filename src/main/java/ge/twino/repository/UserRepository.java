package ge.twino.repository;

/**
 * Created by SHEMO on 12/21/2016.
 */
import ge.twino.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;


@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
