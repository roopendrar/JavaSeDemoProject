package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestSeller {
	@FindBy(xpath="//ul[@id='zg_browseRoot']//a[text()='Books']")
	public WebElement books;
	
	public BestSeller(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
