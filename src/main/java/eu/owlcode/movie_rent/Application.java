package eu.owlcode.movie_rent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eu.owlcode.movie_rent.config.AppConfig;
import eu.owlcode.movie_rent.service.LoginService;
import eu.owlcode.movie_rent.service.MovieService;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        MovieService movieService = ctx.getBean(MovieService.class);
        LoginService loginService = ctx.getBean(LoginService.class);
        System.out.println(loginService.login("s.spielberg", "ET"));
        System.out.println(movieService.getRents("s.spielberg").size());
        ctx.close();

    }

}
