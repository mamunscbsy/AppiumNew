package test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;
import net.bytebuddy.asm.Advice.Enter;
import pages.HomePage;
import pages.UserFormPage;

import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;

public class AndroidTest {
	
	 AndroidDriver driver;
	 
	 public static ExtentTest test;
	 public static ExtentReports reports;
	
  @Test
  public void testCase_1() {
	  test = reports.startTest("Verify Home Page");
	  
	  HomePage homePage = new HomePage(driver, test);
	   UserFormPage userformpage = new UserFormPage(driver, test);
	   
	   if(homePage.checkUserRegisterBtnEnamled()) {
		   System.out.println("User register Btn is enabled");
		   test.log(LogStatus.PASS, "User register Btn is enabled");
	   }else {
		   System.out.println("User register Btn is disabled");
		   test.log(LogStatus.FAIL, "User register Btn is disabled");
	   }
	   
	   
  }
  
  @Test
  public void testCase_2() {
	  test = reports.startTest("Enter UserNameTextBox");
	  
	  HomePage homePage = new HomePage(driver, test);
	   UserFormPage userformpage = new UserFormPage(driver, test);
	    
	   
	   homePage.clickOnUserRegistrationbtn();
	   if(userformpage.verifyTheUserName()) {
		   test.log(LogStatus.PASS, "Verrify UserName Textbox ");
		   userformpage.enterUserNameTextbox();
	   }else {
		   test.log(LogStatus.FAIL, "UserName Textbox not displayed");
	   }
	   
	   
  }
  @Test
  public void testCase_3() {
	  test = reports.startTest("Verify Email address");
	  
	  HomePage homePage = new HomePage(driver, test);
	   UserFormPage userformpage = new UserFormPage(driver, test);
	      
	   
	   if(userformpage.verifyEmailTextBox()) {
		   test.log(LogStatus.PASS, "Verrify Email Textbox ");
		 
	   }else {
		   test.log(LogStatus.FAIL, "Email Textbox not displayed");
	   }
	   
	   
  }
  
  @Test
  public void testCase_4() {
	  //initialize the test
	  test = reports.startTest("Enter Email address");
	  
	  HomePage homePage = new HomePage(driver, test);
	  UserFormPage userformpage = new UserFormPage(driver, test);
	  
	  
	  if(userformpage.verifyEmailTextBox()) {
		   test.log(LogStatus.PASS, "Enter Email Textbox");
		 
	   }else {
		   test.log(LogStatus.FAIL, "Email Textbox not entered");
	   }   
  }
  @BeforeSuite
  public void beforeSuite() throws MalformedURLException, InterruptedException {
	//Set the device capabilities
		 DesiredCapabilities capabilities = new DesiredCapabilities();
		 capabilities.setCapability("deviceName", "Pixel API 27");
		 capabilities.setCapability("platformVersion", "8");
		 capabilities.setCapability("UDID", "emulator-5554");
		 capabilities.setCapability("platformName", "Android");
		 capabilities.setCapability("appPackage", "io.selendroid.testapp");
		 capabilities.setCapability("appActivity", "io.selendroid.testapp.HomeScreenActivity");
		 capabilities.setCapability("automationName", "UiAutomator2");
		 
		 // Initialize the android driver
		 
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		 reports = new ExtentReports("C:\\Users\\mamun\\Selenium\\AppiumNew\\Reports\\extentreports.html");
		 driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		 Thread.sleep(10000);
			 
	}
  

  @AfterSuite
  public void closeBrowser() {
	  driver.quit();
	  reports.endTest(test);
	  reports.flush();
  }

}
