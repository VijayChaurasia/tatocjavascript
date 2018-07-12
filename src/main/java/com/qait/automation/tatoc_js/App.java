package com.qait.automation.tatoc_js;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class App 
{
	WebDriver driver;
    JavascriptExecutor js;
	public App(WebDriver driver)
    {
    	this.driver=driver;
    	js=(JavascriptExecutor) driver;
    }
	public WebDriver step1basic()
	{
		WebElement element=(WebElement) js.executeScript(" return document.querySelector('.page > a:nth-child(4)')");
		js.executeScript("arguments[0].click();",element);
		return driver;
	}


	

	
}
