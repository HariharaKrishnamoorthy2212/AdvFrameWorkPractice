package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import genericUtilities.WebDriverUtlitiy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebDriverUtlitiy
{
	@FindBy(linkText="Organizations")
	private WebElement orglink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(linkText="Products")
	private WebElement productlink;
	
	@FindBy(xpath= "//img[@src='themes/softed/images/layerPopupBg.gif']")
	private WebElement  adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement Signoutlnk;
	
	//intialization
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	//utilization

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getContactlink() {
		return contactlink;
	}

	public WebElement getProductlink() {
		return productlink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutlnk() {
		return Signoutlnk;
	}
	
	//Buisness library
	public void clickonOrgLink() {
		orglink.click();
		
	}

	public void clickContactLink() {
			contactlink.click();
	}
	public void clickProductLink() {
		productlink.click();
		
	}
	public void Signoutlnk(WebDriver driver) throws InterruptedException
	{
		clickandHold(driver,adminImg);
		Thread.sleep(1000);
		Signoutlnk.click();
		
		
	}

	
}
