package eu.owlcode.movie_rent.web;

import org.eclipse.jetty.http.HttpStatus;
import org.slf4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.gson.Gson;

import eu.owlcode.movie_rent.service.JwtSecurityService;
import eu.owlcode.movie_rent.service.LoginService;
import eu.owlcode.movie_rent.web.beans.UserLogin;
import spark.Spark;

public class LoginController {

    private static Logger logger = org.slf4j.LoggerFactory.getLogger(LoginController.class);
    private AnnotationConfigApplicationContext ctx;
    private LoginService loginService;
    private JwtSecurityService securityService;

    public LoginController(AnnotationConfigApplicationContext applicationContext) {
        ctx = applicationContext;
        loginService = ctx.getBean(LoginService.class);
        securityService = ctx.getBean(JwtSecurityService.class);
        start();
    }

    private void start() {
        Spark.post("/login", "application/json", (req, resp) -> {
            String body = req.body();
            Gson gson = new Gson();
            UserLogin loginObj = gson.fromJson(body, UserLogin.class);
            logger.info(body);
            if (loginService.login(loginObj.getUsername(), loginObj.getPassword())) {
                resp.status(HttpStatus.OK_200);
                return securityService.createToken(loginObj);
            } else {
                resp.status(HttpStatus.UNAUTHORIZED_401);
                return "";
            }
        });
    }
}
