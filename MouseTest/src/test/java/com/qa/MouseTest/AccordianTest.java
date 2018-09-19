package com.qa.MouseTest;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AccordianTest {

	WebDriver driver;
	public static ExtentReports report;
	public ExtentTest test;
	
	@BeforeClass
	public static void initial(){
		report = TestSuite.report;
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		report.endTest(test);
		driver.quit();
	}
	
	@AfterClass
	public static void aa() {
		report.flush();
	}
	
	@Test
	
	public void testAccordian() {
		test = report.startTest("Check Accordian");
		driver.get("https://web.archive.org/web/20180201043540/http://demoqa.com:80/accordion");
		test.log(LogStatus.INFO, "Start Browser");
		Accordian accord = PageFactory.initElements(driver, Accordian.class);
		accord.select2();
		test.log(LogStatus.INFO, "Attempt to Select 2nd Option");
		if(accord.getTextbox2().getAttribute("aria-hidden").equals("false")) {
			test.log(LogStatus.PASS, "Accordian expanded correctly");
		}
		else {
			test.log(LogStatus.FAIL, "Accordian did not expanded correctly");
		}
		assertTrue(accord.getTextbox2().getAttribute("aria-hidden").equals("false"));
	}
}