import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by User16_06_03 on 18.04.2017.
 */
public class testFirst {

   private WebDriver driver;
   private WebDriverWait wait;

   @Before
    public void start() {
       driver = new ChromeDriver();
       wait = new WebDriverWait(driver, 10);
   }

   @Test
    public void testFirst() {
              driver.get("http://www.google.com/");
              driver.findElement(By.name("q")).sendKeys("webdriver");
              driver.findElement(By.name("btnG")).click();
              wait.until(titleIs("webdriver - Поиск в Google"));
   }



       @After
               public void stop() {
           driver.quit();
           driver = null;
       }
   }

