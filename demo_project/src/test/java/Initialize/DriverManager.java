package Initialize;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {

    private static WebDriver driver;

    public static WebDriver driverInit() throws InterruptedException {
        if (driver == null) {
            // Set up the ChromeDriver
            WebDriverManager.chromedriver();
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static void openBrowser() throws InterruptedException {
        driver.get("https://www.w3schools.com/html/html_tables.asp");
        Thread.sleep(3000);
    }
    

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
