package pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class HomePage {
	
	AndroidDriver driver;
	public Utility util = null;
	
	public ExtentTest test;
		
	public HomePage(AndroidDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test= test;
		util= new Utility(driver);
	}

	By startUserRegristaionBtn = By.id("io.selendroid.testapp:id/startUserRegistration");
	
	public void clickOnUserRegistrationbtn() {
		util.clickOn(startUserRegristaionBtn);
		test.log(LogStatus.INFO, "Clicked on UserRegistrationBtn");
	}
	 
	public boolean checkUserRegisterBtnEnamled() {
		return util.isBtnEnabled(startUserRegristaionBtn);
	}
}
