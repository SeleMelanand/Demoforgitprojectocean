package edu.practise.packagename;

import org.openqa.selenium.remote.RemoteWebDriver;

public class Wrapperclass {
	public RemoteWebDriver driver;
	
	public void enterelementbyid(String locatorid, String idvalue ) {
		
		try {
			driver.findElementById(locatorid).sendKeys(idvalue);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
