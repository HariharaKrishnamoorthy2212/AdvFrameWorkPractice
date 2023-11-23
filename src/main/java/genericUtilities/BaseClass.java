package genericUtilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * This Class Consists of basic Annotations of TestNG
 * 
 */
public class BaseClass {
 public PropertyFileUtility pUtil=new PropertyFileUtility();
 public ExcelFileUtility eUtil=new ExcelFileUtility();
 public WebDriverUtlitiy wUtil=new WebDriverUtlitiy();
 public JavaUtliites jutil=new JavaUtliites();
 public WebDriver driver=null;
 
 public static WebDriver sdriver;
 @BeforeSuite
 public void bsconfig() {
	 System.out.println("DB Conncection sucessfull");
	 
 }
 @BeforeClass (alwaysRun=true)
 public void bcConfig() throws IOException 
 {
	 String BROWSER = pUtil.readDataFromPropertyFile("browser");
	 String URL = pUtil.readDataFromPropertyFile("url");
	 
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
			System.out.println(BROWSER+"BROWSER IS LAUNCHED");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			System.out.println(BROWSER+"BROWSER IS LAUNCHED");
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			System.out.println(BROWSER+"BROWSER IS LAUNCHED");
		}
		else {
			System.out.println("INVALID BROWSER");
		}
		sdriver=driver;
		wUtil.webdriverMaximize();
		wUtil.waitforPageload(driver);
		driver.get(URL);
 }

}