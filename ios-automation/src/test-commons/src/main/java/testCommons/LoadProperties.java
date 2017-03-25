package testCommons;

import java.io.InputStream;
import java.util.Properties;

public class LoadProperties {
	/**
	 * 
	 * @param propFile: The absolute path to a properties file (must be validated)
	 * @return
	 */
	public static Properties loadProperties(String propFile) throws Exception{
		Properties loadedProps = new Properties();
		try(InputStream in = LoadProperties.class.getClassLoader().getResourceAsStream(propFile)){
			loadedProps.load(in);
		}
		catch(Exception e){
			System.out.println("Properties file not present or couldn't be loaded.");
			throw new Exception("Properties file not present or couldn't be loaded.");
		}
		return loadedProps;
	}
	
	/**
	 * Returns either a property from the passed in properties file or from the system
	 * If no properties file is submitted, will default to system properties
	 * @param props
	 * @param propertyName
	 * @return
	 */
	public static String getProperties(Properties props, String propertyName){
		String returnProp = "";
		
		if (props == null){
			try{
				returnProp = System.getProperties().getProperty(propertyName);
			}
			catch(Exception e){
			}
			if (returnProp == null || returnProp.isEmpty()){
				System.out.println("Could not load " + propertyName + " from the system properties. Check your environment or Gradle script.");
			}
		}
		else if (props.containsKey(propertyName)){
			returnProp = props.getProperty(propertyName);
			if (returnProp == null || returnProp.isEmpty()){
				System.out.println("Could not load " + propertyName + " from the provided properties file. Check your properties file path and contents.");
			}
		}
		
		return returnProp;
	}
}
