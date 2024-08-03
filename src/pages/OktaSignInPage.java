package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utilities.Functions;

public class OktaSignInPage {

	private WebDriver driver;
	private Functions functions = new Functions();
	private By userNameTxt = By.cssSelector("#okta-signin-username");
	private By passwordTxt = By.cssSelector("#okta-signin-password");
	private By signInBtn = By.cssSelector("#okta-signin-submit");
	
	public OktaSignInPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUserName(String username) {
		driver.findElement(userNameTxt).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordTxt).sendKeys(password);
	}
	
	public TenantSelectionPage clickSignIn() {
		driver.findElement(signInBtn).click();
		return new TenantSelectionPage(driver);
	}
}
