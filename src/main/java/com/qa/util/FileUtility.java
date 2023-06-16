package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileUtility {

	private FileUtility() {
		super();
	}

	/**
	 * 
	 * @param String filePath
	 * @return connection to the file
	 * @throws FileNotFoundException
	 */
	public static FileInputStream getFileInputStream(String filePath) throws FileNotFoundException {
		return new FileInputStream(new File(filePath));
	}

}
