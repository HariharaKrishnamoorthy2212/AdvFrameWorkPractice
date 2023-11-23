package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class orgInfo {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgText;
	//initilization
	public orgInfo(WebDriver driver) {
		PageFactory.initElements(driver,this);
			}
	//utilization
	public WebElement getOrgText() {
		return OrgText;
	}
	//Buisess Library
	/*
	 * This method will capture the header text and return the text to the caller
	 * @return
	 * 
	 */
	public String orgHeader() {
		return OrgText.getText();
		
	}
}
