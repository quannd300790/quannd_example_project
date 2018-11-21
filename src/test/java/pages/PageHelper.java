package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumberTestNG.ThreadlocalDriver;

public class PageHelper {
	WebDriver driver = ThreadlocalDriver.getTLDriver();
	
	public void inputField(WebElement element, String info) {
		element.sendKeys(info);
	}
	
	public void clickOn(WebElement element) {
		element.click();
	}
	
	public void jsClicker(WebElement element) {
        waitFor(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
	
	public void waitFor(String xpath) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
	
	public void waitFor(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (StaleElementReferenceException e) {
            wait.ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOf(element));
        }
    }
	
}
