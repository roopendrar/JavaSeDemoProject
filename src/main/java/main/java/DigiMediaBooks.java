package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DigiMediaBooks {
	@FindBy(xpath="//ul[@id='zg_browseRoot']//a[text()='Programming & Software Development']")
	public WebElement programming;
	
	public DigiMediaBooks(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
