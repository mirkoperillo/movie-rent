package eu.owlcode.movie_rent.service;

import java.util.Set;

import eu.owlcode.movie_rent.web.beans.MovieBean;

public interface MovieService {
    Set<MovieBean> getRents(String username);
}
