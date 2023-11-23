package practice;

import java.io.IOException;

import genericUtilities.JavaUtliites;
import genericUtilities.PropertyFileUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileUtility pful=new PropertyFileUtility();
		String Value = pful.readDataFromPropertyFile("browser");
		System.out.println(Value);
		String UN = pful.readDataFromPropertyFile("username");
		System.out.println(UN);
		
		JavaUtliites jutil=new JavaUtliites();
		String Value1=jutil.GetSystemDateFormat();
		System.out.println(Value1);
		
		}

}
