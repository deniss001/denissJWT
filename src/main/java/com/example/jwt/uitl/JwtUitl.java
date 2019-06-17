package com.example.jwt.uitl;


import com.example.jwt.config.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;


public class JwtUitl {


    public static String generateToken(String payload) {
        return Jwts.builder()
                .setSubject(payload)
                .setExpiration(new Date(System.currentTimeMillis() + 10000))
                .signWith(SignatureAlgorithm.HS256, JwtConfig.getApiKey())
                .compact();
    }


    public static String parseToken(String jwt) {
        return Jwts.parser()
                .setSigningKey(JwtConfig.getApiKey())
                .parseClaimsJws(jwt)
                .getBody()
                .getSubject();
    }


    public static boolean isTokenValid(String jwt) {
        try {
            parseToken(jwt);
        } catch (Throwable e) {
            return false;
        }
        return true;
    }

}
