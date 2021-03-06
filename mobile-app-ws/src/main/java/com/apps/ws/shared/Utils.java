package com.apps.ws.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	// private final String ALPHABET =
	// "0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZabcdefghijklmnñopqrstuvwxyz";
	private final String NUM = "0123456789";

	public String getGeneratedUserId(int length) {
		return generateString(length);
	}

	public String getGeneratedAddressId(int length) {
		return generateString(length);
	}

	private String generateString(int length) {
		StringBuilder returnValue = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			returnValue.append(NUM.charAt(RANDOM.nextInt(NUM.length())));
		}
		return new String(returnValue);

	}

}
