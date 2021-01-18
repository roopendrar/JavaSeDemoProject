package test.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import main.java.AddtoCart;
import main.java.BestSeller;
import main.java.Books;
import main.java.DigiMediaBooks;
import main.java.HomePage;
import main.java.Mobile;
import main.java.Programming;
import main.java.Testing;
import resources.java.ReadExcel;

public class TestClass {
	public WebDriver driver;
	List<String> testData = new ArrayList<String>();
	ExtentHtmlReporter htmlreports = new ExtentHtmlReporter(
			"C:\\Users\\acer\\eclipse-workspace\\DemoProject\\HtmlReports\\TestClassreport.html");
	ExtentReports extent = new ExtentReports();

	@BeforeMethod()
	public void setup() throws IOException {
		Properties property = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\acer\\eclipse-workspace\\DemoProject\\src\\main\\java\\resources\\java\\amazon.properties");
		property.load(fis);
		System.setProperty("webdriver.chrome.driver", property.getProperty("Driver"));
		driver = new ChromeDriver();
		String url = property.getProperty("url");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@Test(dependsOnMethods = { "mobishopping" }, priority = 2, enabled = true)
	public void order() throws IOException, InterruptedException {
		HomePage homepage = new HomePage(driver);
		BestSeller seller = new BestSeller(driver);
		Books books = new Books(driver);
		DigiMediaBooks dmbook = new DigiMediaBooks(driver);
		Programming prog = new Programming(driver);
		Testing test = new Testing(driver);
		AddtoCart cart = new AddtoCart(driver);

		extent.attachReporter(htmlreports);
		ExtentTest logger = extent.createTest("add a book to cart");

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(homepage.bestseller));
		homepage.bestseller.click();
		seller.books.click();

		WebDriverWait wait1 = new WebDriverWait(driver, 60);
		wait1.until(ExpectedConditions.visibilityOf(books.digimediaBooks));
		books.digimediaBooks.click();
		dmbook.programming.click();
		prog.testing.click();
		test.python.click();

		WebDriverWait wait2 = new WebDriverWait(driver, 60);
		wait2.until(ExpectedConditions.visibilityOf(cart.cartbutton));
		cart.cartbutton.click();

		WebDriverWait wait3 = new WebDriverWait(driver, 60);
		wait3.until(ExpectedConditions.visibilityOf(cart.added));
		String success = cart.added.getText();
		Assert.assertEquals(success, cart.added.getText());
		System.out.println(success);
		logger.log(Status.INFO, "Book added to cart successfully");
		extent.flush();

	}

	@Test(priority = 1, enabled = true)
	public void mobishopping() throws IOException {
		ReadExcel dataObj = new ReadExcel();
		testData = dataObj.readData();
		HomePage homepage = new HomePage(driver);
		Mobile mobile = new Mobile(driver);
		// WindowHandle wh=new WindowHandle(driver);
		extent.attachReporter(htmlreports);
		ExtentTest logger = extent.createTest("add a mobile to wishlist");

		homepage.searchbar.sendKeys(testData.get(0));
		homepage.search.click();
		mobile.realeme.click();
		/*
		 * wh.switchto(2); System.out.println(driver.getTitle());
		 */
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();

		while (iterator.hasNext()) {

			String child_window = iterator.next();
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				WebDriverWait wait3 = new WebDriverWait(driver, 60);
				wait3.until(ExpectedConditions.visibilityOf(mobile.storage));
				mobile.storage.click();

				WebDriverWait wait31 = new WebDriverWait(driver, 60);
				wait31.until(ExpectedConditions.visibilityOf(mobile.wishlist));
				mobile.wishlist.click();

				WebDriverWait wait32 = new WebDriverWait(driver, 60);
				wait32.until(ExpectedConditions.visibilityOf(mobile.WLlogin));
				mobile.WLlogin.sendKeys(testData.get(1));
				mobile.WLcontinue.click();
				WebDriverWait wait33 = new WebDriverWait(driver, 60);
				wait33.until(ExpectedConditions.visibilityOf(mobile.Wlpassword));
				mobile.Wlpassword.sendKeys(testData.get(2));
				mobile.wlsignin.click();
				WebDriverWait wait34 = new WebDriverWait(driver, 60);
				wait34.until(ExpectedConditions.visibilityOf(mobile.wlnumbertext));
				String numbertext = mobile.wlnumbertext.getText();
				Assert.assertEquals(numbertext, mobile.wlnumbertext.getText());
				System.out.println(numbertext);
				/*
				 * mobile.createlist.click();
				 * 
				 * 
				 * String text=mobile.wishtext.getText(); System.out.println(text);
				 * mobile.shopping.click();
				 */
				
				logger.log(Status.INFO, "mobile added to wishlist successfully");
				extent.flush();
				driver.close();
			}
		}
	}

	@AfterMethod()
	public void close() {
		driver.close();
	}

}
