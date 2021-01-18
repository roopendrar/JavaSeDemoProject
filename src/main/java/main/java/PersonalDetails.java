package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalDetails {
	
	@FindBy(xpath="//div[contains(text(),'Date of Birth')]//following-sibling::a[@class='fs13 fw500']")
	public WebElement dob;
	
	
	@FindBy(xpath="//input[@id='pd-dateFor']")
	public WebElement date;
	
	@FindBy(xpath="//a[@data-id='pd-date_29']")
	public WebElement datepicked;
	
	@FindBy(xpath="//input[@id='pd-monthFor']")
	public WebElement month;
	
	@FindBy(xpath="//a[@data-id='pd-month_6']")
	public WebElement monthpicked;
	
	@FindBy(xpath="//input[@id='pd-yearFor']")
	public WebElement year;
	
	@FindBy(xpath="//a[@data-id='pd-year_1996']")
	public WebElement yearpicked;
	
	
	@FindBy(xpath="//label[@class='radio-lbl' and @for='gender-male']")
	public WebElement gender;
	
	
	@FindBy(id="pd-permanent-address")
	public WebElement address;
	
	@FindBy(id="pd-hometown")
	public WebElement hometown;
	
	@FindBy(id="pd-pincode")
	public WebElement pincode;
	
	@FindBy(id="pd-maritalStatusFor")
	public WebElement status;
	
	@FindBy(xpath="//a[@data-id='pd-maritalStatus_N']")
	public WebElement single;
	
	@FindBy(id="pd-categoryFor")
	public WebElement category;
	
	@FindBy(xpath="//a[@data-id='pd-category_1']")
	public WebElement general;
	
	@FindBy(id="pd-workPermitUSFor")
	public WebElement visa;
	
	@FindBy(xpath="//a[@data-id='pd-workPermitUS_2']")
	public WebElement needvisa;
	
	@FindBy(xpath="//input[ @class='srchTxt' and @id='pd-workPermitForCountryFor']")
	public WebElement countries;
	
	@FindBy(xpath="//a[@data-id='pd-workPermitForCountry_1']")
	public WebElement india;
	
	@FindBy(xpath="//a[@data-id='pd-workPermitForCountry_2']")
	public WebElement australia;
	
	@FindBy(xpath="//a[@data-id='pd-workPermitForCountry_3']")
	public WebElement baharini;
	
	@FindBy(id="add-new-language")
	public WebElement language;
	
	@FindBy(xpath="//div[@class='col s12']//preceding-sibling::a[contains(text(),'CANCEL')]")
	public WebElement cancel;
	
	/*
	 * @FindBy(xpath="//div[@class='mTxt' and contains(text(),'My Naukri')]") public
	 * WebElement mynaukari;
	 * 
	 * @FindBy(xpath="//a[@class='logout-gnb']") public WebElement logout;
	 */
	
	
	public PersonalDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}



}
