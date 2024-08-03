package pages;

import static org.testng.Assert.assertEquals;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Functions;

public class TenantSelectionPage {

	private WebDriver driver;
	private Functions functions = new Functions();
	private By tenantDropDown = By.xpath("//input[@id='HeaderTenantsDropdown']//parent::span");
	private By allTenants = By.cssSelector("#HeaderTenantsDropdown_listbox li");
	private By companyDropDown = By.xpath("//input[@id='HeaderCompaniesDropdown'] //parent::span");
	private By centerDropDown = By.xpath("//input[@id='HeaderCentersDropdown'] //parent::span");
	private By okBtn = By.cssSelector("#GoToNewTenant"); 
	
	public TenantSelectionPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickTenantsDropDown() {
		functions.elementVisibleWait(driver, tenantDropDown);
		driver.findElement(tenantDropDown).click();	
	}
	
	public void selectTenant(String tenant) throws InterruptedException {
		Thread.sleep(1000);
		List<WebElement> elements = driver.findElements(allTenants);
		functions.selectDropDownValue(elements, tenant);
	}
	
	public HomePage clickOkBtn() {
		functions.elementClickableWait(driver, okBtn);
		driver.findElement(okBtn).click();
		return new HomePage(driver);
	}
	
	public void tenantsDropDownVisible() {
		functions.elementVisibleWait(driver, tenantDropDown);
	}
}
