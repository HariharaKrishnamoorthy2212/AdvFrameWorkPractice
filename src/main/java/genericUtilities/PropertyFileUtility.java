package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hpsf.Property;

/**
 * This Class Consist of Reusable methods related to Property File
 */

public class PropertyFileUtility {
	/**
	 * This method get key value from the caller method and returns value to the caller
	 * @author Harihara  Krishnamoorthy
	 * @param Key
	 * @return
	 * @throws IOException
	 */
 
	
	public String readDataFromPropertyFile(String Key) throws IOException {
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		Properties p = new Properties();
		p.load(fisp);
		String Value = p.getProperty(Key);
		return Value;
		
		
		
		
		
	}
	
}
