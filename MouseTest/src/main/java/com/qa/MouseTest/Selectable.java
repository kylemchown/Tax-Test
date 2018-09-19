package com.qa.MouseTest;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Selectable {
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[1]")
	private WebElement option1;
	
	@FindBy(xpath = "//*[@id=\"selectable\"]/li[2]")
	private WebElement option2;
	
	public WebElement getOption2() {
		return option2;
	}

	@FindBy(xpath = "//*[@id=\"selectable\"]/li[4]")
	private WebElement option4;
	
	public void select1() {
		option1.click();
	}
	
	public void select1To4(WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(option1, option4).perform();
	}

	public WebElement getOption1() {
		return option1;
	}
}
