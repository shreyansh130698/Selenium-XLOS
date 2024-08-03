package utilities;

import org.openqa.selenium.WebDriver;

public class WindowManager {
	
	private WebDriver driver;
	
	public void goBack() {
		driver.navigate().back();
	}
	
	public void goForward() {
		driver.navigate().forward();
	}
	
	public void refresh() {
		driver.navigate().refresh();
	}
	
	public void goTo(String url) {
		driver.navigate().to(url);
	}
	
	public void switchTo(String tabTitle) {
		var windows = driver.getWindowHandles();
		for(String window:windows) {
			driver.switchTo().window(window);
			if(tabTitle.equals(driver.getTitle()))
				break;
		}
	}

}
