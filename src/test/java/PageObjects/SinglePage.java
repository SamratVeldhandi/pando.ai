package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public class SinglePage {
    WebDriver driver;
    public SinglePage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="name")
    WebElement name_ele;

    @FindBy(id="email")
    WebElement email_ele;

    @FindBy(id="phone")
    WebElement phoneno;

    @FindBy(id="textarea")
    WebElement address1;

    @FindBy(xpath = "//a[@href=\"http://www.deadlinkcity.com/error-page.asp?e=400\"]")
    WebElement link;

    @FindBy(xpath = "//input[@id='input1']")
    WebElement input1;



    public void setName(String name){
        name_ele.sendKeys(name);
    }

    public void setEmail(String email){
        email_ele.sendKeys(email);
    }

    public void setPhone(String phone){
        phoneno.sendKeys(phone);
    }

    public void setAddress(String address){
        address1.sendKeys(address);
    }


    public void checkBrokenLink() throws IOException {
           String linkURl = link.getAttribute("href");
           URL linkURL = new URL(linkURl);
           HttpURLConnection httpConn =
                   (HttpURLConnection) linkURL.openConnection();
           httpConn.setConnectTimeout(5000);
           httpConn.connect();

           if(httpConn.getResponseCode()>=400){
               System.out.println("Broken link");
           }else {
               System.out.println("Valid link");
           }

       }

       public void setInput(String inp1){
        input1.sendKeys(inp1);
       }
       }




