package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
	public WebDriver driver;
	
	By emailBox = By.cssSelector("input[placeholder='Email Address']");
	By passwordBox = By.cssSelector("input[placeholder='Password']");
	By submitButton = By.cssSelector("input[type='submit']");
    By textDisplayBox = By.xpath("//form[@role='form']/div[1]/span[1]");
    By forgotPassword = By.cssSelector("a[href*='reset']");
	
	public loginPage(WebDriver driver)
    {
		this.driver = driver;
	}

	public WebElement getEmailBox()
	{
		return driver.findElement(emailBox);
	}
	
	public WebElement getPasswordBox()
	{
		return driver.findElement(passwordBox);
	}
	
	public WebElement getSubmitButton()
	{
		return driver.findElement(submitButton);
	}
	
	public WebElement getTextDisplayBox()
	{
		return driver.findElement(textDisplayBox);
	}
	
	public WebElement getForgotPasswordLink()
	{
		return driver.findElement(forgotPassword);
	}

}
