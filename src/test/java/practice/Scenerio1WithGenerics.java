package practice;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ObjectRepository.LoginPage;
import genericUtilities.Scenerio1Utilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio1WithGenerics {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Scenerio1Utilities u=new Scenerio1Utilities();
		String BROWSER = u.scenerio1("browser");
		String URL = u.scenerio1("url");
		String USERNAME = u.scenerio1("username");
		String PASSWORD = u.scenerio1("password");
		System.out.println("got credentials from propertyfile");
		
		
		WebDriver driver=null;
		
		LoginPage lp=new LoginPage(driver);
		lp.logintoApp(USERNAME, PASSWORD);
		
		//Launch of Browser
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			System.out.println("INVALID BROWSER");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		System.out.println("login done ");
		//step4 Navigate to contacts link
		driver.findElement(By.linkText("Contacts")).click();
		System.out.println("navigated to contacts");
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		System.out.println("Add button is pressed");
		//driver.findElement(By.name("lastname")).sendKeys(LASTNAME);
		System.out.println("last name is added");
	//	driver.findElement(By.xpath("//input[@title='Save [Alt+S] ']'")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		System.out.println("Contacts is saved");
		
	}

}
