package practice;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import genericUtilities.WebDriverUtlitiy;

import org.openqa.selenium.*;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		WebDriverUtlitiy wutil=new WebDriverUtlitiy();
		wutil.webdriverMaximize();
		 
		wutil.webdriverMinimize();
		wutil.waitforPageload(driver);
		
		driver.get("http://localhost:8888");
		//step2 tp login application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submit_button")).click();
		//Step3Navigate tocontact list
		driver.findElement(By.linkText("Contacts")).click();
				//Step4 click on create look up image
		driver.findElement(By.xpath("//img[@alt='Create Contact ...']")).click();
				//stept5  create contact with mandatory fields
		driver.findElement(By.name("lastname")).sendKeys("Hari");
		// step 6 click on org lookup img
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		//step7 get window id
		String parentWId = driver.getWindowHandle();
		System.out.println(parentWId);
		//step 8 get window ids
		Set<String> id = driver.getWindowHandles();
		
		for(String winID :id)
		{
			if(!winID.equals(parentWId)) {
				driver.switchTo().window(winID);
			}
			
			
		}
		//step10 search for organisation
		driver.findElement(By.name("search_text")).sendKeys("399");
		driver.findElement(By.name("search")).click();
		driver.findElement(By.linkText("Ch399")).click();
		//step10 switchthe control back to main
		driver.switchTo().window(parentWId);
		
	
	}
	

}
