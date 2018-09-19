package com.qa.MouseTest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class DragDropTest {

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
	public void testDrop() throws InterruptedException {
		test = report.startTest("Check Drag n Drop");
		driver.get("https://web.archive.org/web/20180125234728/http://demoqa.com:80/droppable/");
		Droppable droppable = PageFactory.initElements(driver, Droppable.class);
		droppable.moveRight(driver);
		WebElement checkElement = driver.findElement(By.xpath("//*[@id=\"droppableview\"]/p"));
		if(checkElement.getText().equals("Dropped!")) {
			test.log(LogStatus.PASS, "Accordian expanded correctly");
		}
		else {
			test.log(LogStatus.FAIL, "Accordian did not expanded correctly");
		}
		assertEquals("Dropped!", checkElement.getText());
	}

}
