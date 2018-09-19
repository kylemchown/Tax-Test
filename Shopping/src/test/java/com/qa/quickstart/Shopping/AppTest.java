package com.qa.quickstart.Shopping;


import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;

public class AppTest {
	
	WebDriver driver;

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		driver.quit();
	}
	
	  @Test
	  public void testUntitledTestCase() throws Exception {
	    driver.get("http://automationpractice.com/index.php");
	    driver.findElement(By.id("search_query_top")).click();
	    driver.findElement(By.id("search_query_top")).clear();
	    driver.findElement(By.id("search_query_top")).sendKeys("dress");
	    driver.findElement(By.id("searchbox")).submit();
	    results = driver.findElement(By.)
	    assertEquals("Printed Summer Dress", driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText());
		  }
	}