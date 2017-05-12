import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by User16_06_03 on 28.04.2017.
 */
public class Task11 {

    private WebDriver driver;
    private WebDriverWait wait;



    @Before
    public void start() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver( options );
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testFirst() throws InterruptedException {
        String name = "email@seleniumtask.ru";
        String pass = "123456";
        driver.get("http://localhost/litecart/en/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        driver.findElement(By.partialLinkText("New customers click here")).click();
        driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys("username");
        driver.findElement(By.xpath(".//input[@name='address1']")).sendKeys("address");

        driver.findElement(By.xpath(".//input[@class='form-control' and @name='password']")).sendKeys(pass);
        driver.findElement(By.xpath(".//input[@name='confirmed_password']")).sendKeys("123456");
        driver.findElement(By.xpath(".//input[@name='lastname']")).sendKeys("lastname");

      //  driver.findElement(By.xpath(".//select[@name='country_code']")).click();
      //  driver.findElement(By.xpath(".//option[@value='AX']")).click();
        new Select(driver.findElement(By.xpath(".//select[@name='country_code']"))).selectByVisibleText("United States");



        driver.findElement(By.xpath(".//div[@class='form-group col-md-halfs required']//input[@name='email']")).sendKeys(name);
        driver.findElement(By.xpath(".//div[@class='form-group col-md-halfs required']//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath(".//button[@value='Create Account']")).click();



        driver.findElement(By.partialLinkText("Logout")).click();


        driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(name);
        driver.findElement(By.xpath(".//input[@name='password']")).sendKeys(pass);
        driver.findElement(By.xpath(".//button[@value='Sign In']")).click();



        driver.findElement(By.partialLinkText("Logout")).click();

    }





    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
