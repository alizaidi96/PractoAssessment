package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserActions;

public class PractoProfilePage {
	
	WebDriver driver = null;

    BrowserActions browserAction = null;
    
    public PractoProfilePage(WebDriver driver) {
    	this.driver = driver;
    	
    	PageFactory.initElements(driver, this);
    	
    	browserAction = new BrowserActions(driver);
    }
    
    /** *-*-*-*-* PRACTO HOME PAGE OBJECTS *-*-*-*-* */
    
    // Name field
    @FindBy(how = How.XPATH, using = "(//span[@class='user_info_top'])[2]")
    private WebElement name;
    
    // Logout button
    @FindBy(how = How.XPATH, using = "(//a[@class='nav-interact logout-click'])[2]")
    private WebElement logout;
    
    
    /** *-*-*-*-* PRACTO HOME PAGE METHODS *-*-*-*-*/
	
    // Click on Login / Signup button
    public String getNameOnProfile() throws Exception {
    	try {
    		return browserAction.getText(name);
    	} catch(Exception e) {
    		throw e;
    	}
    }
    
    // Logout
    public void logOut() throws Exception {
    	try {
    		browserAction.click(name);
    		browserAction.click(logout);
    	} catch (Exception e) {
			throw e;
		}
    }

}
