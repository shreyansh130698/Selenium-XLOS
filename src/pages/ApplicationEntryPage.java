package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Functions;

public class ApplicationEntryPage {

	private WebDriver driver;
	private Functions functions = new Functions();
	private By dealerNbrTxt = By.xpath("//input[@id='txtDealerSearchDealerNumber']");
	private By dealerNmTxt = By.xpath("//input[@id='txtDealerSearchDealerName']");
	private By customerPartTypeDD = By.xpath("//input[@id='selectPartyType_Customer'] //parent::span");
	private By customerPartyTypeList = By.cssSelector("#selectPartyType_Customer_listbox li");
	private By SSNs = By.xpath("(//input[contains(@id, 'Template_Customer_formatted')])[3]");
	private By co1PartyTypeDD = By.xpath("//input[@id='selectPartyType_Co-1']//parent::span");
	private By co1PartyTypeList = By.cssSelector("#selectPartyType_Co-1_listbox li");
	private By co1SSN = By.xpath("(//input[@id='selectPartyType_Co-1']//parent::span//parent::td//parent::tr//input)[2]");
	private By saveBtn = By.cssSelector("#btnApplicationEntrySaveContinue");
	
	public ApplicationEntryPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterDealer(String dealerNumber) {
		functions.elementClickableWait(driver, dealerNbrTxt);
		driver.findElement(dealerNmTxt).sendKeys(dealerNumber);
		driver.findElement(dealerNmTxt).sendKeys(Keys.ENTER);
	}
	
	public void clickCustomerPartyTypeDD() throws InterruptedException {
		functions.elementVisibleWait(driver, By.xpath("//span[text()='Lease']"));
		Thread.sleep(1000);
		functions.elementClickableWait(driver, customerPartTypeDD);
		driver.findElement(customerPartTypeDD).click();
		functions.elementVisibleWait(driver, customerPartyTypeList);
		Thread.sleep(1000);
	}
	
	public void selectCustomer(String customer){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> custPartyTypes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(customerPartyTypeList));
		custPartyTypes = driver.findElements(customerPartyTypeList);
		functions.selectDropDownValue(custPartyTypes, customer);
	}
	
	public void enterCustomerSSN(String SSN) {
		functions.enterText(driver, SSNs, SSN);
	}
	
	public void clickCo1PartyTypeDD() throws InterruptedException {
		functions.elementClickableWait(driver, co1PartyTypeDD);
		driver.findElement(co1PartyTypeDD).click();
		Thread.sleep(1000);
	}
	
	public void selectCo1(String co1) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> co1PartyTypes = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(co1PartyTypeList));
		co1PartyTypes = driver.findElements(co1PartyTypeList);
		functions.selectDropDownValue(co1PartyTypes, co1);
	}
	
	public void enterCo1SSN(String SSN) {
		functions.enterText(driver, co1SSN, SSN);
	}
	
	public CustBusinessDemographicsPage clickSaveBtn() {
		functions.elementClickableWait(driver, saveBtn);
		driver.findElement(saveBtn).click();
		return new CustBusinessDemographicsPage(driver);
	}
}
