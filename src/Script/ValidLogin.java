package Script;

import org.testng.annotations.Test;

import Generic.AUL;
import Page.EnterTimeTrackPage;
import Page.LoginPage;

public class ValidLogin extends BaseTest {
	@Test(priority=1 ,groups= {"Login","smoke"})
	public void testvalidLogin()
	{
		String un=AUL.getCellValue(XL_PATH,"ValidLogin", 1, 0);
		String pw=AUL.getCellValue(XL_PATH,"ValidLogin", 1, 1);
		String eTitle=AUL.getCellValue(XL_PATH,"ValidLogin", 1, 2);
	
	//Enter valid username
	LoginPage L=new LoginPage(driver);
	L.setUserName(un);
	//Enter valid password
	L.setPassword(pw);
	//Click on Login
	L.clickLogin();
	//Verify Home Page displayed 
	EnterTimeTrackPage E=new EnterTimeTrackPage(driver);
	E.verifyTitle(driver, eTitle);
}
}
