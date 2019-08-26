/**
 * 
 */
package com.uster.demo.carRental.utilities;

/**
 * @author DM
 *
 */
public class CustomNotFoundException extends RuntimeException {

	public CustomNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomNotFoundException(String message) {
		super(message);
	}

	public CustomNotFoundException(Throwable cause) {
		super(cause);
	}
}
