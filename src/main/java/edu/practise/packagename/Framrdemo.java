package edu.practise.packagename;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Framrdemo {
	@Test
	public void framedemo() {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://jqueryui.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElementByXPath("//a[text()='Draggable']").click();
		
		WebElement dragframe = driver.findElementByClassName("demo-frame");
		driver.switchTo().frame(dragframe);
		
		String value = driver.findElementByXPath("//div[@id='draggable']/p").getText();
		System.out.println(value);
		
		driver.switchTo().defaultContent();
		driver.switchTo().parentFrame();

	}

}
