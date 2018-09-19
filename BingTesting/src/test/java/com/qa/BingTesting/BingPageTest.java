package com.qa.BingTesting;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BingPageTest {

	WebDriver driver;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	
	@Test
	public void bingSearch() {
		driver.get("https://www.bing.com/");
		BingTesting page = PageFactory.initElements(driver, BingTesting.class);
		page.searchFor("selenium");
		WebElement checkElement = driver.findElement(By.id("sb_form_q"));
		assertEquals("selenium", checkElement.getAttribute("value"));
	}
	
	@After
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
