package com.nsstodo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.nsstodo.base.BaseClass;
	
	
	
public class EditPage extends BaseClass{
	
	// Page Object Repository
	
	
	public EditPage(){
		PageFactory.initElements(driver, this);
	}
	
	
}
