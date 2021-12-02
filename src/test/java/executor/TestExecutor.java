package executor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import pageObjects.PractoHomePage;
import pageObjects.PractoLoginPage;
import pageObjects.PractoProfilePage;
import utility.Drivers;

public class TestExecutor {
	
	public WebDriver driver;
	
	public PractoHomePage objPractoHomePage;
	public PractoLoginPage objPractoLoginPage;
	public PractoProfilePage objPractoProfilePage;
	
	public WebDriver getDriver() throws InterruptedException {
		Drivers utilObj = new Drivers();
		driver = utilObj.OpenBrowser();
		return driver;
	}
	
	public void startTest() throws Exception {
		
		driver = getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// Initializing Page Objects for Practo application webpages
		objPractoHomePage = new PractoHomePage(driver);
		objPractoLoginPage = new PractoLoginPage(driver);
		objPractoProfilePage = new PractoProfilePage(driver);
		
		// Navigating to practo.com
		navigateToURL(Main.URL);
		System.out.println("Navigating to URL - " + Main.URL);
		
		// Click on Login / Signup Button
		objPractoHomePage.clickOnLoginButton();
		System.out.println("Login button clicked");
		
		// Enter the email ID
		objPractoLoginPage.enterEmailID(Main.propReader.getProperty("username"));
		System.out.println("Email ID - " + Main.propReader.getProperty("username") + " entered");
		
		// Enter the password
		objPractoLoginPage.enterPassword(Main.propReader.getProperty("password"));
		System.out.println("Password entered");
		
		// Click on Login button
		objPractoLoginPage.clickOnLoginButton();
		System.out.println("Login button clicked");
		
		// Get the name displayed on the profile page after login
		String actualName = objPractoProfilePage.getNameOnProfile();
		System.out.println("Actual name on profile page - " + actualName);
		
		// Get the expected name stored in properties file to verify successful login
		String expectedName = Main.propReader.getProperty("name");
		
		// Compare the two values to verify if the user was able to login successfully
		if(actualName.equals(expectedName)) {
			System.out.println("Successful Login");
			System.out.println("TEST PASSED");
		} else {
			System.out.println("Unsuccessful Login");
			System.out.println("TEST FAILED");
		}
		
		// Logout of the account
		objPractoProfilePage.logOut();
		
		// Close the browser
		driver.quit();
	}
	
	private void navigateToURL(String URL) {
		try {
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("EXCEPTION IN NAVIGATION TO URL - " + e.getMessage());
		}
	}

}
