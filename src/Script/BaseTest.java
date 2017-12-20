package Script;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;

import Generic.AUL;
import Generic.IAutoConst;

public class BaseTest implements IAutoConst
{
	public static WebDriver driver;
	static
		{
			System.setProperty("CHROME_KEY", "CHROME_VALUE");
			System.setProperty("GECKO_KEY", "GECKO_VALUE");		
		}
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("browser")
	public void OpenApplication(String browser) throws FileNotFoundException, IOException 
	{
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();		
		}
		else
		{
			driver=new FirefoxDriver();
		}
	 String URL=AUL.getProperty(SETTINGS_PATH,"URL");
	 driver.get(URL);
	 driver.manage().window().maximize();
	 String strITO=AUL.getProperty(SETTINGS_PATH,"ITO");
	 Long ITO=Long.parseLong(strITO);
	 driver.manage().timeouts().implicitlyWait(ITO,TimeUnit.SECONDS);

	}

	@AfterMethod(alwaysRun=true)
	public void CloseApplication(ITestResult res)
	{
		String testName=res.getName();
		if(res.getStatus()==2)
		{
			AUL.getPhoto(driver, PHOTO_PATH, testName);
		}
		driver.quit();
	}	
}
