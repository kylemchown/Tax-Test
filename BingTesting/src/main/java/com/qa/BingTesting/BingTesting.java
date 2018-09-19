package com.qa.BingTesting;

import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;

public class BingTesting {
	
	@FindBy(id = "sb_form_q")
	private WebElement searchBox;
	
	@FindBy(id = "sb_form_go")
	private WebElement searchButton;
	
	public void searchFor(String text) {
		searchBox.sendKeys(text);
		searchButton.click();
	}
	
}
