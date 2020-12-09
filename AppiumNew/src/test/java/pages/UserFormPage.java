package pages;

import org.openqa.selenium.By;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.android.AndroidDriver;

public class UserFormPage {

AndroidDriver driver;
public ExtentTest test;

public Utility util = null;
	
	public UserFormPage(AndroidDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test= test;
		util = new Utility(driver);
	}
	By userNameTextbox = By.id("io.selendroid.testapp:id/inputUsername");
	By emailTextBox = By.id("io.selendroid.testapp:id/inputEmail");
	
	public void enterUserNameTextbox() {
		util.enterText(userNameTextbox, "Mamun");
		test.log(LogStatus.INFO, "Enter the text into username textbox");
		
	}
	public boolean verifyTheUserName() {
		return util.isdisplayed(userNameTextbox);
	}
	
	public boolean verifyEmailTextBox() {
		return util.isdisplayed(emailTextBox);
	}
	public void enterEmail() {
		util.enterText(emailTextBox, "Enter Email address");
	}
}
