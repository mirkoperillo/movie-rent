package eu.owlcode.movie_rent.service;

import java.util.HashSet;
import java.util.Set;

import eu.owlcode.movie_rent.model.Movie;
import eu.owlcode.movie_rent.web.beans.MovieBean;

public class Converter {

    public static MovieBean convert(Movie movie) {
        MovieBean converted = new MovieBean();
        converted.setDuration(movie.getDurationInMinute());
        converted.setGenre(movie.getGenre());
        converted.setTitle(movie.getTitle());
        return converted;
    }

    public static Set<MovieBean> convert(Iterable<Movie> movies) {
        Set<MovieBean> converted = new HashSet<>();
        for (Movie movie : movies) {
            converted.add(convert(movie));
        }

        return converted;
    }
}
