package com.qa.ShoppingTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class MainPage {

	@FindBy(id = "search_query_top")
	private WebElement searchBox;
	
	public void search(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
		
	}
	
}
