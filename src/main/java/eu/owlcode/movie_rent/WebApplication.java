package eu.owlcode.movie_rent;

import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import eu.owlcode.movie_rent.config.AppConfig;
import eu.owlcode.movie_rent.web.LoginController;
import eu.owlcode.movie_rent.web.ProtectedApiController;

public class WebApplication {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(WebApplication.class);


    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();
        new LoginController(ctx);
        new ProtectedApiController(ctx);
        logger.info("Server is running");
        ctx.registerShutdownHook();

    }


}
