package edu.practise.packagename;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Datafromarray {

	@DataProvider(name = "kpnusers")
	public Object[][] dataarray() {
		Object a[][] = new Object[2][2];
		a[0][0] = "oceanacademy";
		a[0][1] = "oca@gmail.com";

		a[1][0] = "pondy";
		a[1][1] = "pondy@gmail.com";
				
		return a;

	}
	
	@Test(dataProvider ="kpnusers")
	public void kpnusercreation(String uname, String uemail) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://kpntravels.in/frmUserRegistration.aspx");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementById("WebContent_txtUserId").sendKeys(uname);
		driver.findElementById("WebContent_txtMail").sendKeys(uemail);

	}

}




