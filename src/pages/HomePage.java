package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Functions;

public class HomePage {

	private WebDriver driver;
	private Functions functions = new Functions();
	private By creditProcessing = By.xpath("//p[text()='Credit Processing']");
	private By appSearch = By.xpath("//p[text()='Application Search']");
	private By creditAutomatedQueueReview = By.cssSelector("#AutomatedQueueReview");
	private By creditQueueSummary = By.cssSelector("#QueueSummary");
	private By creditManagerReview = By.cssSelector("#ManagerReview");
	private By appEntry = By.cssSelector("#ApplicationEntry");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickCreditProcessing() {
		functions.elementVisibleWait(driver, creditProcessing);
		driver.findElement(creditProcessing).click();
	}
	
	public ApplicationEntryPage clickAppEntry() {
		functions.elementClickableWait(driver, appEntry);
		driver.findElement(appEntry).click();
		return new ApplicationEntryPage(driver);
	}
}
