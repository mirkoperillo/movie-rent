package eu.owlcode.movie_rent.persist;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import eu.owlcode.movie_rent.config.AppConfig;
import eu.owlcode.movie_rent.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
public class RepoTest {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Before
    public void clean() {
        userRepo.deleteAll();
        movieRepo.deleteAll();
    }

    @Test
    public void crud() {
        Assert.assertEquals(0, userRepo.count());
        User user = new User();
        user.setUsername("utente");
        user.setPassword("password");
        userRepo.save(user);
        Assert.assertEquals(1, userRepo.count());
    }

}
