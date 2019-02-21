package com.nsstodo.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nsstodo.base.BaseClass;
import com.nsstodo.pages.EditPage;
import com.nsstodo.pages.TodoPage;


public class TodoPageTest extends BaseClass {

	TodoPage todopage;
	EditPage editpage;
	
	
	public TodoPageTest() {
		super();
	}

	@BeforeMethod
	public void Setup() {
		initialization();
		todopage = new TodoPage();
	}

	@Test
	public void addTodoTest() {
		todopage.addTodo();
	}
	
	@Test
	public void addCategoryTest(){
		todopage.addTodoCategory();
	}
	
	@Test
	public void modifyTodoTest(){
		todopage.modifyTodo();
	}
	
	
	@Test
	public void removeTodoTest(){
		todopage.removeTodo();
	}

	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
}
