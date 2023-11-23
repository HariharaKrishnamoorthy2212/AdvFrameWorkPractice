package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio2 extends Scenerio1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// launchBrowser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://localhost:8888");
		
		
		//loginapplication 
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submit_button")).click();
		
		
		
		//navigate to organisation page
		driver.findElement(By.linkText("Organizations")).click();
		//click on create organisation
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//create org wih mandatory fields 
		driver.findElement(By.name("organization Name")).sendKeys("Kicha");
		driver.findElement(By.xpath("//input[@type='radio']")).click();
		
		
		// save and verify
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String text=driver.findElement(By.xpath("//span[@class='dvtCellInfo']")).getText();
		if(text.contains("kicha"))
		{
			System.out.println("pass");
			System.out.println(text);
			
		}
		else
			System.out.println("Fail");
		//logout
	WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG]"));
		
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out success");
		
		
		
		
		
	}

}
