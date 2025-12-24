package BaseTest;

import freemarker.ext.beans.DefaultMemberAccessPolicy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;


public class BaseTest1 {
    public WebDriver driver;
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {
        if(browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }else if(browser.equalsIgnoreCase("edge")){
            driver = new EdgeDriver();
        }
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
    }



}
