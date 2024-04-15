package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.domain.pojo.AdminPojo;


@Component
public class JwtAuthenticationProvider {
	
	
	private HashMap<String, AdminPojo> listToken = new HashMap<>();
	
	public String createToken(AdminPojo adminPojo) {
		
		Date dateNow = new Date();
		Date validity = new Date(dateNow.getTime()+2600000);
		Algorithm algorithm = Algorithm.HMAC256("hola");
		
		String tokenCreated= JWT.create()
				.withClaim("cardId", adminPojo.getCardId())
				.withClaim("fullName", adminPojo.getFullName())
				.withIssuedAt(dateNow)
				.withExpiresAt(validity)
				.sign(algorithm);
		
		listToken.put(tokenCreated,  adminPojo);
		return tokenCreated;
	}

}
