package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scenerio4 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://localhost:8888");
		//step2 tp login application
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submit_button")).click();
		//navigate to organisation page
		driver.findElement(By.linkText("Organizations")).click();
		//click on create organisation
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//create org wih mandatory fields 
		driver.findElement(By.name("organization Name")).sendKeys("Kicha");
		//select energy in industry 
				WebElement ele =driver.findElement(By.name("industry"));
			WebElement ele1	=driver.findElement(By.name("Type"));
				Select s =new Select(ele);
				s.selectByVisibleText("energy");
				s.selectByVisibleText("Customer");
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				String he=driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(he.contains("kicha"))
				{
					System.out.println("pass");
					System.out.println(he);
					
				}else
					System.out.println("fail");
					
	
				WebElement ele3=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG]"));
				
				Actions a=new Actions(driver);
				a.moveToElement(ele).perform();
				Thread.sleep(1000);
				driver.findElement(By.linkText("Sign Out")).click();
				System.out.println("Sign out success");
				
	
	}

}
