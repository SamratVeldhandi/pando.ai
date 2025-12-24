import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class page {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("name")).sendKeys("sam");
        driver.findElement(By.id("email")).sendKeys("sam@gmail.com");
        driver.findElement(By.id("phone")).sendKeys("6654354353");
        driver.findElement(By.id("textarea")).sendKeys("Hi this is sam How are you");
        driver.findElement(By.xpath("//label[@for='female']")).click();
        List<WebElement> days = driver.findElements(By.className("form-check-input"));
        for (WebElement ele : days){
            ele.click();
        }
        WebElement ele = driver.findElement(By.id("country"));
        Select options = new Select(ele);

        options.selectByVisibleText("India");

        for (WebElement op : options.getOptions()){
            System.out.println(op.getText());
        }

        Select col = new Select(driver.findElement(By.id("colors")));
        col.selectByVisibleText("Blue");

        Select animals = new Select(driver.findElement(By.id("animals")));
        animals.selectByVisibleText("Dog");

        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.click();

        WebElement month = driver.findElement(By.xpath("//span[contains(@class,\"ui-datepicker-month\")]"));
        WebElement year = driver.findElement(By.xpath("//span[contains(@class,\"ui-datepicker-year\")]"));


        while (!(month.getText().equals("March") && year.getText().equals("2025"))){
            WebElement prev = driver.findElement(By.xpath("//a[contains(@data-handler,\"prev\")]"));
            prev.click();

            month = driver.findElement(By.xpath("//span[contains(@class,\"ui-datepicker-month\")]"));
            year = driver.findElement(By.xpath("//span[contains(@class,\"ui-datepicker-year\")]"));


        }


        WebElement date = driver.findElement(By.xpath("//a[contains(@data-date,\"12\")]"));
        date.click();

        WebElement date1 = driver.findElement(By.id("txtDate"));
        date1.click();

        WebElement monthclick = driver.findElement(By.xpath("//select[contains(@class,\"ui-datepicker-month\")]"));
        monthclick.click();

        Select mon1 = new Select(monthclick);
        mon1.selectByVisibleText("Oct");

        WebElement yearclick = driver.findElement(By.xpath("//select[contains(@class,\"ui-datepicker-year\")]"));
        yearclick.click();

        Select year1 = new Select(yearclick);
        year1.selectByVisibleText("2015");

        driver.findElement(By.xpath("//a[@data-date=\"21\"]")).click();

        WebElement startDate = driver.findElement(By.id("start-date"));
        startDate.sendKeys("28-10-2022");

        WebElement endDate = driver.findElement(By.id("end-date"));
        endDate.sendKeys("10-12-2025");

        driver.findElement(By.xpath("//button[@class=\"submit-btn\"]")).click();

        WebElement uploadsingleFile = driver.findElement(By.id("singleFileInput"));
        uploadsingleFile.sendKeys("C:/Users/GlobaL/Downloads/Resume.pdf");
        driver.findElement(By.xpath("//button[text()=\"Upload Single File\"]")).click();

        WebElement uploadmultipleFiles = driver.findElement(By.id("multipleFilesInput"));
        String file1 = "C:\\Users\\GlobaL\\Pictures\\Screenshots";
        String file2 = "C:\\Users\\GlobaL\\Downloads";

        uploadmultipleFiles.sendKeys(file1+"\n"+file2);
        driver.findElement(By.xpath("//button[text()=\"Upload Multiple Files\"]")).click();

        List<WebElement> table = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr"));
        System.out.println(table.size());

        for (int i=2;i<=table.size();i++){

            for(int j=1;j<=4;j++) {
                WebElement tabledata = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[" + i + "]/td["+j+"]"));
                System.out.print(tabledata.getText()+" ");
            }
            System.out.println();

        }

        List<WebElement> pagination = driver.findElements(By.xpath("//ul[@id=\"pagination\"]//li"));

        for (int i=1;i<=pagination.size();i++){
            driver.findElement(By.xpath("//ul[@id=\"pagination\"]//li["+i+"]//a")).click();
            Thread.sleep(1000);
            for (int j=1;j<=5;j++) {
                driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr[" + j + "]//td//input")).click();
            }

        }
        driver.findElement(By.xpath("//button[contains(@class,'st')]")).click();
//        driver.findElement(By.id("alertBtn")).click();

//        al.accept();
//        driver.findElement(By.id("confirmBtn")).click();
//        al.dismiss();
        driver.findElement(By.id("promptBtn")).click();
        Alert al = driver.switchTo().alert();
        al.sendKeys("hi sam");
        al.accept();
        WebElement text =  driver.findElement(By.id("demo"));
        if(text.getText().equals("Hello hi sam! How are you today?")){
            System.out.println("Test passed");
        }else{
            System.out.println("Test failed");
        }

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement ele1 = driver.findElement(By.xpath("//button[@class='dropbtn']"));
        js.executeScript("arguments[0].scrollIntoView(true)",ele1);
        Actions ac = new Actions(driver);
        ac.moveToElement(ele1).perform();
        driver.findElement(By.xpath("//a[text()='Mobiles']")).click();
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        WebElement doubleclick = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction1()\"]"));
        ac.doubleClick(doubleclick).perform();
        WebElement draggable = driver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        ac.dragAndDrop(draggable,droppable).perform();

    }
}
