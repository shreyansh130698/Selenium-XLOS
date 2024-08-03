package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utilities.Functions;

public class CustBusinessDemographicsPage {

	private WebDriver driver;
	private Functions functions = new Functions();
	private By businessNmTxt = By.cssSelector("#txtBusinessName_Customer");
	private By businessAsTxt = By.cssSelector("#txtBusinessAs_Customer");
	private By businessPhnTxt = By.cssSelector("#txtBusinessPhone_Customer");
	private By businessAddLn1Txt = By.cssSelector("#txtAddrLine1_Customer");
	private By businessAddLn2Txt = By.cssSelector("#txtAddrLine2_Customer");
	private By custCity = By.cssSelector("#txtCity_Customer");
	private By custStateDD = By.xpath("//input[@id='selectBusinessState_Customer']//parent::span");
	private By custStateList = By.cssSelector("#selectBusinessState_Customer_listbox li");
	private By businessZIP = By.cssSelector("#txtZipCode_Customer");
	private By addStatusDD = By.xpath("//input[@id='selectBusinessAddrStatus_Customer']//parent::span");
	private By addStatusList = By.cssSelector("#selectBusinessAddrStatus_Customer_listbox li");
	private By businessTypeDD = By.xpath("//input[@id='selectBusinessType_Customer']//parent::span");
	private By businessTypeDDList = By.cssSelector("#selectBusinessType_Customer_listbox li");
	private By yearsInBusiness = By.cssSelector("#txtBusinessYear_Customer_formatted");
	private By monthsInBusiness = By.cssSelector("#txtBusinessMonths_Customer_formatted");
	private By custLastNmTxt = By.cssSelector("#txtLastName_CM_Customer");
	private By custSuffixDD = By.xpath("//input[@id='selectSuffix_CM_Customer']//parent::span");
	private By custSuffixList = By.cssSelector("#selectSuffix_CM_Customer_listbox li");
	private By custFirstNmTxt = By.cssSelector("#txtFirstName_CM_Customer");
	private By custMidNmTxt = By.cssSelector("#txtMiddle_CM_Customer");
	private By custPrefixDD = By.xpath("//input[@id='selectPrefix_CM_Customer']//parent::span");
	private By custPrefixList = By.cssSelector("#selectPrefix_CM_Customer_listbox li");
	private By custDOB = By.cssSelector("#birthdate_CM_Customer");
	private By custSSN = By.cssSelector("#txtSSN_CM_Customer_formatted");
	private By cntryOfCtznDD = By.xpath("//input[@id='selectCountyCitizenship_CM_Customer']//parent::span");
	private By cntryOfCtznList = By.cssSelector("#selectCountyCitizenship_CM_Customer_listbox li");
	private By custHomePhn = By.cssSelector("#txtHomePhone_CM_Customer");
	private By pctgOwnr = By.xpath("//input[@id='txtPercentOwnership_CM_Customer']//parent::span/input");
	private By co1Title = By.cssSelector("#txtBusinessTitle_CM_Customer");
	private By co1AddLn1 = By.cssSelector("#txtPreAddrLine1_CM_Customer");
	private By co1City = By.cssSelector("#txtPreCity_CM_Customer");
	private By co1ZIP = By.cssSelector("#txtPreZipCode_CM_Customer");
	private By co1StateDD = By.xpath("//input[@id='selectState_CM_Customer']//parent::span");
	private By co1StateList = By.cssSelector("#selectState_CM_Customer_listbox li");
	private By collateralClassDD = By.xpath("//input[@id='selectCollateralClass']//parent::span");
	private By collateralClassList = By.cssSelector("#selectCollateralClass_listbox li");
	private By collateralTypeDD = By.xpath("//input[@id='selectCollateralType']//parent::span");
	private By collateralTypeList = By.cssSelector("#selectCollateralType_listbox li");
	private By VIN = By.cssSelector("#txtVIN");
	private By mileage = By.cssSelector("#txtMileage_formatted");
	private By MSRP = By.cssSelector("#totalContractMSRP_formatted");
	private By Invoice = By.cssSelector("#txtContractInvoice_formatted");
	private By grossCapCost = By.cssSelector("#txtContractSellPrice_formatted");
	private By cashDown = By.cssSelector("#txtContractCashDown_formatted");
	private By rebate = By.cssSelector("#txtContractRebate_formatted");
	private By term = By.cssSelector("#txtContractTerm_formatted");
	private By moneyFactor = By.cssSelector("#txtContractMoneyFactor_formatted");
	private By residualPerctg = By.cssSelector("#txtContractResidualPercentage_formatted");
	private By secDeposit = By.cssSelector("#txtSecurityDeposit_formatted");
	private By dlrBkValue = By.cssSelector("#txtContractDlrBookValue_formatted");
	private By saveBtn = By.cssSelector("#btnApplicationEntrySaveContinue");
	
