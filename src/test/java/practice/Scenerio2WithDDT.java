package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio2WithDDT {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\commondata.property");
		Properties p= new Properties();
		p.load(fisp);
		
		String URL=p.getProperty("url");
		String BROWSER	= p.getProperty("browser");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		//TEST DATA
		
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
			String ORG = wb.getSheet("Organizations").getRow(2).getCell(2).getStringCellValue();
			System.out.println(ORG);
			WebDriver driver = null;
			
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
			driver.findElement(By.linkText("Organizations")).click();
			System.out.println("navigated to Organizations");
			driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
			System.out.println("Add button is pressed");
			driver.findElement(By.name("accountname")).sendKeys(ORG);
			System.out.println("ORG name is added");
		//	driver.findElement(By.xpath("//input[@title='Save [Alt+S] ']'")).click();
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			System.out.println("ORG is saved");
			WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			System.out.println("navigated to web elemnet");
			Actions a=new Actions(driver);
			a.moveToElement(ele).perform();
			Thread.sleep(1000);
			driver.findElement(By.linkText("Sign Out")).click();
			System.out.println("Sign out success");
			
			

	}

}
