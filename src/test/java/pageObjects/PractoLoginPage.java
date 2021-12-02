package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utility.BrowserActions;

public class PractoLoginPage {
	
	WebDriver driver = null;

    BrowserActions browserAction = null;
    
    public PractoLoginPage(WebDriver driver) {
    	this.driver = driver;
    	
    	PageFactory.initElements(driver, this);
    	
    	browserAction = new BrowserActions(driver);
    }
    
    /** *-*-*-*-* PRACTO LOGIN PAGE OBJECTS *-*-*-*-* */
    
    // Mobile Number / Email ID text field
    @FindBy(how = How.XPATH, using = "//input[@id='username']")
    private WebElement emailID;
    
    // Password text field
    @FindBy(how = How.XPATH, using = "//input[@id='password']")
    private WebElement password;
    
    // Login button
    @FindBy(how = How.XPATH, using = "//button[@id='login']")
    private WebElement loginButton;
    
    
    /** *-*-*-*-* PRACTO LOGIN PAGE METHODS *-*-*-*-*/
	
    // Enter email ID
    public void enterEmailID(String email) throws Exception {
    	try {
    		browserAction.setText(emailID, email);
    	} catch(Exception e) {
    		throw e;
    	}
    }
    
    // Enter password
    public void enterPassword(String pass) throws Exception {
    	try {
    		browserAction.setText(password, pass);
    	} catch(Exception e) {
    		throw e;
    	}
    }
    
    // Click on login button
    public void clickOnLoginButton() throws Exception {
    	try {
    		browserAction.click(loginButton);
    	} catch(Exception e) {
    		throw e;
    	}
    }
	
}
