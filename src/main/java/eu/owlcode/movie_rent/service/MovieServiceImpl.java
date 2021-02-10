package eu.owlcode.movie_rent.service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eu.owlcode.movie_rent.model.User;
import eu.owlcode.movie_rent.persist.UserRepo;
import eu.owlcode.movie_rent.web.beans.MovieBean;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private UserRepo userRepo;


    @Override
    @Transactional
    public Set<MovieBean> getRents(String username) {
        Optional<User> user = userRepo.findById(username);
        if (user.isPresent()) {
            return Converter.convert(user.get().getRents());
        } else {
            return Collections.emptySet();
        }
    }

}
