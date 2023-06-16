package com.qa.customexceptions;

public class YamlFileNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message
	 */
	public YamlFileNotFoundException(String message) {
		super(message);
	}
}
