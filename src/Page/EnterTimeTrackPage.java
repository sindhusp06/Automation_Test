package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;



public class EnterTimeTrackPage {
	
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;
	
	@FindBy(linkText="About your actiTIME")
	private WebElement aboutyouractitime ;
	
	@FindBy(xpath="//span[starts_with[.,'actiTIME')")
	private WebElement version ;
	
	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logoutBTN;
	
	public EnterTimeTrackPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	}
	public void clickHelp()
	{
		help.click();
	}
	public void clickAboutyouractiTIME()
	{
		aboutyouractitime.click();
	}
	
	public void Verifyversion(String eVersion)
	{
		String aVersion=version.getText();
		Assert.assertEquals(eVersion, aVersion);
	}
	public void clickclose()
	{
		closeBTN.click();
	}
	public void clickLogout()
	{
		logoutBTN.click();
	}
	public void verifyTitle(WebDriver driver,String eTitle)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		try
		{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Home Page is displayed" ,true);
		}
		catch(Exception e) 
		{
			Reporter.log("Home Page is NOT displayed" ,true);
			Assert.fail();
		}
		
	}
	
	
	
	
	
	
}