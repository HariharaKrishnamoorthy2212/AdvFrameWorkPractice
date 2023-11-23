package genericUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This Class Consists of Method Related to Java GenricMethods
 * @author Hari
 */

public class JavaUtliites {
	public String GetSystemDateFormat() {
	Date d=new Date();
	SimpleDateFormat Formatter = new SimpleDateFormat("dd-mm-yyyy-hh-mm-ss");
	String Date = Formatter.format(d);
	return Date;
	}
	
	public int GetRandomNumber()
	{
		Random r =new Random();
		int value=r.nextInt(100);
		return value;
				
				
				
	}
	
	
}
