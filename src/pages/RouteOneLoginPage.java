package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import test.BaseTest;
import utilities.Functions;

public class RouteOneLoginPage{

	private WebDriver driver;
	private By routeOneFrame = By.id("RouteOneFrame");
	private By usernNameTxt = By.id("j_username"); 
	private By passwordTxt = By.id("j_password");
	private By loginBtn = By.xpath("//button[text()='Log In']");
	Functions functions = new Functions();
	
	public RouteOneLoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void login() {
		functions.switchToFrame(driver, routeOneFrame);
		functions.enterText(driver, usernNameTxt,"fiservqa2");
		functions.enterText(driver, passwordTxt,"Password79");
		//functions.click(driver, loginBtn);
		functions.switchToParentFrame(driver);
	}
}
