package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukariLogin {
	@FindBy(xpath="//div[@class='mTxt' and contains(text(),'Login')]")
	public WebElement loginbutton;
	
	@FindBy(xpath="//label[@class='label']//following-sibling::input[@placeholder='Enter your active Email ID / Username']")
	public WebElement username;
	
	@FindBy(xpath="//label[@class='label']//following-sibling::input[@placeholder='Enter your password']")
	public WebElement password;
	
	
	@FindBy(xpath="//button[contains(text(),'Login') and @class='btn-primary loginButton']")
	public WebElement login;
	
	public NaukariLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
