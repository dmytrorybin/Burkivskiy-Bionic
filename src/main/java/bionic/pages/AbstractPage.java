package bionic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by andrey on 23.02.15.
 */
public class AbstractPage {
    WebDriver driver;
    
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }
    
    protected boolean isElementPresent(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        if (elements.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    protected void waitWhenElementDisappears(By locator) {
        while (isElementPresent(locator)) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    
}