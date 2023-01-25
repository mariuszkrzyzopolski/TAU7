package cwTrzy;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class testCountElements {
    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        EdgeOptions options = new EdgeOptions();
        options.setHeadless(true);
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/geckodriver");
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testGetNumberOfLinks() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        Assertions.assertTrue(links.size()>30);
    }

    @Test
    public void testGetNumberOfImages() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        List<WebElement> links = driver.findElements(By.xpath("//img"));
        Assertions.assertTrue(links.size()>10);
    }

    @Test
    public void testCrawlLinks() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        List<WebElement> links = driver.findElements(By.xpath("//a"));
        for (int i = 0; i <= links.size(); i++) {
            if(!(links.get(i).getText().isEmpty()))
            {
                links.get(i).click();
                driver.navigate().back();
                links=driver.findElements(By.tagName("a"));
            }
        }
        Assertions.assertTrue(links.size()>20);
    }

    @Test
    public void testForms() {

        driver.get("https://github.com/");
        List<WebElement> form = driver.findElements(By.xpath("//input[@type='text']"));
        assertEquals(1, form.size());

    }
}
