package com.Google.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.ElementHandling;
import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.MouseOperations;

import commonLibs.implementation.TextboxControls;

public class BasicOperations {
	public ElementHandling elementControl;
	public TextboxControls textboxControl;
	public DropdownControl dropdownControl;
	public MouseOperations mouseOperation;
	
	public WebDriver driver;

	public BasicOperations(WebDriver driver) {
		elementControl = new ElementHandling();
		textboxControl = new TextboxControls();
		dropdownControl= new DropdownControl();
		mouseOperation= new MouseOperations(driver);
		
	}
}
