package com.mohanmmohadikar.microbloggerbackend.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Date;


@Service
public class JwtProvider {

    String key = JwtConstant.SECRET_KEY;

    public String generateToken(Authentication authentication) {
        return Jwts
                .builder()
                .setIssuedAt(new Date())
                .setExpiration(Date.from(ZonedDateTime.now().plusMinutes(5).toInstant()))
                .claim("email", authentication.getName())
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    public String getEmailFromToken(String jwt) {
        jwt = jwt.substring(7);
        Claims claims = Jwts
                .parser()
                .setSigningKey(JwtConstant.SECRET_KEY)
                .parseClaimsJwt(jwt)
                .getBody();

        return String.valueOf(claims.get("email"));
    }
}