	public CustBusinessDemographicsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterBusinessName(String businessName) {
		functions.elementVisibleWait(driver, businessNmTxt);
		driver.findElement(businessNmTxt).sendKeys(businessName);
	}
	
	public void enterDoingBusinessAs(String business) {
		driver.findElement(businessAsTxt).sendKeys(business);
	}
	
	public void enterBusinessPhn(String phn) {
		functions.enterValue(driver, driver.findElement(By.cssSelector("#txtBusinessPhone_Customer")), phn);
	}
	
	public void enterAddLn1(String addLn1) {
		driver.findElement(businessAddLn1Txt).sendKeys(addLn1);
	}
	
	public void enterZIP(String ZIP) {
		functions.enterValue(driver, driver.findElement(businessZIP), ZIP);
	}
	
	public void enterCity(String city) {
		driver.findElement(custCity).sendKeys(city);
	}
	
	public void clickStateDD() {
		functions.elementClickableWait(driver, custStateDD);
		driver.findElement(custStateDD).click();
	}
	
	public void selectState(String state) {
		functions.visibilityOfAllElementsWait(driver, custStateList);
		List<WebElement> states = driver.findElements(custStateList);
		functions.selectDropDownValue(states, state);
	}
	
	public void enterYearsInBs(String years) {
		functions.elementClickableWait(driver, yearsInBusiness);
		driver.findElement(yearsInBusiness).sendKeys(years);
	}
	
	public void enterMonthsInBs(String months) {
		driver.findElement(monthsInBusiness).sendKeys(months);
	}
	
	public void clickBsTypeDD() {
		functions.elementClickableWait(driver, businessTypeDD);
		driver.findElement(businessTypeDD).click();
	}
	
	public void selectBusinessType(String businessType) {
		functions.visibilityOfAllElementsWait(driver, businessTypeDDList);
		List<WebElement> BsTypes = driver.findElements(businessTypeDDList);
		functions.selectDropDownValue(BsTypes, businessType);
	}
	
	public void clickAddStatusDD() {
		functions.elementClickableWait(driver, addStatusDD);
		driver.findElement(addStatusDD).click();
	}
	
	public void selectAddStatus(String addStatus) {
		functions.visibilityOfAllElementsWait(driver, addStatusList);
		List<WebElement> addStatuses = driver.findElements(addStatusList);
		functions.selectDropDownValue(addStatuses, addStatus);
	}
	
	public void enterCustName(String firstNm, String midNm, String lstNm) {
		functions.elementVisibleWait(driver, custFirstNmTxt);
		driver.findElement(custFirstNmTxt).sendKeys(firstNm);
		driver.findElement(custMidNmTxt).sendKeys(midNm);
		driver.findElement(custLastNmTxt).sendKeys(lstNm);
	}
	
	public void clickCustSuffixDD() {
		functions.elementClickableWait(driver, custSuffixDD);
		driver.findElement(custSuffixDD).click();
	}
	
	public void enterSuffix(String suffix) {
		functions.visibilityOfAllElementsWait(driver, custSuffixList);
		List<WebElement> suffixes = driver.findElements(custSuffixList);
		functions.selectDropDownValue(suffixes, suffix);
	}
	
	public void clickCustPrefixDD() {
		functions.elementClickableWait(driver, custPrefixDD);
		driver.findElement(custPrefixDD).click();
	}
	
	public void enterPrefix(String prefix) {
		functions.visibilityOfAllElementsWait(driver, custPrefixList);
		List<WebElement> prefixes = driver.findElements(custPrefixList);
		functions.selectDropDownValue(prefixes, prefix);
	}
	
