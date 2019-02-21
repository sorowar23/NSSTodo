package com.nsstodo.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.nsstodo.generalutil.GeneralUtilities;

public class BaseClass {
	public static WebDriver driver;

	public static void initialization() {

		String project_path = System.getProperty("user.dir");

		System.setProperty("webdriver.chrome.driver", project_path + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(GeneralUtilities.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(GeneralUtilities.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get("http://localhost/nss-todo-automation/");

	}

}
