package eu.owlcode.movie_rent.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie implements Serializable {

    private static final long serialVersionUID = 3435858711510973719L;

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String genre;
    private int duration;

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDurationInMinute() {
        return duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setDurationInMinute(int duration) {
        this.duration = duration;
    }

}
