package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Programming {
	@FindBy(xpath="//ul[@id='zg_browseRoot']//a[text()='Software Design, Testing & Engineering']")
	public WebElement testing;
	
	public Programming(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


}
