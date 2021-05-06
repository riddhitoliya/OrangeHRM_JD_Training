package com.OrangeHRM;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HDFC_FRAME_Assignment {

    WebDriver driver;

    @Test
    public void Login_Successful() {

        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        //MASKING CONCEPT -> frame used in netbanking sites - eg like shopping mall
        driver.switchTo().frame("login_page");
        driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
        //manual xpath to contniue as there are 3 continue buttons
        driver.findElement(By.xpath("//table[@class='lForm']//img")).click();
        //method findElementByXPath is used when we use chrome driver instead of webdriver
        //driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td[2]/a/img")).click();
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);


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
