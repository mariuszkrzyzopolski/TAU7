package cwCztery;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class testLogin {
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

    @AfterEach
    public void logout(){
        driver.get("https://www.worldanvil.com/logout");
    }

    @Test
    public void checkLogin(){
        driver.get("https://www.worldanvil.com/login");
        driver.findElement(By.id("username")).sendKeys("m92686260");;
        driver.findElement(By.id("password")).sendKeys("V5xKLbQ3A9sutwN");
        driver.findElement(By.id("_submit")).click();
        assertEquals("Your Global Dashboard | World Anvil",driver.getTitle());
    }

    @Test
    public void checkLoginBadPassword(){
        driver.get("https://www.worldanvil.com/login");
        driver.findElement(By.id("username")).sendKeys("m92686260");;
        driver.findElement(By.id("password")).sendKeys("something");
        driver.findElement(By.id("_submit")).click();
        assertEquals("Login | Welcome to World Anvil | World Anvil",driver.getTitle());
    }

}
