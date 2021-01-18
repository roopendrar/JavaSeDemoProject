package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mobile {
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'Realme Narzo 20 (Victory Blue, 4GB RAM, 128GB Storage)')]")
	public WebElement realeme;
	
	@FindBy(xpath="//button[@id='a-autoid-10-announce']")
	public WebElement storage;
	
	@FindBy(xpath="//a[@id='wishListMainButton-announce']")
	public WebElement wishlist;
	
	@FindBy(xpath="//input[@id='ap_email']")
	public WebElement WLlogin;
	
	@FindBy(xpath="//input[@id='continue']")
	public WebElement WLcontinue;
	
	@FindBy(xpath="//input[@id='ap_password']")
	public WebElement Wlpassword;
	
	@FindBy(xpath="//input[@id='signInSubmit']")
	public WebElement wlsignin;
	
	@FindBy(xpath="//p[@class='a-spacing-top-mini']")
	public WebElement wlnumbertext;
	
	@FindBy(xpath="//span[@id='wl-redesigned-create-list']//preceding-sibling::input[@class='a-button-input a-declarative']")
	public WebElement createlist;
	
	@FindBy(xpath="//span[@id='wl-huc-title-holder']")
	public WebElement wishtext;
	
	@FindBy(xpath="//button[contains(text(),'Continue shopping')]")
	public WebElement shopping;
	
	
	
	public Mobile(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
