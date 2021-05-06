package com.OrangeHRM.Day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OrangeHRM_Login_DataProvider extends OrangeHRM_TestData{
    ChromeDriver driver;

    @BeforeTest
    public void Launch_Browser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Launch_Browser");
    }

    @Test(dataProvider = "LoginData")
    public void Login(String uname, String password) throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        try {
            Thread.sleep(10 * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//div[@id='logInPanelHeading']")).isDisplayed();
        driver.findElement(By.id("txtUsername")).sendKeys(uname);
        driver.findElement(By.name("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        String ActURL=driver.getCurrentUrl();
        String ExpURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
        Assert.assertEquals(ActURL, ExpURL);
        Thread.sleep(2000);
        //Logout from App
        driver.findElement(By.id("welcome")).click();
        Thread.sleep(4000);
        driver.findElement(By.linkText("Logout")).click();
        String ExpURLLogin="https://opensource-demo.orangehrmlive.com/index.php/auth/login";
        String ActURLLogin=driver.getCurrentUrl();
        Assert.assertEquals(ActURLLogin, ExpURLLogin);

    }

    @AfterTest
    public void Logout() {
        driver.quit();
    }
}
