package edu.practise.packagename;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class Trial3 {

	@Test
	public void alertdemo() throws InterruptedException, AWTException, IOException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		driver.findElementByXPath("//input[@title='Sign in']").click();
		Thread.sleep(5000);
		
		Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		Robot robo = new Robot();
		BufferedImage screenFullImage = robo.createScreenCapture(screenRect);
		ImageIO.write(screenFullImage, ".jpeg", new File("printalert"));
		
		
		//String destinationpath = "./reports/alertscreenshot.jpeg";
			
		//driver.findElementByXPath("//input[@title='Sign in']").sendKeys(Keys.);
		/*try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(destinationpath));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		

	}

}
