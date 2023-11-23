package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtlitiy {
	
	WebDriver driver;
	/**
	 * This is driver  generic method which maximize window
	 * @author Hari
	 */
	public void webdriverMaximize() {
		driver.manage().window().maximize();
		}
	/**
	 * THis is driver generic method which minimize the window
	 */
	public void webdriverMinimize() {
		driver.manage().window().minimize();
	}
	/**
	 * This is driver generic method which is wait for the page to load
	 * @param driver
	 * @author Hari
	 * 
	 */
	public void waitforPageload(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	/**
	 * This is driver generic method which wait for element ot be visible
	 * @param driver
	 * @param element
	 * 
	 */
	public void waitforElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This is genric method which is used to handle dropdown listbox 
	 * based on index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index) {
		Select sel=new Select(element);
		sel.selectByIndex(index);
		
	}
	/**This is genric method which is used to handle dropdown listbox 
	 * based on visible text
	 * @param element
	 * @param val
	 */
	
	
	public void handleDropdown(WebElement element,String val ) {
		Select sel=new Select(element);
		sel.selectByVisibleText(val);
		
	}
	/**
	 * This is genric method which is used to handle dropdown listbox 
	 * based on value
	 * @param element
	 * @param val1
	 */
	public void handleDropdownby(WebElement element,String val1) {
		Select sel=new Select(element);
		sel.selectByValue(val1);
	}
	/**This method will perform click and hold mouse action
	 * @param driver
	 * @param x
	 *@param y
	 */
	public void clickndHold(WebDriver driver,int x, int y) {
		Actions a=new Actions(driver);
		a.moveByOffset(x, y).click().perform();	
	}
	/**
	 * This method will perform double Click operations
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.doubleClick(element).click().perform();
	
	}
	/**
	 * This method will perform mouse hovering actions
	 * @param driver
	 * @param element1
	 */
	public void MovetoElement(WebDriver driver,WebElement element1)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element1).click().perform();
	}
	/** this method will perform right click
	 *
	 *
	 */
	public void rightClick(WebDriver driver) {
	Actions a =new Actions(driver);
	a.contextClick().click().perform();

	}
	/**This method will perform  DragandDrop
	 * 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void DragandDrop(WebDriver driver,WebElement source ,WebElement target) {
		Actions a =new Actions(driver);
		a.dragAndDrop(source, target).click().perform();
	}
	/**This method will perform clickandHold
	 * 
	 * @param driver
	 * @param target1
	 */
	public void clickandHold(WebDriver driver,WebElement target1)
	{
		Actions a=new Actions(driver);
		a.clickAndHold(target1).click().perform();
	}
	/**This method will perform Scroll down operation
	 * 
	 * @param driver
	 */
	public void toScrollDown(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,500)");
	}
	/**This method will perform Scroll up operation
	 * 
	 * @param driver
	 */
	public void toScrollUp(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-300)");
	}
	/**
	 * *This method will perform Scroll Right operation
	 * @param driver
	 */
	public void toScrollRight(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(300,0)");
	}
	/**
	 * *This method will perform Scroll left operation
	 * @param driver
	 */
	public void toScrollLeft(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(-300,0)");
	}
	/**This method will Accept alert in popups
	 * 
	 * @param driver
	 */
	
	public void alert(WebDriver driver) {
		
		driver.switchTo().alert().accept();
		
	}
	/**This method will Decline  alert in popups
	 * 
	 * @param driver
	 */
	public void dismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**This method will get alert Text in popups
	 * 
	 * @param driver
	 * @return
	 */
	public String getAlertText(WebDriver driver)
	{
		String text=driver.switchTo().alert().getText();
		return text;
		
	}
	/**
	 * This method will handle frameSwitching
	 * @param driver
	 *@param index
	 */
	
	public void switchTOFrame(WebDriver driver,int index) {
		
		driver.switchTo().frame(index);
		
	}
	/**This method will switch the frame based on name or id
	 * 
	 * @param driver
	 * @param nameOrId
	 */
	
    public void switchTOFrame(WebDriver driver,String nameOrId) {
		
		driver.switchTo().frame(nameOrId);
		
	}
    /**This method will switch the frame based on WebElement
     * 
     * @param driver
     * @param element
     */
    public void switchTOFrame(WebDriver driver,WebElement element) {
		
		driver.switchTo().frame(element);
		
	}

    public void switchTOWindow(WebDriver driver,String parWindowTitle)
    {
    	//Step 1 Capture All Window ID
    			Set<String> allWindowID = driver.getWindowHandles(); //main/child/child
    	
    	//Step 2 Navigate to Each wind
    	
    			for(String windowID: allWindowID) {
    	
    	//step 3 switch to each window and capture the title
    	
    			String actTitle=driver.switchTo().window(windowID).getTitle();
    	
    	//step 4 compare the actual title with partial window title
    			if(actTitle.contains(parWindowTitle)) {
    			break;
    			}
    	}
    }
    /**
     * This generic  is used to captur the ScreenShot
     * @param driver
     * @param screenShotName
     * @return
     * @throws IOException 
     */
    			
    	public String captureScreenshot(WebDriver driver,String screenShotName) throws IOException 
    	{
    	TakesScreenshot ts=(TakesScreenshot) driver;
    	File  src = ts.getScreenshotAs(OutputType.FILE);
    	File  dst =	new File(".\\ScreenShots\\"+screenShotName+".png");
    	
    	Files.copy(src,dst);
    	return dst.getAbsolutePath();
    	
    	}
   }
