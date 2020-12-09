package pages;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;

public class Utility {
	
	AndroidDriver driver;
	
		
	public Utility (AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickOn(By element) {
		driver.findElement(element).click();
	}
	
	public void enterText(By element,String text) {
		driver.findElement(element).sendKeys(text);
		
	}
	public boolean isdisplayed(By element) {
		return driver.findElement(element).isDisplayed();
	}
	
	public boolean isBtnEnabled(By element) {
		return driver.findElement(element).isEnabled();
	}
	public String getVisibleText(By element) {
		return driver.findElement(element).getText();
	}
	
	public void clearText(By element) {
		driver.findElement(element).clear();
	}
	public void hideKeyBoard(){
		driver.hideKeyboard();
	}
}
