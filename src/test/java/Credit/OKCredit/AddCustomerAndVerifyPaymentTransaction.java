package Credit.OKCredit;
import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import Credit.OKCredit.Pages.OKCreditHomePage;
import Credit.OKCredit.Pages.OKCreditPaymentTransactionPage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class AddCustomerAndVerifyPaymentTransaction extends BaseTest{
	@Test
	public void Login() throws InterruptedException
	{
		launchApp();
		//test = rep.startTest("LoginTest");
		//test.log(LogStatus.INFO, "Starting the test ");
		//launchApp();
		//test.log(LogStatus.INFO, "App Launched successful");
		OKCreditHomePage page=new OKCreditHomePage(dr,test);
		page.clickOnLanguage();//Login in selecting english language.
		
		page.clickOnGetStartedBtn();
		page.enterMobileNo("9900857755","123456");//Add customers (using your name and mobile number).
		String name="sub"+RandomStringUtils.randomAlphabetic(10);
		page.CreateCustomerByAddingNameAndPhoneNumber(name);
		OKCreditPaymentTransactionPage paymentPage=new OKCreditPaymentTransactionPage(dr,test);
		paymentPage.clickAcceptPayment();
		paymentPage.addPaymentForNewCustomer("11");//Add credit or payment Transaction in giving amount with attachment or without attachment.
		Assert.assertEquals(paymentPage.getCustomerBalanceOnTxtPage().replaceAll("₹", "").trim(),"11","Customer balance is not matching");
		paymentPage.clickOnBack();
		
		//In the home page verify the added transaction amount is correct.
		Assert.assertEquals(page.getCustomerBalance().replaceAll("₹", "").trim(),"11","Customer balance is not matching");
		
		//In the home page print list of all customers and verify whether the added customer is shown or not. 
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

	}
	
	
	

}
