package com.apps.ws;

import java.security.Key;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

public class teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Key key = MacProvider.generateKey();

		String jwtString = Jwts.builder().setSubject("Joe").signWith(SignatureAlgorithm.HS512, "12345678901234567890")
				.compact();
		System.out.println(jwtString);
		assert Jwts.parser().setSigningKey(key).parseClaimsJws(jwtString).getBody().getSubject().equals("Joe"); // Will
		System.out.println(
				Jwts.parser().setSigningKey("12345678901234567890").parseClaimsJws(jwtString).getBody().getSubject()); // throw
		// `SignatureException`
		// if
		// signature
		// validation
		// fails.

	}

}
