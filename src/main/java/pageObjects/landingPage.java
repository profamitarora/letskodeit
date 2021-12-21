package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	
	public WebDriver driver;
	
	By radioButton = By.xpath("//input[@id='bmwradio']");
	By dropdown = By.xpath("//select[@id='carselect']");
	By newTabButton = By.xpath("//a[@id='opentab']");
	By nameBox = By.xpath("//input[@name='enter-name']");
	By alertButton = By.xpath("//input[@id='alertbtn']");
	By confirmButton = By.xpath("//input[@id='confirmbtn']");
	By webTableData = By.xpath("//div[@id='table-example-div']/div[1]/fieldset/table/tbody/tr/td");
	By textBox = By.xpath("//input[@id='enabled-example-input']");
	By enableButton = By.xpath("//input[@id='enabled-button']");
	By disableButton = By.xpath("//input[@id='disabled-button']");
	By showTextBox = By.xpath("//input[@name='show-hide']");
	By showButton = By.xpath("//input[@id='show-textbox']");
	By hideButton = By.xpath("//input[@id='hide-textbox']");
	By radioButton2 = By.xpath("//input[@id='hondaradio']");
	By mouseHoverButton = By.xpath("//button[@id='mousehover']");
	By reloadOption = By.xpath("//a[contains(text(),'Reload')]");
	By links = By.tagName("a");
	By searchBox = By.xpath("//input[@placeholder='Search Course']");
	By signinLink = By.xpath("//a[@href='/login']");
	
	public landingPage(WebDriver driver){
		
		this.driver = driver;
	}

	public WebElement getRadioButton()
	{
		return driver.findElement(radioButton);
	}

	public WebElement getDropdown()
	{
		return driver.findElement(dropdown); 	
	}
	
	public WebElement getNewTabButton()
	{
		return driver.findElement(newTabButton);
	}
	
	public WebElement getNameBox()
	{
		return driver.findElement(nameBox);
	}
	
	public WebElement getAlertButton()
	{
		return driver.findElement(alertButton);
	}
	
	public WebElement getConfirmButton()
	{
		return driver.findElement(confirmButton);
	}
	
	public List<WebElement> getWebTableData()
	{
		return driver.findElements(webTableData);
	}
	
	public WebElement getTextBox()
	{
		return driver.findElement(textBox);
	}
	
	public WebElement getEnableButton()
	{
		return driver.findElement(enableButton);
	}
	
	public WebElement getDisableButton()
	{
		return driver.findElement(disableButton);
	}
	
	public WebElement getShowTextBox()
	{
		return driver.findElement(showTextBox);
	}
	
	public WebElement getShowButton()
	{
		return driver.findElement(showButton);
	}
	
	public WebElement getHideButton()
	{
		return driver.findElement(hideButton);
	}
	
	public WebElement getRadioButton2()
	{
		return driver.findElement(radioButton2);
	}
	
	public WebElement getMouseHoverButton()
	{
		return driver.findElement(mouseHoverButton);
	}
	
	public WebElement getReloadOption()
	{
		return driver.findElement(reloadOption);
	}
	
	public List<WebElement> getMainPageLinks()
	{
		return driver.findElements(links);
	}
	
	public WebElement getFrameSearchBox()
	{
		return driver.findElement(searchBox);
	}
	
	public WebElement getSigninLink()
	{
		return driver.findElement(signinLink);
	}
}
