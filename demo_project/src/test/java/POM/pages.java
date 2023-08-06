package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class pages {
    
    public static WebElement xPath (WebDriver driver){
        // Find all rows in the table
        WebElement rows = driver.findElement(By.xpath("//*[@id='customers']"));
        return rows;
    }

    public static WebElement table (WebDriver driver){
        WebElement table = driver.findElement(By.id("customers"));
        return table;
    }
}
