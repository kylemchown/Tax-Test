package com.qa.MouseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Accordian {
	
	@FindBy(id = "ui-id-6")
	private WebElement item2;
	
	@FindBy(id = "ui-id-7")
	private WebElement textbox2;
	
	public WebElement getTextbox2() {
		return textbox2;
	}

	public void select2() {
		item2.click();
	}
	
}
