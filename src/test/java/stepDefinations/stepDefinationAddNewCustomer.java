package stepDefinations;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.runner.RunWith;
import org.testng.Assert;
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
public class stepDefinationAddNewCustomer extends BaseTest{
	
	@Given("^Add New customer button must be displayed$")
	public void add_New_customer_button_must_be_displayed() throws Throwable {
		launchApp();
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		page.clickOnLanguage();
		page.clickOnGetStartedBtn();
		page.enterMobileNo("9900857755","123456");
		//page.verifyAddNewCustomerBtn();
	}


	@When("^user enters name and phonenumber and click on ok$")
	public void user_enters_name_and_phonenumber_and_click_on_ok() throws Throwable {
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		String name="sub"+RandomStringUtils.randomAlphabetic(10);
		page.CreateCustomerByAddingNameAndPhoneNumber(name);
		OKCreditPaymentTransactionPage paymentPage=new OKCreditPaymentTransactionPage(dr,test);
		paymentPage.clickOnBack();
	}

	@Then("^verify customer added and displayed on home screen$")
	public void verify_customer_added_and_displayed_on_home_screen() throws Throwable {
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		String name="sub"+RandomStringUtils.randomAlphabetic(10);
		page.CreateCustomerByAddingNameAndPhoneNumber(name);
		OKCreditPaymentTransactionPage paymentPage=new OKCreditPaymentTransactionPage(dr,test);
		paymentPage.clickOnBack();
		Thread.sleep(1000);
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
