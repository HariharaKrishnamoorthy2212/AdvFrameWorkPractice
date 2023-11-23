package genericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class Contains of Reusable methods  relatingto Scenrio 1
 */

public class Scenerio1Utilities {
	/** 
	 * This Method Gets Arguments from Caller Method and Return value to the called function
	 * @author Harihara Krishnamoorthy
	 * @throws IOException 
	 */
	public String scenerio1(String key) throws IOException {
		
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		Properties p = new Properties();
		p.load(fisp);
		String Value = p.getProperty(key);
		FileInputStream fise=new FileInputStream(".");
		return Value;
		
	}
	
}
