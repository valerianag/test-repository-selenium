import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
/**
  + * Created by User16_06_03 on 18.04.2017.
  + */

public class Test2 {
    private WebDriver driver;
    private WebDriverWait wait;

             @Before
             public void start() {
                 driver = new ChromeDriver();
                 wait = new WebDriverWait(driver, 10);
             }

                       @Test
                       public void testFirst() throws InterruptedException {
                       driver.get("http://localhost/litecart/public_html/en/");
                       driver.findElement(By.name("email")).sendKeys("mewohonur@doanart.com");
                       driver.findElement(By.name("password")).sendKeys("Test!1703");
                       driver.findElement(By.name("login")).click();
                       Thread.sleep(5000);

                       }

    
                       @After
                       public void stop() {
                 driver.quit();
                 driver = null;
            }
 }
