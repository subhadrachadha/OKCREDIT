package Credit.OKCredit.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class OKCreditPaymentTransactionPage extends BasePage {
	WebDriver dr;

	public OKCreditPaymentTransactionPage(AndroidDriver aDriver, ExtentTest test) {
		super(aDriver, test);
		dr = aDriver;

	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ACCEPT\n" + "PAYMENT']")
	private static MobileElement acceptPayment;
	
	@AndroidFindBy(xpath="com.android.documentsui:id/action_menu_open[@text='OPEN']")
	private static MobileElement clickOpen;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='GIVE\n" + "CREDIT']")
	private static MobileElement givePayment;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text()='Add Payment']")
	private static MobileElement addPayment;

	@AndroidFindBy(id = "in.okcredit.merchant:id/btn_one")
	private static MobileElement addCreditText;

	@AndroidFindBy(id = "in.okcredit.merchant:id/bottom_container_text")
	private static MobileElement addNote;

	@AndroidFindBy(id = "in.okcredit.merchant:id/bottom_container_right_icon")
	// "in.okcredit.merchant:id/bottom_container_right_icon")
	private static MobileElement takeImage;

	@AndroidFindBy(id = "in.okcredit.merchant:id/gallery")
	private static MobileElement takeGalleryPhoto;

	@AndroidFindBy(id = "in.okcredit.merchant:id/btn_allow")
	private static MobileElement btnAllow;

	@AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector()).scrollIntoView(text(”ALLOW\"));")
	// "com.android.packageinstaller:id/permission_allow_button")
	private static MobileElement allowbtn;

	@AndroidFindBy(id ="in.okcredit.merchant:id/btn_submit")
	private static MobileElement submitBtn;
	
	@AndroidFindBy(xpath ="//android.widget.ImageButton[@index=0]")
	private static MobileElement backBtn;
	
	@AndroidFindBy(id ="in.okcredit.merchant:id/tx_amount")
	private static MobileElement customerBalanceInTxt;
	

	
	
	public void clickAcceptPayment() {
		if (acceptPayment.isDisplayed()) {
			acceptPayment.click();

		}
	}

	public void addPaymentForNewCustomer(String amount) throws InterruptedException
	{
		if (addCreditText.isDisplayed()) {
			addCreditText.click();
			addCreditText.setValue(amount);
			// addCreditText.submit();
			if (addNote.isDisplayed()) {
				addNote.click();
				addNote.sendKeys("attach");
				submitBtn.click();	
			}
		} 

	}
	
	public void clickOnBack() {
		backBtn.click();
	}
	
	public String getCustomerBalanceOnTxtPage() {
		return customerBalanceInTxt.getText();
	}
	
	
	
	private By By(MobileElement takeImage2) {
		// TODO Auto-generated method stub
		return null;
	}

}
