package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import executor.Main;

public class Drivers {
	
	public WebDriver driver;

    public String driverBasepath = Main.PROJECT_PATH + "/GridFiles/drivers/";
    
    public WebDriver OpenBrowser() {
    	
    	System.setProperty("webdriver.chrome.driver", driverBasepath + "chromedriver.exe");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        
        return driver;
    	
    }

}
