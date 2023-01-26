package cwPiec;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class testChrome {
    private static WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/geckodriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testCheckItemPrice() {
        driver.get("http://automationpractice.pl/index.php");
        driver.findElement(By.className("blockbestsellers")).click();
        driver.findElement(By.xpath("//ul[@id='blockbestsellers']/li[6]/div/div[2]/div[2]/a[2]/span")).click();
        driver.findElement(By.id("thumb_13")).click();
        driver.findElement(By.xpath("//body[@id='product']/div[2]/div/div/a")).click();
        assertEquals("$28.98",driver.findElement(By.id("our_price_display")).getText());
    }

    @Test
    public void testCheckItemByColor() {
        driver.get("http://automationpractice.pl/index.php");
        driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]/ul/li[3]/a")).click();
        driver.findElement(By.linkText("Black (1)")).click();
        driver.findElement(By.xpath("//img[@alt='Printed Summer Dress']")).click();
        driver.findElement(By.id("color_11")).click();
        assertEquals("Printed Summer Dress - My Store",driver.getTitle());
    }

    @Test
    public void testSearchBlue() {
        driver.get("http://automationpractice.pl/index.php");
        driver.findElement(By.id("search_query_top")).sendKeys("blue");
        driver.findElement(By.name("submit_search")).click();
        assertEquals(2, driver.findElements(By.className("product-container")).size());
    }
}
