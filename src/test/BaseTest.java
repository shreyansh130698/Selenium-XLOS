package test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeClass;

import pages.OktaSignInPage;
import utilities.ExtentReportListener;
import utilities.WindowManager;

public class BaseTest {

	protected WebDriver driver;
	protected WindowManager windowManager;
	protected OktaSignInPage signInPage;
	//protected RouteOneLoginPage loginPage;
	
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		
		//driver.get("https://testint.r1dev.com/Web/BIServlet?captiveId=ROUTEONE");
		driver.get("https://losc-qa03.autolendingapps.com/csupe");
		
		//loginPage = new RouteOneLoginPage(driver);
		signInPage = new OktaSignInPage(driver);
		
		windowManager = new WindowManager();
	}
	
//	@AfterClass
//	public void closeBrowser() {
//		driver.quit();
//	}
	
	public WebDriver getDriver() {
		return driver;
	}
}