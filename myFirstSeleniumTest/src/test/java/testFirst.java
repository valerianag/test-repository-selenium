import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;
import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


/**
 * Created by User16_06_03 on 18.04.2017.
 */
public class testFirst {

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
        driver.get("http://localhost/litecart/admin/");

        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");

        driver.findElement(By.tagName("button")).click();

        //не нашла условия для достаточного Implicitely Wait
        Thread.sleep(5000);
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
        List<WebElement> links = driver.findElements(By.id("app-"));
        openMenu(links, driver);

        //здесь просто для наглядности
        Thread.sleep(2000);
        driver.navigate().back();

    }

    public void openMenu(List<WebElement> l, WebDriver dr) throws InterruptedException {
        List<String> text =new LinkedList();
        //лист всех менюшек
        for (int i=0; i<l.size(); i++) {
            text.add(l.get(i).getText());
        }

        //заходим в меню
        int counter=0; //сколько заголовков
        for (int i=0; i<text.size(); i++) {
            dr.findElement(By.partialLinkText(text.get(i))).click();
            List<String> txt = new LinkedList<String>();
            List<WebElement> menu = dr.findElements(By.xpath("//li[@class='selected']//span[@class='name']"));


            //ищем подменю
            for (int j=1; j<menu.size(); j++) {

                      txt.add(menu.get(j).getText());

            }
            for (int j=0; j<txt.size(); j++) {
                dr.findElement(By.partialLinkText(txt.get(j))).click();
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
               // Thread.sleep(500);
                if ((dr.findElement(By.tagName("h1")))!=null)
                    counter++;
               // driver.navigate().back();
            }

            driver.navigate().back();
        }

        System.out.println("Найдено заголовков: "+counter);
    }




    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
   }

