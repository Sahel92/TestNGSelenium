package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ReadYamlFiles {

	private static ReadYamlFiles readYamlFiles;
	private HashMap<Object, Object> propertyMap;

	/**
	 * + loads yaml file properties
	 * 
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		Yaml yaml = new Yaml();
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
		this.propertyMap = yaml.load(fileInputStream);

	}

	/**
	 * 
	 * @param filePath
	 * @return the connection to the yaml file
	 * @throws FileNotFoundException
	 */
	public static ReadYamlFiles getInstance(String filePath) throws FileNotFoundException {
		if (readYamlFiles == null)
			return new ReadYamlFiles(filePath);
		return readYamlFiles;
	}

	/**
	 * ui:{ browser : "chrome" url : "www.something.com"
	 * 
	 * @param key
	 * @return returnst a hashmap
	 * 
	 */

	@SuppressWarnings("unchecked")
	public Map<Object, Object> getYamlProperty(String key) {
		return (HashMap<Object, Object>) propertyMap.get(key);
	}

}
