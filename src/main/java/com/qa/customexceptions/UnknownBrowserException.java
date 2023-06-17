package com.qa.customexceptions;

public class UnknownBrowserException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	public UnknownBrowserException(String message) {
		super(message);
	}
}
