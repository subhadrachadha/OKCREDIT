package Credit.OKCredit.Pages;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.nio.charset.*;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OKCreditHomePage extends BasePage {
	WebDriver dr;

	public OKCreditHomePage(AndroidDriver aDriver, ExtentTest test) {
		super(aDriver, test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver),this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="in.okcredit.merchant:id/english")
	private  MobileElement englishBTn;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/getStarted")
	private static MobileElement getStartedBtn;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/mobile")
	private static MobileElement enterMobileEdit;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/ok")
	private static MobileElement clickOkBtn;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Password']")
	private static MobileElement enterPasswordEdit;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/btn_title")
	private static MobileElement addCustomerText;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text()='ADD CUSTOMER']")
	private static MobileElement addCustomerBtn;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/input_phone")
	private static MobileElement enterPhoneNumber;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/phone_button")
	private static MobileElement clickPhoneBtn;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/input_name")
	private static MobileElement enterName;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/name_button")
	private static MobileElement clickNameBtn;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/customerList")
	private static List<MobileElement> customerList;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/desc")
	private static List<MobileElement> customerNames;
	
	@AndroidFindBy(id="in.okcredit.merchant:id/balance")
	private static  MobileElement customerBalance;
	
	
	
	
	public void clickOnLanguage()
	{
		if(englishBTn.isDisplayed())
		{
			englishBTn.click();
		}
		
	}
	
	public void clickOnGetStartedBtn()
	{
		if(getStartedBtn.isDisplayed())
		{
			getStartedBtn.click();
		}
	}
	
	public void enterMobileNo(String mobileNo,String password) {
		if(enterMobileEdit.isDisplayed())
		{
			enterMobileEdit.click();
			enterMobileEdit.sendKeys(mobileNo);
			clickOkBtn();
			if(enterPasswordEdit.isDisplayed())
			{
				enterPasswordEdit.click();
				enterPasswordEdit.sendKeys(password);
				clickOkBtn();
			}
		}
	}
	
	public void clickOkBtn()
	{
		if(clickOkBtn.isDisplayed())
		{
			clickOkBtn.click();
		}
	}
	
	public void CreateCustomerByAddingNameAndPhoneNumber(String name)
	{
		if(addCustomerText.isDisplayed())
		{
			addCustomerText.click();
		if(enterName.isDisplayed())
			{
				enterName.click();
				enterName.sendKeys(name);
				clickNameBtn.click();
				if(enterPhoneNumber.isDisplayed())
				{
					enterPhoneNumber.click();
					enterPhoneNumber.sendKeys(generatePhoneNo());
					clickPhoneBtn.click();
				}
			}
		}
		else
		{
			System.out.println("enter name field is disabled");
		}
	}
	
	
	public String generatePhoneNo()
	{
		Random generator = new Random();
		        int num1,num2,num3;
		        num1 = 9 ; // returns random number between 0 and 7
		        num2 = generator.nextInt(999) - 2 ; // returns random number between 0 and 741
		        num3 = generator.nextInt(6000); // returns random number between 0 and 9999
		        String phoneNumber = String.format("%d%d%d-%03d-%04d", num1, num1, num1, num2, num3);
		        System.out.println(phoneNumber);
		        return phoneNumber;
	}
	
	
	public List getCustomerNamesOnHomePage()
	{
		return customerNames;
	}
	
	public void verifyAddNewCustomerBtn()
	{
		if(addCustomerBtn.isDisplayed())
		{
			System.out.println("Create New Customer");
		}
		else
		{
			System.out.println("button is disable");
		}
	}
	
	
	public String getCustomerBalance()
	{
		return customerBalance.getText();
	}
	
	
	
	
}
		
  