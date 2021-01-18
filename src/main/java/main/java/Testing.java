package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Testing {
	@FindBy(xpath="//div[contains(text(),'Python Crash Course, 2nd Edition: A Hands-On,…')]//preceding-sibling::span")
	public WebElement python;
	
	public Testing(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
