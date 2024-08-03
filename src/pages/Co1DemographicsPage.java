package pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Functions;

public class Co1DemographicsPage {
	private WebDriver driver;
	private Functions functions = new Functions();
	
	private By co1LstNm = By.cssSelector("#txtLastName_Co-1");
	private By co1FrstNm = By.cssSelector("#txtFirstName_Co-1");
	private By co1SuffixDD = By.cssSelector("//input[@id='selectSuffix_Co-1']//parent::span");
	private By co1SuffixList = By.cssSelector("#selectSuffix_Co-1_listbox li");
	private By co1MidNm = By.cssSelector("#txtMiddle_Co-1");
	private By co1PrefixDD = By.xpath("//input[@id='selectPrefix_Co-1']//parent::span");
	private By co1PrefixList = By.cssSelector("#selectPrefix_Co-1_listbox li");
	private By co1DOB = By.cssSelector("#datePickBirtDate_Co-1_formatted");
	private By co1HomePhn = By.cssSelector("#txtHomePhone_Co-1");
	private By co1Email = By.cssSelector("#txtPriEmail_Co-1");
	private By co1WorkingStatusDD = By.xpath("//input[@id='selectWorkingStatus_Co-1']//parent::span");
	private By co1WorkingStatusList = By.cssSelector("#selectWorkingStatus_Co-1_listbox li");
	private By co1EmplTypeDD = By.xpath("//input[@id='selectEmployeeType_Co-1']//parent::span");
	private By co1EmpTypeList = By.cssSelector("#selectEmployeeType_Co-1_listbox li");
	private By co1AddLn1 = By.cssSelector("#txtAddrLine1_Co-1");
	private By co1AddLn2 = By.cssSelector("#txtAddrLine2_Co-1");
	private By co1City = By.cssSelector("#txtCity_Co-1");
	private By co1StateDD = By.xpath("//input[@id='ddlState_Co-1']//parent::span");
	private By co1StateList = By.cssSelector("#ddlState_Co-1_listbox li");
	private By co1ZIP = By.cssSelector("#txtZipCode_Co-1");
	private By co1YearsAtAdd = By.cssSelector("#txtAddrYear_Co-1");
	private By co1MnthsAtAdd = By.cssSelector("#txtAddrMonths_Co-1");
	private By co1AddStatusDD = By.xpath("//input[@id='selectAddrStatus_Co-1']//parent::span");
	private By co1AddStatusList = By.cssSelector("#selectAddrStatus_Co-1_listbox li");
	private By co1EmpmntTypeDD = By.xpath("//input[@id='selectEmploymentType_Co-1']//parent::span");
	private By co1EmpmntTypeList = By.cssSelector("#selectEmploymentType_Co-1_listbox li");
	private By co1EmplyrNm = By.cssSelector("#txtEmployerName_Co-1");
	private By co1EmplyrAddLn1 = By.cssSelector("#txtEmpAddrLine1_Co-1");
	private By co1EmplyrAddLn2 = By.cssSelector("#txtEmpAddrLine2_Co-1");
	private By co1EmplyrCity = By.cssSelector("#txtEmpCity_Co-1");
	private By co1EmplyrStateDD = By.xpath("//input[@id='selectEmpState_Co-1']//parent::span");
	private By co1EmplyrStateList = By.cssSelector("#selectEmpState_Co-1_listbox li");
	private By co1EmplyrZIP = By.cssSelector("#txtEmpZipCode_Co-1");
	private By co1YearsAtJob = By.cssSelector("#txtEmpAddrYear_Co-1");
	private By co1MnthsAtJob = By.cssSelector("#txtEmpAddrMonths_Co-1");
	private By co1Occuptaion = By.cssSelector("#txtEmpOccupation_Co-1");
	private By co1OccTypeDD = By.xpath("//input[@id='selectEmpOccupationType_Co-1']//parent::span");
	private By co1OccTypeList = By.cssSelector("#selectEmpOccupationType_Co-1_listbox li");
	private By co1PrimaryAmt = By.cssSelector("#txtAmount_1_Co-1");
	private By saveBtn = By.cssSelector("#btnApplicationEntrySave");
	
	public Co1DemographicsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterCo1Name(String frstNm, String midNm, String lstNm) {
		functions.elementVisibleWait(driver, co1FrstNm);
		driver.findElement(co1FrstNm).sendKeys(frstNm);
		driver.findElement(co1MidNm).sendKeys(midNm);
		driver.findElement(co1LstNm).sendKeys(lstNm);
	}
	
	public void clickCo1SuffixDD() {
		functions.elementClickableWait(driver, co1SuffixDD);
		driver.findElement(co1SuffixDD).click();
	}
	
	public void selectCo1Suffix(String suffix) {
		functions.visibilityOfAllElementsWait(driver, co1SuffixList);
		List<WebElement> suffixes = driver.findElements(co1SuffixList);
		functions.selectDropDownValue(suffixes, suffix);
	}
	
	public void clickCo1PrefixDD() {
		functions.elementClickableWait(driver, co1PrefixDD);
		driver.findElement(co1PrefixDD).click();
	}
	
	public void selectCo1Prefix(String prefix) {
		functions.visibilityOfAllElementsWait(driver, co1PrefixList);
		List<WebElement> prefixes = driver.findElements(co1PrefixList);
		functions.selectDropDownValue(prefixes, prefix);
	}
	
	public void enterDOB() {
		driver.findElement(co1DOB).sendKeys("01/01/1945");
	}
	
	public void enterHomePhn(String phoneNbr) {
		functions.enterValue(driver, driver.findElement(co1HomePhn), phoneNbr);
	}
	
	public void enterEmail(String email) {
		driver.findElement(co1Email).sendKeys(email);
	}
}
