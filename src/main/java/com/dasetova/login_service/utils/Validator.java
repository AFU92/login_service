package com.dasetova.login_service.utils;

import org.springframework.util.Assert;

public class Validator {
	
	/**
	 * Validate user id.
	 *
	 * @param userId the user id
	 * @return the integer
	 */
	public static Integer validateIntegerId(String id) {
		Assert.notNull(id, "The id must be specified");
		try {
			return Integer.parseInt(id);
		}catch (NumberFormatException e) {
			throw new IllegalArgumentException("The Id must be Integer");
		}
	}

}
