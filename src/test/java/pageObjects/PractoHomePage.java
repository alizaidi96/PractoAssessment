package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserActions;

public class PractoHomePage {
	
	WebDriver driver = null;

    BrowserActions browserAction = null;
    
    public PractoHomePage(WebDriver driver) {
    	this.driver = driver;
    	
    	PageFactory.initElements(driver, this);
    	
    	browserAction = new BrowserActions(driver);
    }
    
    /** *-*-*-*-* PRACTO HOME PAGE OBJECTS *-*-*-*-* */
    
    // Login / Signup button
    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Login')]")
    private WebElement loginButton;
    
    
    /** *-*-*-*-* PRACTO HOME PAGE METHODS *-*-*-*-*/
	
    // Click on Login / Signup button
    public void clickOnLoginButton() throws Exception {
    	try {
    		browserAction.click(loginButton);
    	} catch(Exception e) {
    		throw e;
    	}
    }
	
}
