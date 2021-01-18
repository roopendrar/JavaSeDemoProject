package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NaukariHome {
	
	@FindBy(xpath="//div[@class='crossIcon chatBot chatBot-ic-cross']")
	public WebElement chatbot;
	
	@FindBy(xpath="//div[@class='btn btn-block btn-large white-text']")
	public WebElement updateprofile;
	
	@FindBy(xpath="//span[@class='text' and contains (text(),'Personal Details')]")
	public WebElement details;
	
	
	public NaukariHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
