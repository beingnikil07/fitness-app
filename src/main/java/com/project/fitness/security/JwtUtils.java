package com.project.fitness.security;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    private final String jwtSecret="ZXlKaGJHY2lPaUpJVXpJMU5pSXNJblI1Y0NJNklrcFhWQ0o5LmV5SnpkV0lpT2lJeE1qTTBOVFkzT0Rrd0lpd2libUZ0WlNJNklrcHZhRzRnUkc5bElpd2lZV1J0YVc0aU9uUnlkV1VzSW1saGRDSTZNVFV4TmpJek9UQXlNbjAuS01VRnNJRFRuRm15RzNuTWlHTTZIOUZORlVST2Yzd2g3U21xSnAtUVYzMA==";

    private Key getSigningKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + 86400000))  //valid till current time+24hrs
                .signWith(getSigningKey())
                .compact();
    }

    public String extractUserName(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) getSigningKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean isTokenValid(String token, UserDetails userDetails){
        return extractUserName(token).equals(userDetails.getUsername());
    }

}
