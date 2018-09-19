package com.qa.ShoppingTest;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class Results {
	
	@FindBy(id = "search_query_top")
	private WebElement searchBox;
	
	public void register(String text) {
		searchBox.sendKeys(text);
		searchBox.submit();
		
	}

	public WebElement getSearchBox() {
		return searchBox;
	}
	
	
}
