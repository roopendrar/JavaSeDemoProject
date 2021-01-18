package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[@data-csa-c-slot-id='nav_cs_0']")
	public WebElement bestseller;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement searchbar;
	
	@FindBy(xpath="//input[@id='nav-search-submit-button']")
	public WebElement search;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
