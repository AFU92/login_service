package com.dasetova.login_service.model.api;

import java.util.ArrayList;
import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class ErrorMessage.
 */
public class ErrorMessage {

	/** The message. */
	private String message;

	/** The errors. */
	private List<String> errors;

	/**
	 * Instantiates a new error message.
	 *
	 * @param message the message
	 * @param errors  the errors
	 */
	public ErrorMessage(String message, List<String> errors) {
		this.message = message;
		this.errors = errors;
	}

	/**
	 * Instantiates a new error message.
	 *
	 * @param message the message
	 */
	public ErrorMessage(String message) {
		this.message = message;
		this.errors = new ArrayList<String>();
	}

	/**
	 * Gets the message.
	 *
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Sets the message.
	 *
	 * @param message the new message
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * Gets the errors.
	 *
	 * @return the errors
	 */
	public List<String> getErrors() {
		return errors;
	}

	/**
	 * Sets the errors.
	 *
	 * @param errors the new errors
	 */
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
