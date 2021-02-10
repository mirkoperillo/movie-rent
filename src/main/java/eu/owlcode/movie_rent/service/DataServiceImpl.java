package eu.owlcode.movie_rent.service;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.owlcode.movie_rent.model.Movie;
import eu.owlcode.movie_rent.model.User;
import eu.owlcode.movie_rent.persist.MovieRepo;
import eu.owlcode.movie_rent.persist.UserRepo;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MovieRepo movieRepo;


    @PostConstruct
    private void init() {
        insertSampleData();
    }

    @Override
    public void insertSampleData() {
        if (userRepo.findById("s.spielberg").isEmpty()) {
            User user1 = new User();
            user1.setUsername("s.spielberg");
            user1.setPassword("ET");
            user1.setRents(getSpielbergRents());
            userRepo.save(user1);
        }

        if (userRepo.findById("c.nolan").isEmpty()) {
            User user1 = new User();
            user1.setUsername("c.nolan");
            user1.setPassword("batman");
            user1.setRents(getNolanRents());
            userRepo.save(user1);
        }

    }

    private Set<Movie> getNolanRents() {
        Set<Movie> rents = new HashSet<>();
        Movie movie = new Movie();
        movie.setTitle("batman begins");
        movie.setDurationInMinute(140);
        rents.add(movie);

        movie = new Movie();
        movie.setTitle("the dark knight");
        movie.setDurationInMinute(152);
        rents.add(movie);

        movieRepo.saveAll(rents);
        return rents;
    }

    private Set<Movie> getSpielbergRents() {
        Set<Movie> rents = new HashSet<>();
        Movie movie = new Movie();
        movie.setTitle("schindler's list");
        movie.setDurationInMinute(197);
        rents.add(movie);

        movie = new Movie();
        movie.setTitle("lo squalo");
        movie.setDurationInMinute(124);
        rents.add(movie);

        movieRepo.saveAll(rents);
        return rents;
    }

}
