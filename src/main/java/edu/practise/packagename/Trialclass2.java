package edu.practise.packagename;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Trialclass2 {
	@Test
	public void methodb() {
		//System.out.println("methodb is executed");
		
		try {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			RemoteWebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.irctc.co.in/nget/train-search");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement abc = driver.findElementByXPath("//p-dropdown[@id='https://www.irctc.co.in/nget/train-search']//label");
			Select trainlist = new Select(abc);
			trainlist.selectByVisibleText("Exec. Chair Car (EC)");
		} catch (Exception e) {
			System.out.println("Exception occured");
		}
		
	}

}
