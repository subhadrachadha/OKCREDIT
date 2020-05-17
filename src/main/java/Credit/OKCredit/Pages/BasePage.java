package Credit.OKCredit.Pages;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * Hello world!
 *
 */
public class BasePage 
{
    public AndroidDriver<AndroidElement> aDriver;
    public ExtentTest test;
    public BasePage(AndroidDriver aDriver,ExtentTest test)
    {
    	PageFactory.initElements(new AppiumFieldDecorator(aDriver),this);
    	this.aDriver=aDriver;
    	this.test=test;
    }
}
