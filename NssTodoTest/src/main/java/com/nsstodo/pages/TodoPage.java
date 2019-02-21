package com.nsstodo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.nsstodo.base.BaseClass;
import com.nsstodo.generalutil.GeneralUtilities;

public class TodoPage extends BaseClass {

	// Page Object Repository
	@FindBy(xpath = "//input[@name='data']")
	WebElement addTodoText;
	@FindBy(xpath = "//input[@type='submit' and @value='Add']")
	WebElement addTodoBtn;
	@FindBy(xpath = "//input[@type='submit' and @value='Update']")
	WebElement updateTodoBtn;
	@FindBy(xpath = "//input[@type='submit' and @value='Complete']")
	WebElement completeTodoBtn;
	
	
	@FindBy(xpath = "//select[@name='category']")
	WebElement selectCategory;
	@FindBy(xpath = "//select[@name='due_day']")
	WebElement selectDay;
	@FindBy(xpath = "//select[@name='due_month']")
	WebElement selectMonth;
	@FindBy(xpath = "//select[@name='due_year']")
	WebElement selectYear;
	@FindBy(xpath = "//input[@type='submit' and @value='Remove']")
	WebElement removeTodoBtn;
	@FindBy(xpath = "//input[@name='categorydata']")
	WebElement addCategoryText;
	@FindBy(xpath = "//input[@type='submit' and @value='Add category']")
	WebElement addCategoryBtn;
	@FindBy(xpath = "//select[@name='colour']")
	WebElement selectCatColor;
	
	@FindBy(xpath = "//div[@id=\"todos-content\"]//ul//li//span[contains(text(), 'Modify Front End Automation Testing')]//preceding-sibling::input[@type='checkbox']")
	WebElement selectTodoCheckBox;
	
	@FindBy(xpath = "//div[@id=\"todos-content\"]//ul//li//span[contains(text(), 'Front End Automation Testing')]//preceding-sibling::a")
	WebElement todoDetailsLink;
	
	
	
	GeneralUtilities utils = new GeneralUtilities();
	EditPage editpage = new EditPage();
	public TodoPage() {
		PageFactory.initElements(driver, this);
	}

	public void addTodo() {
		addTodoText.sendKeys("Front End Automation Testing");
		/* To select Category from category Drop Down */
		Select selcat = new Select(selectCategory);
		selcat.selectByVisibleText("Play");
		/* To select Due date from Drop Down */
		utils.selectDueDate(selectDay, "Day");
		utils.selectDueDate(selectMonth, "Month");
		utils.selectDueDate(selectYear, "Year");
		/* To Click Add Button */
		addTodoBtn.click();
	}
	
	public void addTodoCategory() {
		addCategoryText.sendKeys("Mobile Testing");
		Select selcatColor = new Select(selectCatColor);
		selcatColor.selectByVisibleText("Green");
		addCategoryBtn.click();
	}
	
	
	
	public EditPage modifyTodo() {
		todoDetailsLink.click();
		addTodoText.clear();
		addTodoText.sendKeys("Modify Front End Automation Testing");
		updateTodoBtn.click();
		return new EditPage();
	}
	
	public void completeTodo() {
		selectTodoCheckBox.click();
		completeTodoBtn.click();
	}
	
	
	
	
	public void removeTodo() {
		selectTodoCheckBox.click();
		removeTodoBtn.click();
	}

}
