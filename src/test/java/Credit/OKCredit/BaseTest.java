package Credit.OKCredit;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import Credit.OKCredit.Utils.ExtentManager;
import cucumber.api.java.After;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class BaseTest 
{
	public WebDriver driver;
	public ExtentReports rep = ExtentManager.getInstance();
	public ExtentTest test;
	public AndroidDriver<AndroidElement> dr;
	public void launchApp() throws InterruptedException
	{
		
		//service=startServer();

		File app=new File(System.getProperty("user.dir")+"//apk//okcredit.apk");
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability("deviceName","Redmi");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","9");
		capabilities.setCapability("autoGrantPermissions", "true");
		capabilities.setCapability("appPackage","in.okcredit.merchant");
		capabilities.setCapability("appActivity", "in.okcredit.app.ui.launcher.LauncherActivity");
		capabilities.setCapability("app",app.getAbsolutePath());

		try
		{
	    dr=new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
		//dr=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:"+port+"/wd/hub"),capabilities);
		dr.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
		
		
		
	}
	
	//return the available port in machine
	public String getPort() throws IOException

	{
		ServerSocket socket = new ServerSocket(0);
		socket.setReuseAddress(true);
		String port = Integer.toString(socket.getLocalPort()); 
		socket.close();
		return port;
	}

	
}
	
	
	


