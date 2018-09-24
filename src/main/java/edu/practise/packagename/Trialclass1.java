package edu.practise.packagename;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Trialclass1 {
	
	@DataProvider(name= "accountdata")
	public Object[][] datamethod() {
		
		Object[][] obj = new Object[2][2];

		obj[0][0] = "ocean";
		obj[0][1] = "oceanacademy@gmail.com";
		
		obj[1][0] = "academy";
		obj[1][1] = "oa@gmail.com";
		
		return obj;
	}
	
	@Test(dataProvider="accountdata")
	public void methoda(String uname,String uemail) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://kpntravels.in/frmUserRegistration.aspx");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementById("WebContent_txtUserId").sendKeys(uname);
		driver.findElementById("WebContent_txtMail").sendKeys(uemail);
		
		


		
		
	}

}
