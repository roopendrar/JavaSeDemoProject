package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
	@FindBy(xpath="//input[@id='add-to-cart-button']")
	public WebElement cartbutton;
	
	
	@FindBy(xpath="//div[@id='huc-v2-order-row-center' and @class='a-row huc-v2-table-col']")
	public WebElement added;
	
	public AddtoCart(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
