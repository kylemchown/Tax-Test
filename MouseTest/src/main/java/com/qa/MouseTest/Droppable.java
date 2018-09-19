package com.qa.MouseTest;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Droppable {
	

	
	@FindBy(id = "draggableview")
	private WebElement dragItem;
	
	@FindBy(id = "droppableview")
	private WebElement dropItem;
	
	public void moveRight(WebDriver driver) {
		Actions action = new Actions(driver);
		action.dragAndDrop(dragItem, dropItem).perform();
	}
}
