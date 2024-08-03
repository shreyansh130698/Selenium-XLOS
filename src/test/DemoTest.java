package test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ExtentReportListener;
import pages.ApplicationEntryPage;
import pages.Co1DemographicsPage;
import pages.CustBusinessDemographicsPage;
import pages.HomePage;
import pages.TenantSelectionPage;

@Listeners(ExtentReportListener.class)
public class DemoTest extends BaseTest {

	TenantSelectionPage tsp;
	HomePage homePage;
	CustBusinessDemographicsPage custDemoPage;
	Co1DemographicsPage co1DemoPage;
	ApplicationEntryPage appEntryPage;
	
		@Test(priority = 1)
		public void login() {
			signInPage.enterUserName("shreyansh.srivastava@defisolutions.com");
			signInPage.enterPassword("Honey@13june");
			tsp = signInPage.clickSignIn();
			tsp.tenantsDropDownVisible();
		}
		
		@Test(priority = 2, dependsOnMethods = {"login"})
		public void selectTenant() throws InterruptedException {
			tsp.clickTenantsDropDown();
			tsp.selectTenant("STL");
			homePage = tsp.clickOkBtn();
		}
		
		@Test(priority = 3, dependsOnMethods = {"selectTenant"})
		public void selectDealerCustomer() throws InterruptedException {
		//Go to Credit Processing > Application Entry
		homePage.clickCreditProcessing();
		appEntryPage = homePage.clickAppEntry();
		
		//Enter Dealer, Customer, SSN
		appEntryPage.enterDealer("Stellantis TX Dlr");
		appEntryPage.clickCustomerPartyTypeDD();
		appEntryPage.selectCustomer("Business");
		appEntryPage.clickCo1PartyTypeDD();
		appEntryPage.selectCo1("Consumer");	
		appEntryPage.enterCustomerSSN("11141567368");
		appEntryPage.enterCo1SSN("66666789567");
		custDemoPage = appEntryPage.clickSaveBtn();
		}
		
		@Test(priority = 4, dependsOnMethods = {"selectDealerCustomer"}, enabled = false)
		public void enterCustomerDetails() {
		custDemoPage.enterBusinessName("SynoTech");
		custDemoPage.enterDoingBusinessAs("SynoTech");
		custDemoPage.enterBusinessPhn("6105678936");
		custDemoPage.enterAddLn1("A-12 Industrial Area");
		custDemoPage.enterZIP("99801");
		custDemoPage.enterCity("Juneau");
		custDemoPage.clickStateDD();
		custDemoPage.selectState("Alaska");
		custDemoPage.enterYearsInBs("8");
		custDemoPage.enterMonthsInBs("5");
		custDemoPage.clickBsTypeDD();
		custDemoPage.selectBusinessType("Corporation");
		custDemoPage.clickAddStatusDD();
		custDemoPage.selectAddStatus("Own");
		custDemoPage.enterCustName("Steve", "M", "Johnson");
		custDemoPage.clickCustSuffixDD();
		custDemoPage.enterSuffix("Jr.");
		custDemoPage.clickCustPrefixDD();
		custDemoPage.enterPrefix("Dr.");
		custDemoPage.enterCustDOB("12/12/1960");
		custDemoPage.enterCustHomePhn("6107654789");
		custDemoPage.clickCountryOfCitizenshipDD();
		custDemoPage.selectCntryOfCtznshp("United States of America (the)");
		custDemoPage.enterSSN("666666666");
		custDemoPage.enterCo1AddLn1("3512 Tulip");
		custDemoPage.enterCo1ZIP("99801");
		custDemoPage.enterCo1City("Juneau");
		custDemoPage.clickCo1StateDD();
		custDemoPage.selectCo1State("Alaska");
		custDemoPage.enterPrctgOwnshp("20");
		custDemoPage.enterTitle("CA");
		custDemoPage.clickcollClassDD();
		custDemoPage.selectCollClass("Luxury");
		custDemoPage.clickCollTyprDD();
		custDemoPage.selectCollType("New");
		custDemoPage.enterVIN("KMHDH4AE3UE082197");
		custDemoPage.enterMileage("12");
		custDemoPage.enterMSRP("30000");
		custDemoPage.enterInvoice("30000");
		custDemoPage.enterGrossCapCost("30000");
		custDemoPage.enterCashDown("2000");
		custDemoPage.enterRebate("5000");
		custDemoPage.enterTerm("60");
		custDemoPage.enterMoneyFactor("0.00300");
		custDemoPage.enterResidualPercentage("20");
		custDemoPage.enterSecDeposit("1000");
		custDemoPage.enterDelaerBkValue("30000");
		co1DemoPage = custDemoPage.clickSaveBtn();
		}
		
		@Test(priority = 5, dependsOnMethods = {"enterCustomerDetails"}, enabled = false)
		public void enterCo1Details() {
		co1DemoPage.enterCo1Name("Stephen", "K", "Herd");
		
	}
}
