package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class LoginPageTestCases extends base {
	
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
	
	@Test(dataProvider="getData",priority=9)
	public void invalidCredsTextVerification(String username, String password) throws InterruptedException, IOException
	{
		lp.getSigninLink().click();
		WebDriverWait wt = new WebDriverWait(driver,5);
		wt.until(ExpectedConditions.visibilityOf(login.getEmailBox()));
		login.getEmailBox().sendKeys(username);
		log.info("email entered for user");
		login.getPasswordBox().sendKeys(password);
		log.info("password entered for user");
		login.getSubmitButton().click();
		wt.until(ExpectedConditions.visibilityOf(login.getTextDisplayBox()));
		String rcvd = login.getTextDisplayBox().getText();
		Assert.assertEquals(rcvd, "Your username or password is invalid. Please try again.");
		log.info("Invalid Creds Text Asserted Successfully");
	}
	
	@Test(dependsOnMethods={"invalidCredsTextVerification"})
	public void intentionalFailure()
	{
		String rcvd = login.getForgotPasswordLink().getText();
		Assert.assertEquals(rcvd, "Forgot Password");
		log.info("Forgot Password Link Text Asserted Successfully");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[2][2];
		
		data[0][0] = "amit.arora@gmail.com";
		data[0][1] = "12345";
		
		data[1][0] = "ram.sharma@gmail.com";
		data[1][1] = "12345";
		
		return data;
	}

}
