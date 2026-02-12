package testScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import insurEdgeHomepage.HomePage;
import projectConfig.BrowserConfig;

public class FooterSectionHyperLinkValidation {
	BrowserConfig config=null;
	WebDriver driver=null;
	HomePage page1=null;
	WebDriverWait wait=null;
	@BeforeClass
	public void browserSetup()
	{
		config=new BrowserConfig();
	}
	@BeforeMethod
	@Parameters("browser")
	public void setUpBrowserType(String browser)
	{
		config.setBrowser(browser);
		driver=config.getBrowser();
		config.navigateToWebsite("https://qeaskillhub.cognizant.com/LoginPage");
		config.setWait();
		wait=config.getWait();
		page1=new HomePage(driver,wait);
		page1.login();
	}
	@Test
	public void performValidationOfHyperLink()
	{
		String msg=page1.performActionsOnFooterSectionHyperLink();
		Assert.assertEquals(msg, "Hyperlink present", "HyperLink redirects to correct credits page");
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	

}
