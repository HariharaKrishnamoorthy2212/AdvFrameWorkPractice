package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
		// TODO Auto-generated method stub
		@FindBy(name = "user_name")
		private WebElement userNameEdt;
		
		@FindBy(name="user_password")
		private WebElement passwordEdt;
		
		@FindBy(id = "submitButton")
		private WebElement loginBtn;
		
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		public WebElement getUserNameEdt() {
			return userNameEdt;
		}

		

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}


		public WebElement getLoginBtn() {
			return loginBtn;
		}

		public void logintoApp(String USERNAME,String PASSWORD) {
			
			userNameEdt.sendKeys(USERNAME);
			passwordEdt.sendKeys(PASSWORD);
			loginBtn.click();
			
		}
		
		}