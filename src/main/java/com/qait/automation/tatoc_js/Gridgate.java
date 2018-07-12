package com.qait.automation.tatoc_js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.testng.Assert;

public class Gridgate {
	WebDriver driver;
	JavascriptExecutor js;
	public Gridgate(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	
	public WebDriver step2gridgate()
	{
		WebElement greenbox=(WebElement) js.executeScript(" return document.querySelector('.greenbox')");
		System.out.println(greenbox.isDisplayed());
		js.executeScript("arguments[0].click();",greenbox);
		return driver;
	}

}
