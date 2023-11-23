package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtlitiy;

public class CreateContactPage extends WebDriverUtlitiy {
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgbtn;
	@FindBy(name="search-text")
	private WebElement OrgSearchEdt;
	@FindBy(name="search")
	private WebElement searchbtn;
	
	//intilization
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		
	}
	//utilization

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getOrgbtn() {
		return orgbtn;
	}

	public WebElement getOrgSearchEdt() {
		return OrgSearchEdt;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}
	
	//Buisness Logic
	public void createNewContact(WebDriver driver,String LASTNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		savebtn.click();
	}
	
	
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME) {
		lastNameEdt.sendKeys(LASTNAME);
		savebtn.click();
		switchTOFrame(driver,"Accounts");
		orgbtn.sendKeys(ORGNAME);
		orgbtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchTOFrame(driver,"Contacts");
		searchbtn.click();
		
		
		
	}
	
	
	
}
