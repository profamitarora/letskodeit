package Academy;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePageTestCases extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());
	public WebDriver driver;
	landingPage lp;
	loginPage login;

	@BeforeClass
	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initialized");
		lp = new landingPage(this.driver);
		login = new loginPage(this.driver);
		driver.get(prop.getProperty("url"));
		log.info("Navigated to the URL");
		System.out.println(driver.getTitle());
	}

	@Test
	public void radioButtonVerification() throws InterruptedException
	{
		WebElement radioButton = lp.getRadioButton();
		radioButton.click();
		log.info("Radio Button Clicked");
		Assert.assertTrue(radioButton.isSelected());
		log.info("Radio Button Asserted Successfully");
    }
	
	@Test
	public void selectDropDownVerification() throws InterruptedException {
		WebElement dropdown = lp.getDropdown();
		Select s = new Select(dropdown);
		dropdown.click();
		log.info("Drop-down Clicked");
		Thread.sleep(2000L);
		s.selectByIndex(2);
		dropdown.click();
		String option = s.getFirstSelectedOption().getText();
		Assert.assertEquals("Honda", option);
		log.info("Drop-down Asserted Successfully");

	}
	
	@Test(priority=3)
	public void openNewTabVerification() throws InterruptedException {
		
		WebElement newTabButton = lp.getNewTabButton();
		newTabButton.click();
		log.info("Open New Tab Button Clicked");
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
		String parentwindow = it.next();
		String childwindow = it.next();
		driver.switchTo().window(childwindow);
		log.info("Switched to another window");
        Thread.sleep(3000L);
        String newTabTitle = driver.getTitle();
        Assert.assertEquals("All Courses", newTabTitle);
        driver.switchTo().window(parentwindow);
        log.info("back to main window");
        log.info("Open New Tab Button Asserted Successfully");
	}
	
	@Test(priority=4)
	public void alertButtonVerification() throws InterruptedException
	{
	    String name = "Amit Arora";
		lp.getNameBox().sendKeys(name);
		log.info("Name entered in name box");
		Thread.sleep(1000L);
		lp.getAlertButton().click();
		log.info("Alert Button Clicked");
		Thread.sleep(1000L);
		String alertTextReceived = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expectedString = "Hello "+name+", share this practice page and share your knowledge";
		Assert.assertEquals(alertTextReceived,expectedString);
		log.info("Alert Button Asserted Successfully");
	}
	
	
	@Test(priority=4)
	public void confirmButtonVerification() throws InterruptedException
	{
	    String name = "Amit Arora";
		lp.getNameBox().sendKeys(name);
		log.info("Name entered in name box");
		Thread.sleep(1000L);
		lp.getConfirmButton().click();
		log.info("Confirm Button Clicked");
		Thread.sleep(1000L);
		String alertTextReceived = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		String expectedString = "Hello "+name+", Are you sure you want to confirm?";
		Assert.assertEquals(alertTextReceived,expectedString);
		log.info("Confirm Button Asserted Successfully");
	}
	
	@Test(priority=5)
	public void webTableContentVerification() throws InterruptedException
	{
		List <WebElement> webTableData =  lp.getWebTableData();
		WebElement priceTag=null;		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,300)");
		log.info("Window scrolled to make webtable visible");
		for (WebElement rowData : webTableData)
		{
            if(rowData.getText().contains("Python"))
            {
            	//System.out.print(rowData.getText());
            	priceTag = rowData.findElement(By.xpath("following-sibling::*[1]"));
            	//System.out.print("\t"+priceTag.getText());
            	//System.out.println("");
            	break;
            }            
        }
		Assert.assertEquals(priceTag.getText(), "30");
		log.info("Price of WebTable content Asserted Successfully");
	}
	
	@Test(priority=4)
	public void enableButtonVerification() throws InterruptedException
	{
	    
		WebElement textBox = lp.getTextBox();
		WebElement enableButton = lp.getEnableButton();
		enableButton.click();
		log.info("Enable Button Clicked");
		textBox.sendKeys("Amit");
		Assert.assertTrue(textBox.isEnabled());
		log.info("Enable Button Asserted Successfully");
	}
		
	@Test(priority=4)
	public void disableButtonVerification() throws InterruptedException
	{
	    WebElement textBox = lp.getTextBox();
		WebElement disableButton = lp.getDisableButton();
		log.info("Disable Button Clicked");
		disableButton.click();
		Assert.assertTrue(!textBox.isEnabled());
		log.info("Disable Button Asserted Successfully");
	}
	
	@Test(priority=5)
	public void showButtonVerification() throws InterruptedException
	{
	    
		WebElement showTextBox = lp.getShowTextBox();
		WebElement showButton = lp.getShowButton();
		showButton.click();
		log.info("Show Button Clicked");
		showTextBox.sendKeys("Amit");
		Assert.assertTrue(showTextBox.isDisplayed());
		log.info("Show Button Asserted Successfully");
	}
	
	
	@Test(priority=5)
	public void hideButtonVerification() throws InterruptedException
	{
		WebElement showTextBox = lp.getShowTextBox();
	    WebElement hideButton = lp.getHideButton();
	    hideButton.click();
	    log.info("Hide Button Clicked");
		Assert.assertTrue(!showTextBox.isDisplayed());
		log.info("Hide Button Asserted Successfully");
	}
	
	@Test(priority=8)
	public void mouseHoverAndReloadVerification() throws InterruptedException
	{
		Actions a = new Actions(driver);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		WebElement radioButton2 = lp.getRadioButton2();
		radioButton2.click();
		Thread.sleep(2000L);
		//Assert.assertTrue(rbutton1.isSelected());
		Thread.sleep(1000L);
		WebElement mouseHoverButton = lp.getMouseHoverButton();
		a.moveToElement(mouseHoverButton).build().perform();
		log.info("Mouse Hovering");
		lp.getReloadOption().click();
		log.info("Reload Option Clicked from dropdown");
		WebDriverWait wt = new WebDriverWait(driver,5);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='hondaradio']")));
		radioButton2 = driver.findElement(By.xpath("//input[@id='hondaradio']"));   //this step is cure for Stale Element exception
		Assert.assertTrue(!(radioButton2.isSelected()));
		log.info("Mouse Hover and Reload action Asserted Successfully");
	}
	
	@Test(priority=9)
	public void countLinkMainPage() throws InterruptedException
	{
		List<WebElement> links = lp.getMainPageLinks();
		int linkCount = links.size();
		log.info("Total Links on the Main Page counted : "+linkCount);
		Assert.assertEquals(linkCount,21);
		log.info("Main Page Link count Asserted Successfully");
	}
	
	@Test(priority=9)
	public void countLinkIFrame() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,550)");
		driver.switchTo().frame("iframe-name");
		lp.getFrameSearchBox().sendKeys("Amit Arora");
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linkCount = links.size();
		log.info("Total Links in the Frame counted : "+linkCount);
		Assert.assertEquals(linkCount,25);
		log.info("Frame Link count Asserted Successfully");
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
}
