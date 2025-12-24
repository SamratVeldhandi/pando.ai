package TestCases;

import BaseTest.BaseTest1;
import PageObjects.SinglePage;

import Utilities.ExcelUtility;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class TC001 extends BaseTest1 {
    @Test(priority = 1,groups = "sanity")
    public void test1()  {
        SinglePage page = new SinglePage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ExcelUtility data = new ExcelUtility(".//TestData//Book1.xlsx","sheet2");
        String username = data.getCellData(1,0);
        String email = data.getCellData(1,1);
        page.setName(username);
        page.setEmail(email);
        page.setPhone("568787827");
        page.setAddress("Karimnagar");
    }
    @Test(priority = 2,groups = "smoke")
    public void test2() throws IOException {
        SinglePage page = new SinglePage(driver);
        page.checkBrokenLink();
        page.setInput("hi how are you");
    }


}
