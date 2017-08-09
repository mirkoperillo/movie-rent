package eu.owlcode.movie_rent.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User implements Serializable {
    private static final long serialVersionUID = 4422162260946745829L;

    @Id
    private String username;
    private String password;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Movie> rents;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Movie> getRents() {
        return rents;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRents(Set<Movie> rents) {
        this.rents = rents;
    }

}
