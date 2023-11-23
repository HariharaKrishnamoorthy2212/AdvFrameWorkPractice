package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ObjectRepository.LoginPage;
import genericUtilities.WebDriverUtlitiy;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio1withGenericsandDDT {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//step1 to launch the browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtlitiy wutil=new WebDriverUtlitiy();
		wutil.webdriverMaximize();
		 
		wutil.webdriverMinimize();
		wutil.waitforPageload(driver);
		driver.get("http://localhost:8888");
		
		LoginPage lp =new LoginPage(driver);
		lp.logintoApp(USERNAME , PASSWORD);
		
		
		//step2 tp login application
		String	USERNAME=driver.findElement(By.name("user_name")).sendKeys("admin");
		String PASSWORD=driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitbutton")).click();
		//Step3Navigate tocontact list
		driver.findElement(By.linkText("Contacts")).click();
		//Step4 click on create look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact ...']")).click();
		//stept5  create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Hari");
		//step6 save
		driver.findElement(By.xpath("//input[@title='Save [Alt+s]']")).click();
		//step7 validate
		String ConHead=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(ConHead.contains("Hari"))
		{
			System.out.println("pass");
			System.out.println(ConHead);
		}
		else
			System.out.println("Fail");
		
		WebElement ele=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG]"));
		
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Sign Out")).click();
		System.out.println("Sign out success");
		
			
	}

}
