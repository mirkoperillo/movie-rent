package eu.owlcode.movie_rent.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.owlcode.movie_rent.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, String> {

    public User findByUsernameAndPassword(String username, String password);

}
