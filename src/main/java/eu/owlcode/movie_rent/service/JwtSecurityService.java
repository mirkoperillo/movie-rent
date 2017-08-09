package eu.owlcode.movie_rent.service;

import java.security.Key;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import eu.owlcode.movie_rent.web.beans.UserLogin;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.crypto.MacProvider;
import spark.Request;

@Service
public class JwtSecurityService {

    private Key cryptoKey;

    private static final String AUTH_PATTERN = "Bearer (.+)";

    @PostConstruct
    private void init() {
        cryptoKey = MacProvider.generateKey();
    }


    public boolean isAuthenticatedRequest(Request req) {
        String token = getToken(req);

        try {
            Jwts.parser().setSigningKey(cryptoKey).parseClaimsJws(token);
            return true;
        } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException
                | SignatureException | IllegalArgumentException e) {
            return false;
        }
    }

    public String createToken(UserLogin login) {
        return Jwts.builder().setSubject(login.getUsername())
                .signWith(SignatureAlgorithm.HS256, cryptoKey).compact();
    }

    public String getPrincipal(Request req) {
        String token = getToken(req);

        Jws<Claims> claims = Jwts.parser().setSigningKey(cryptoKey).parseClaimsJws(token);
        System.out.println("token: " + token);
        System.out.println("username: " + claims.getBody().getSubject());
        return claims.getBody().getSubject();
    }

    private String getToken(Request req) {
        String authHeader = req.headers("Authorization");
        if (authHeader != null) {
            Matcher matcher = Pattern.compile(AUTH_PATTERN).matcher(authHeader);
            if (matcher.matches()) {
                return matcher.group(1);
            }
        }
        return null;
    }

}
