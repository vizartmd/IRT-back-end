package com.stefanini.irtbackend.config.security.jwt;

import com.stefanini.irtbackend.config.security.jwt.exception.JwtAuthenticationException;
import com.stefanini.irtbackend.dao.impl.JwtTokenDaoImpl;
import com.stefanini.irtbackend.domain.entity.JwtToken;
import com.stefanini.irtbackend.service.JwtTokenService;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;

@Component
public class JwtTokenProvider {

    private final UserDetailsService userDetailsService;
    private final JwtTokenService jwtTokenService;

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.header}")
    private String authorizationHeader;

    @Value("${jwt.expiration}")
    private long validityInMilliseconds;

    public JwtTokenProvider(@Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, JwtTokenService jwtTokenService) {
        this.userDetailsService = userDetailsService;
        this.jwtTokenService = jwtTokenService;
    }

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, String role) {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("role", role);
        Date now = new Date();
        List<JwtToken> jwtTokens = jwtTokenService.findAll();
        JwtToken jwtToken = null;
        for (int i = 0; i < jwtTokens.size(); i++) {
            if (i == jwtTokens.size() - 1) {
                jwtToken = jwtTokens.get(i);
                System.out.println("jwtTokens.toString(): " + jwtTokens.toString());
            }
        }
        Long validityToken;
        if (jwtToken == null) {
            validityToken = validityInMilliseconds;
        } else {
            validityToken = jwtToken.getCounter();
        }
        System.out.println("validityToken: " +  validityToken);
        Date validity = new Date(now.getTime() + validityToken * 1000);
        System.out.println("validityInMilliseconds * 1000: " +  validityInMilliseconds * 1000);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public boolean validateToken(String token) throws JwtAuthenticationException {
        try {
            Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claimsJws.getBody().getExpiration().before(new Date());
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtAuthenticationException("JWT token is expired or invalid", HttpStatus.UNAUTHORIZED);
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = this.userDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());

    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest request) {
        return request.getHeader(authorizationHeader) == null ? null :
                request.getHeader(authorizationHeader).split(" ")[1];
    }
}