	public void enterCustDOB(String dob) {
		driver.findElement(custDOB).sendKeys(dob);
	}
	
	public void enterCustHomePhn(String phnNbr) {
		functions.enterValue(driver, driver.findElement(custHomePhn), phnNbr);
	}
	
	public void clickCountryOfCitizenshipDD() {
		driver.findElement(cntryOfCtznDD).click();
	}
	
	public void selectCntryOfCtznshp(String country) {
		functions.visibilityOfAllElementsWait(driver, cntryOfCtznList);
		List<WebElement> countries = driver.findElements(cntryOfCtznList);
		functions.selectDropDownValue(countries, country);
	}
	
	public void enterSSN(String SSN) {
		functions.enterValue(driver, driver.findElement(custSSN), SSN);
	}
	
	public void enterCo1AddLn1(String addLn1) {
		driver.findElement(co1AddLn1).sendKeys(addLn1);
	}
	
	public void enterCo1ZIP(String ZIP) {
		functions.enterValue(driver, driver.findElement(co1ZIP), ZIP);
	}
	
	public void enterCo1City(String city) {
		driver.findElement(co1City).sendKeys(city);
	} 
	
	public void clickCo1StateDD() {
		functions.elementClickableWait(driver, co1StateDD);
		driver.findElement(co1StateDD).click();
	}
	
	public void selectCo1State(String state) {
		functions.visibilityOfAllElementsWait(driver, co1StateList);
		List<WebElement> states = driver.findElements(co1StateList);
		functions.selectDropDownValue(states, state);
	}
	
	public void enterPrctgOwnshp(String ownershipPrctg) {
		driver.findElement(pctgOwnr).sendKeys(ownershipPrctg);
	}
	
	public void enterTitle(String title) {
		driver.findElement(co1Title).sendKeys(title);
	}
	
	public void clickcollClassDD() {
		functions.elementClickableWait(driver, collateralClassDD);
		driver.findElement(collateralClassDD).click();
	}
	
	public void selectCollClass(String collClass) {
		functions.visibilityOfAllElementsWait(driver, collateralClassList);
		List<WebElement> allClass = driver.findElements(collateralClassList);
		functions.selectDropDownValue(allClass, collClass);
	}
	
	public void clickCollTyprDD() {
		driver.findElement(collateralTypeDD).click();
	}
	
	public void selectCollType(String type) {
		functions.visibilityOfAllElementsWait(driver, collateralTypeList);
		List<WebElement> allTypes = driver.findElements(collateralTypeList);
		functions.selectDropDownValue(allTypes, type);
	}
	
	public void enterVIN(String vehicleVIN) {
		driver.findElement(VIN).sendKeys(vehicleVIN);
	}
	
	public void enterMileage(String mlg) {
		driver.findElement(mileage).sendKeys(mlg);
	}
	
	public void enterMSRP(String vehMSRP) {
		driver.findElement(MSRP).sendKeys(vehMSRP);
	}
	
	public void enterInvoice(String invc) {
		driver.findElement(Invoice).sendKeys(invc);
	}
	
	public void enterGrossCapCost(String grsCapCost) {
		driver.findElement(grossCapCost).sendKeys(grsCapCost);
	}
	
	public void enterCashDown(String cd) {
		driver.findElement(cashDown).sendKeys(cd);
	}
	
	public void enterRebate(String rbt) {
		driver.findElement(rebate).sendKeys(rbt);
	}
	
	public void enterTerm(String trm) {
		driver.findElement(term).sendKeys(trm);
	}
	
	public void enterMoneyFactor(String mnyFactor) {
		driver.findElement(moneyFactor).sendKeys(mnyFactor);
	}
	
	public void enterResidualPercentage(String resPerctg) {
		driver.findElement(residualPerctg).sendKeys(resPerctg);
	}
	
	public void enterSecDeposit(String securityDeposit) {
		driver.findElement(secDeposit).sendKeys(securityDeposit);
	}
	
	public void enterDelaerBkValue(String dlrValue) {
		driver.findElement(dlrBkValue).sendKeys(dlrValue);
	}
	
	public Co1DemographicsPage clickSaveBtn() {
		driver.findElement(saveBtn).click();
		return new Co1DemographicsPage(driver);
	}
}
