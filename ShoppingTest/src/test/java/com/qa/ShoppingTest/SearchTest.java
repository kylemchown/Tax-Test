package com.qa.ShoppingTest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import org.junit.Test;

public class SearchTest {

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
	public void searchTest() {
		String search = "dress";
		driver.get("http://automationpractice.com/index.php");
		MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
		mainPage.search(search);
		Results results = PageFactory.initElements(driver, Results.class);
		//assertEquals(search, results.getSearchBox().getAttribute("value"));
		List<WebElement> a = driver.findElements(By.className("icon-eye-open"));
		assertTrue(a.size() > 0);
	}
	
}
