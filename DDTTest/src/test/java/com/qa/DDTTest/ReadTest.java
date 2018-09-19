package com.qa.DDTTest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.MouseTest.Accordian;
import com.qa.DemoTest.Login;
import com.qa.DemoTest.Signup;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReadTest {

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
	public void readTest() {
		test = report.startTest("Check Read from Excel");
		driver.get(Constants.url1);
		Login login = PageFactory.initElements(driver, Login.class);
		Signup signup = PageFactory.initElements(driver, Signup.class);
		
		FileInputStream file = null;
		try {
			file = new FileInputStream (Constants.folderPath + Constants.fileName);
		}
		catch (FileNotFoundException e){}
		
		XSSFWorkbook workbook = null;
		
		try {
			workbook = new XSSFWorkbook(file);
		}
		catch(IOException e) {}
		XSSFSheet sheet = workbook.getSheetAt(0);
		int num = 0;
		for (Row i : sheet) {
			String username = i.getCell(0).getStringCellValue();
			String password = i.getCell(1).getStringCellValue();
			num++;		
			test.log(LogStatus.INFO, "Username: " + username + "  Password: " + password);
			signup.register(username,password);
			login.log(username,password);
			WebElement checkElement = driver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b"));
			if (checkElement.getText().equals("**Successful Login**")) {
				test.log(LogStatus.PASS, "Combination " + num + " successfully logged in correctly");
			}
			else {
				test.log(LogStatus.FAIL, "Combination " + num + " did not successfully log in");
			}
			
			assertEquals("**Successful Login**", checkElement.getText());
			
			driver.get(Constants.url1);
		}
	}

}
