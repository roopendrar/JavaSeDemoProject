package test.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import main.java.NaukariHome;
import main.java.NaukariLogin;
import main.java.PersonalDetails;
import resources.java.ReadExcel;

public class NaukariTestClass {
	public WebDriver driver;
	List<String> testData = new ArrayList<String>();
	ExtentHtmlReporter htmlreports=new ExtentHtmlReporter("C:\\Users\\acer\\eclipse-workspace\\DemoProject\\HtmlReports\\TestClassreport2.html");
	ExtentReports extent=new ExtentReports();

	
	@BeforeMethod()
	public void setup() throws IOException {
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\acer\\eclipse-workspace\\DemoProject\\src\\main\\java\\resources\\java\\amazon.properties");
		property.load(fis);
		System.setProperty("webdriver.chrome.driver",property.getProperty("Driver"));
		driver = new ChromeDriver();
		String naukari = property.getProperty("naukari");
		driver.get(naukari);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void naukarisignin() throws IOException, InterruptedException {
		ReadExcel dataObj = new ReadExcel();
		testData = dataObj.readData();
		NaukariLogin naukarilogin=new NaukariLogin(driver);
		NaukariHome naukarihome=new NaukariHome(driver);
		PersonalDetails details=new PersonalDetails(driver);
		
		extent.attachReporter(htmlreports);
		ExtentTest test=extent.createTest("adding personal details");
		
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(naukarilogin.loginbutton));
		naukarilogin.loginbutton.click();
		
		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOf(naukarilogin.username));
		naukarilogin.username.sendKeys(testData.get(1));
		naukarilogin.password.sendKeys(testData.get(2));
		naukarilogin.login.click();
		
		
		WebDriverWait wait2 = new WebDriverWait(driver, 90);
		wait2.until(ExpectedConditions.visibilityOf(naukarihome.chatbot));
		naukarihome.chatbot.click();
		
		WebDriverWait wait21 = new WebDriverWait(driver, 60);
		wait21.until(ExpectedConditions.visibilityOf(naukarihome.updateprofile));
		naukarihome.updateprofile.click();
		
		WebDriverWait wait22 = new WebDriverWait(driver, 60);
		wait22.until(ExpectedConditions.visibilityOf(naukarihome.details));
		naukarihome.details.click();
		
		
		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.visibilityOf(details.dob));
		details.dob.click();
		
		WebDriverWait wait31 = new WebDriverWait(driver, 60);
		wait31.until(ExpectedConditions.visibilityOf(details.date));
		details.date.click();
		details.datepicked.click();
		details.month.click();
		details.monthpicked.click();
		details.year.click();
		details.yearpicked.click();
		details.gender.click();
		details.address.sendKeys(testData.get(3));
		details.hometown.sendKeys(testData.get(4));
		details.pincode.sendKeys(testData.get(5));
		details.status.click();
		details.single.click();
		details.category.click();
		details.general.click();
		details.visa.click();
		details.needvisa.click();
		/*
		 * details.countries.click(); details.india.click(); details.australia.click();
		 * details.baharini.click(); details.language.click();
		 */
		Thread.sleep(3000);
		WebDriverWait wait32 = new WebDriverWait(driver, 60);
		wait32.until(ExpectedConditions.visibilityOf(details.cancel));
		details.cancel.click();
		
		test.log(Status.INFO, "details added successfully");
		extent.flush();
		
		
		
		
	}
	@AfterMethod()
	public void close() {
		driver.close();
	}


}
