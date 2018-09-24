package edu.practise.packagename;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestNgDemo {
	
	@Test (alwaysRun=true)
	public void method1() {
		System.out.println("method1 printed");
	}

	@Test(priority =4, dependsOnMethods = "method1")
	public void method2() {
		System.out.println("method2 printed");
	}
	@Test (priority =1)
	public void method3() {
		System.out.println("method3 printed");

	}

	@Test(priority =3)
	public void method4() {
		System.out.println("method4 printed");
	}
	
	@Test(priority =2)
	public void method5() {
		System.out.println("method5 printed");
	}

}
