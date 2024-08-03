package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import test.BaseTest;

public class ExtentReportListener implements ITestListener{
	private static ExtentReports extent;
	public static ThreadLocal<ExtentTest> test = new ThreadLocal();
	private WebDriver driver;
	
	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		Object currentClass = result.getInstance();
		driver = ((BaseTest)currentClass).getDriver();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
		String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
		try {
			test.get().addScreenCaptureFromPath(screenshotPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*ITestContext context;
		ITestNGMethod[] testMethods = context.getAllTestMethods();
		for(ITestNGMethod method: testMethods) {
			String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
			try {
				test.get().addScreenCaptureFromPath(screenshotPath);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}*/
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		test.get().fail(result.getThrowable());
		String screenshotPath = captureScreenshot(result.getMethod().getMethodName());
		try {
			test.get().addScreenCaptureFromPath(screenshotPath);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip("Test Skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}
	
	
	private String captureScreenshot(String methodName){
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" +methodName +"_" +dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		}catch(IOException e) {
			e.printStackTrace();
		}
		return destination;
	}
}
