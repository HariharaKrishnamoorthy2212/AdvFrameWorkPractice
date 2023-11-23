package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtlitiy;

public class orginfoPage extends WebDriverUtlitiy {
	@FindBy(name="accountname")
	private WebElement orgName;
	@FindBy(name="industry")
	private WebElement industryDropdown;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public orginfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	//Buisness Logic
	public void createneworg(WebDriver driver,String ORGNAME,String INDUSTRY) {
		orgName.sendKeys(ORGNAME);
		handleDropdown(industryDropdown,INDUSTRY);
		saveBtn.click();
		
		
		
	}
	
	
}
