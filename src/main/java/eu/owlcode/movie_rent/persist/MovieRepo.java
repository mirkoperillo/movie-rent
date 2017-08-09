package eu.owlcode.movie_rent.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import eu.owlcode.movie_rent.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {

}
