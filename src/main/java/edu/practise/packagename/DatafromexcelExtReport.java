package edu.practise.packagename;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DatafromexcelExtReport extends Wrapperclass{
		
	@DataProvider(name="fetchData")
	public Object[][] getData() throws IOException{
		
		return Dataprovide.getSheet();		
	}

	
	@Test(dataProvider="fetchData")
	public void samplea( String uname, String email) throws WebDriverException, IOException {
		
		//extentrepot generation 
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/sep091320180244.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("testcase001", "testcase description");
		test.assignAuthor("OceanAcademy");
		test.assignCategory("Sanity Testing");
		
		//browser launch and maximze
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://kpntravels.in/frmUserRegistration.aspx");
		
		enterelementbyid("WebContent_txtUserId", uname);
		
		//driver.findElementById("WebContent_txtUserId").sendKeys(uname);
		
		String status= "pass";
		
		try {
			driver.findElementById("WebContent_txtMail1").sendKeys(email);
		} catch (Exception e) {
			System.out.println("Exception occured :"+ e);
			status="fail";
			
		}
		
		
		String destinationpath = "./reports/kpnsnapshot.jpeg";
		FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(destinationpath));
		
		if(status.equalsIgnoreCase("pass")) {
		
		test.pass("Testcase passed successfully", MediaEntityBuilder
				.createScreenCaptureFromPath("./../reports/kpnsnapshot.jpeg").build());
		
		}else {
			test.fail("Testcase failed", MediaEntityBuilder
				.createScreenCaptureFromPath("./../reports/kpnsnapshot.jpeg").build());
		}
		
		extent.flush();
		
		
		
		/*List<WebElement> produnames = driver.findElementsByXPath("//div[@class='a-row a-spacing-mini']//h2");
		int count = produnames.size();
		
		for(int i= 0;i<=count;i++) {
			String productname = driver.findElementByXPath("//div[@class='a-row a-spacing-mini']//h2[i]").getText();
			System.out.println(productname);
		}*/
	}

}