package com.rgbitsoft.security.token;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Calendar;
import java.util.Date;

public class JwtTokenProvider {

    private SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256); // 토큰 암호화키
    private int tokenExpirationMsec = 1800000;  // 만료시간 30분

    public String createToken() {

        // setExpiration 매개변수가 Date로 되어있어 LocalDateTime를 사용하지 못함
        Date now = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MILLISECOND, tokenExpirationMsec);
        Date expiryDate =  calendar.getTime();

        return Jwts.builder()
                .setSubject("Bonjour Park")
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String authToken) throws JwtException {

        try {
            Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        } catch (JwtException e) {
            e.printStackTrace();
        }
        return false;
    }
}
