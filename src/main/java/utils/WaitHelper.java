package utils;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

public class WaitHelper {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public WaitHelper(WebDriver driver, int timeOutInSeconds) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds)); 
	}
	
	//Wait until the element is visible
	public void waitforElementsToBeVisible(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	//Wait until the element is clickable
	public void waitforElementsToBeClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	//Wait until the page title is displayed
	public void waitforTitleContains(String titlePart) {
		wait.until(ExpectedConditions.titleContains(titlePart));
	}
	
	 // Scroll element into view
    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
    }
    
 

}
