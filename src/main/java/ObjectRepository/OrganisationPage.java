package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationPage {
	
	@FindBy(xpath ="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgLookUpimg;
	
	public OrganisationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLookUpimg() {
		return orgLookUpimg;
	}
	//Buisness Logic
	public void clickonOrglink() {
		orgLookUpimg.click();
	}
}
