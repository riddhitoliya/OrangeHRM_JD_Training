package FifthMay;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestNG {
    @Test
    public void dummy() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
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
}
