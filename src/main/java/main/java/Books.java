package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Books {
	@FindBy(xpath="//a[contains(text(),'Computing, Internet & Digital Media')]")
	public WebElement digimediaBooks;
	
	public Books(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
