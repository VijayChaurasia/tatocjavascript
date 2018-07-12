package com.qait.automation.tatoc_js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Drag {
	WebDriver driver;
	JavascriptExecutor js;
	public Drag(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	
	public WebDriver step4drag()
	{
		
		WebElement from=driver.findElement(By.id("dragbox"));
		WebElement to=driver.findElement(By.id("dropbox"));
		Actions builder=new Actions(driver);
		builder.clickAndHold(from).moveToElement(to).release(to).build().perform();
		WebElement element=driver.findElement(By.linkText("Proceed"));
		js.executeScript("arguments[0].click();",element);
		String str=js.executeScript("return document.title").toString();
		System.out.println(str);
		return driver;
	}
	
	

}
