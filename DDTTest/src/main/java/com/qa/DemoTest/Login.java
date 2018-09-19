package com.qa.DemoTest;

import org.openqa.selenium.*;


import org.openqa.selenium.support.FindBy;

public class Login {

	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")
	private WebElement loginUser;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")
	private WebElement loginPass;
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")
	private WebElement login;
	

	
	public void log(String user, String pass) {
		loginUser.sendKeys(user);
		loginPass.sendKeys(pass);
		login.click();
	}
}
