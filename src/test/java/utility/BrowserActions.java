package utility;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserActions {
	
	public WebDriver driver;

    public WebDriverWait wait;
    
    public BrowserActions(WebDriver driver) {
        this.driver = driver;
    }
    
    // Click on Web Element
    public void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            System.err.println("Exception in click - " + e.getLocalizedMessage());
        }
    }
    
    // Set Text of Web element
    public void setText(WebElement element, String value) {
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    // Get text of Web element
    public String getText(WebElement element) {
        String elementText = null;

        try {
            elementText = element.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return elementText;
    }
    
    // Get any attribute of a web element
    public String getAttribute(WebElement element, String value) {
    	
    	String attributeValue = "";
    	try {
    		
    		attributeValue = element.getAttribute(value);
    		
    	} catch (Exception e) {
			e.printStackTrace();
		}
    	
    	return attributeValue;
    }

}
