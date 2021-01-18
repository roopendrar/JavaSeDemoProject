package main.java;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WindowHandle {
	public  WebDriver driver;
	public void switchto(int index) {
		
		String Windowid=null;
		
		Set<String> Windowid1=driver.getWindowHandles();
		Iterator<String> itr=Windowid1.iterator();
		for(int i=1;i<=index;i++) {
			Windowid=itr.next();
		}
		
		driver.switchTo().window(Windowid);
	}

	public WindowHandle(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
