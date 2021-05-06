package com.OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFC_LOGIN_Assignment {

    ChromeDriver driver;

    @Test
    public void Login_Successful() throws InterruptedException {
        driver.navigate().to("https://netbanking.hdfcbank.com/netbanking/");
        Thread.sleep(10000);
        driver.switchTo().frame("login_page");
        driver.findElementByXPath("//table[@class='lForm']//img").click();

        String expAlert = "Customer ID  cannot be left blank.";
        String actAlert = driver.switchTo().alert().getText();
        Assert.assertEquals(expAlert, actAlert);
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }

    @Before
    public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void ClosBrowser() {
        driver.quit();
    }

}
