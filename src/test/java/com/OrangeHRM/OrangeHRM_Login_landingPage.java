package com.OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM_Login_landingPage {

    WebDriver driver;

    @Test
    public void Login_Successful() {

        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        String ExpResult = "Dashboard";
        String ActResult = driver.findElement(By.linkText("Dashboard")).getText();
        Assert.assertEquals(ExpResult,ActResult);

               // driver.getCurrentUrl();

        //driver.close();
    }

    @Before
    public void LaunchBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public void ClosBrowser() {
        driver.quit();
    }

}
