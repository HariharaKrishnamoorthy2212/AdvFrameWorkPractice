package contactTest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import ObjectRepository.CreateContactPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtliites;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtlitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class createContact extends BaseClass {
@Test
public void createNewContactTest() {	

		//Read All the Required Data
	/*Test Data*/
	String LASTNAME=eUtil.readDataFromeExcel("Contacts",1,2);
		HomePage hp=new HomePage();
		
		
}
	
}