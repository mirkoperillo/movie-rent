package eu.owlcode.movie_rent.web;

import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eu.owlcode.movie_rent.service.JsonTransformer;
import eu.owlcode.movie_rent.service.JwtSecurityService;
import eu.owlcode.movie_rent.service.MovieService;
import spark.Spark;

public class ProtectedApiController {
    private static Logger logger = org.slf4j.LoggerFactory.getLogger(ProtectedApiController.class);
    private AnnotationConfigApplicationContext ctx;
    private JwtSecurityService securityService;
    MovieService movieService;

    public ProtectedApiController(AnnotationConfigApplicationContext applicationContext) {
        ctx = applicationContext;
        securityService = ctx.getBean(JwtSecurityService.class);
        movieService = ctx.getBean(MovieService.class);
        start();
    }

    private void start() {
        Spark.before("/private/*", (req, resp) -> {
            if (!securityService.isAuthenticatedRequest(req)) {
                Spark.halt(HttpStatus.UNAUTHORIZED_401,
                        "private resource, you need to be authenticated to access in");
            }
        });
        Spark.get("/private/rents", (req, resp) -> {
            String username = securityService.getPrincipal(req);
            return movieService.getRents(username);
        }, new JsonTransformer());
    }
}
