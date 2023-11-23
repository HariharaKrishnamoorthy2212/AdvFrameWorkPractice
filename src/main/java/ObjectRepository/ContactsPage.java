package ObjectRepository;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class ContactsPage {
		

		@FindBy(xpath="//img[@src='themes/softed/images/layerPopupBg.gif']")
		private WebElement addContactlink;
		
		//intiialization
		public ContactsPage(WebDriver driver) {
			PageFactory.initElements(driver,this);
			
		}
		//utilization

		public WebElement getAddContactlink() {
			return addContactlink;
		}
		//BuisnessLibrary
		public void clickAddConLnk() {
			addContactlink.click();
		}
	}


