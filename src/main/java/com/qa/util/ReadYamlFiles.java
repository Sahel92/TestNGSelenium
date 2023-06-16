package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.qa.customexceptions.YamlFileNotFoundException;

public class ReadYamlFiles {

	private static ReadYamlFiles readYamlFiles;
	private final HashMap<Object, Object> propertyMap;

	private ReadYamlFiles(String filePath) throws FileNotFoundException {
		FileInputStream fileInputStream = FileUtility.getFileInputStream(filePath);
		Yaml yaml = new Yaml();
		this.propertyMap = yaml.load(fileInputStream);

	}

	public static ReadYamlFiles getInstance(String filePath) throws YamlFileNotFoundException {
		if (readYamlFiles == null)
			try {
				return new ReadYamlFiles(filePath);
			} catch (FileNotFoundException e) {
				throw new YamlFileNotFoundException(
						"The ENVIRONMENT CONFIGURATIONS was not found on the FilePath: " + filePath);
			}
		return readYamlFiles;
	}

	public Map<Object, Object> getYamlProperty(String key) {
		return (HashMap<Object, Object>) propertyMap.get(key);
	}

}
