package com.nsstodo.generalutil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.nsstodo.base.BaseClass;

public class GeneralUtilities extends BaseClass {

	public static long PAGE_LOAD_TIME = 20;
	public static long IMPLICIT_WAIT = 20;
	public static long EXPLICIT_WAIT = 10;

	public void selectDueDate(WebElement element, String type) {

		Select sel = new Select(element);
		if (type == "Day") {
			sel.selectByVisibleText("21");
		} else if (type == "Month") {
			sel.selectByVisibleText("Feb");
		} else if (type == "Year") {
			sel.selectByVisibleText("2019");
		}
	}

}
