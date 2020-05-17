package stepDefinations;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.runner.RunWith;
import org.testng.Assert;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import Credit.OKCredit.BaseTest;
import Credit.OKCredit.Pages.OKCreditHomePage;
import Credit.OKCredit.Pages.OKCreditPaymentTransactionPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;


@RunWith(Cucumber.class)
public class stepDefination extends BaseTest{
	@Given("^Launch the okcredit app$")
	public void launch_the_okcredit_app() throws Throwable {
		test = rep.startTest("LogintoOKCredit");
		launchApp();
		test.log(LogStatus.INFO, "App Launched successfully ");
	}

	@Given("^Select the english language$")
	public void select_the_english_language() throws Throwable {
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		page.clickOnLanguage();
		test.log(LogStatus.INFO, "Clicked on English Language");
		
	    
	}

	@Given("^click on english language to land on okcredit login page$")
	public void click_on_english_language_to_land_on_okcredit_login_page() throws Throwable {
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		page.clickOnGetStartedBtn();
		test.log(LogStatus.INFO, "Clicked on Tab Icon successfully ");
	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\" and click on ok$")
	public void user_enters_and_and_click_on_ok(String arg1, String arg2) throws Throwable {
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		page.enterMobileNo(arg1,arg2);
	}

	@Then("^Verify that user is successfuly logged in and land on home screen$")
	public void verify_that_user_is_successfuly_logged_in_and_land_on_home_screen() throws Throwable {
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		String name="sub"+RandomStringUtils.randomAlphabetic(10);
		page.CreateCustomerByAddingNameAndPhoneNumber(name);
		OKCreditPaymentTransactionPage paymentPage=new OKCreditPaymentTransactionPage(dr,test);
		paymentPage.clickOnBack();
		List<MobileElement> customerNames=page.getCustomerNamesOnHomePage();
		Iterator<MobileElement> allCustomerName=customerNames.iterator();
		boolean flag=false;
			while(allCustomerName.hasNext())
			{
				String customerName=allCustomerName.next().getText();
				System.out.println("customerName==="+customerName);
				if(customerName.equalsIgnoreCase(name)) 
				{
					flag=true;
				}
			}	
			
			if(!flag) {
				Assert.assertTrue(false,"Customer Name is not present in the list");
	         }
			
			((AppiumDriver)dr).quit(); 
	}
	
	
	   
}
