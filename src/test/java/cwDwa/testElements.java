package cwDwa;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class testElements {
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
    public void testFirstAndThirdLink() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        driver.findElement(By.xpath("//article[@id='r1-0']/div[2]/h2/a/span")).click();
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        driver.findElement(By.xpath("//article[@id='r1-2']/div[2]/h2/a/span")).click();
        assertEquals("The Witcher 3: Wild Hunt - Official Website ", driver.getTitle());
    }

    @Test
    public void testJsGet(){
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        WebElement firstLink = driver.findElement(By.xpath("//article[@id='r1-0']/div[2]/h2/a/span"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", firstLink);
        assertEquals("Wiedźmin | Oficjalna witryna Netflix", driver.getTitle());
    }

    @Test
    public void testByClassName() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        driver.findElement(By.className("LQNqh2U1kzYxREs65IJu")).click();
        assertEquals("Wiedźmin | Oficjalna witryna Netflix", driver.getTitle());
    }

    @Test
    public void testByID() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        driver.findElement(By.id("r1-0")).click();
        assertEquals("Wiedźmin | Oficjalna witryna Netflix", driver.getTitle());
    }

    @Test
    public void testByCSS() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        driver.findElement(By.cssSelector(".eVNpHGjtxRBq_gLOfGDr")).click();
        assertEquals("Wiedźmin | Oficjalna witryna Netflix", driver.getTitle());
    }

    @Test
    public void testByTag() {
        driver.get("https://duckduckgo.com/?q=witcher&atb=v345-1&ia=web");
        driver.findElement(By.tagName("h2")).click();
        assertEquals("Wiedźmin | Oficjalna witryna Netflix", driver.getTitle());
    }
}
