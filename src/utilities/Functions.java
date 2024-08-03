package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {
	
	//Function to enter text in input box
	public void enterText(WebDriver driver, By locator, String value) {
		Actions actions = new Actions(driver);
		actions.sendKeys(driver.findElement(locator), value).build().perform();
	}
	
	public void enterValue(WebDriver driver, WebElement element, String str) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;	
		jse.executeScript("arguments[0].value='"+ str +"';", element);
	}
	
	//Function to click an element
	public void click(WebDriver driver, By locator) {
		driver.findElement(locator).click();
	}
	
	//FUnction to switch to a frame
	public void switchToFrame(WebDriver driver, By frame) {
		driver.switchTo().frame(driver.findElement(frame));
	}
	
	//Function to switch to parent frame
	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	
	//Function to select drop down value
	public void selectDropDownValue(List<WebElement> values, String valueToBeSelected) {
		for(WebElement value:values) {
			if(value.getText().equals(valueToBeSelected)) {
				value.click();
				break;
			}			
		}
	}
	
	//Function to wait for a web element
	public void elementVisibleWait(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	//Function to wait for an element to be clickable
	public void elementClickableWait(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void visibilityOfAllElementsWait(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	//Function for scrollToElement
	public void scrollToElement(WebDriver driver, By locator) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", locator);
	}
	
	//Function to show Alert
	public void showAletrt(WebDriver driver, String message) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("alert('message');");
	}
}
