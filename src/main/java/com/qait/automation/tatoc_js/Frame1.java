package com.qait.automation.tatoc_js;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frame1 {
	WebDriver driver;
	JavascriptExecutor js;
	public Frame1(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}

	public WebDriver step3frame()
	{
		System.out.println("calling frame");
		boolean flag=true;
		driver.switchTo().frame("main");
		WebElement box1=(WebElement) js.executeScript("return document.querySelector('#answer')");
		String s1=box1.getAttribute("class");
		//String s1=driver.findElement(By.xpath("//*[text()[contains(.,'Box 1')]]")).getAttribute("class");
		while(flag)
		{
			driver.switchTo().frame("child");
			WebElement box2=(WebElement) js.executeScript("return document.querySelector('#answer')");
			String s2=box2.getAttribute("class");
			//String s2=driver.findElement(By.xpath("//*[text()[contains(.,'Box 2')]]")).getAttribute("class");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("main");
			if(s1.equals(s2))
			{
				flag=false;
				js.executeScript("arguments[0].click();",js.executeScript("return document.querySelector('body > center:nth-child(1) > a:nth-child(9)')"));
				//driver.findElement(By.xpath("//*[text()[contains(.,'Proceed')]]")).click();
			}
			else
			{
				js.executeScript("arguments[0].click();",js.executeScript("return document.querySelector('body > center:nth-child(1) > a:nth-child(7)')"));
				
				//driver.findElement(By.xpath("//*[text()[contains(.,'Repaint Box 2')]]")).click();
			}
		}
		
		driver.switchTo().defaultContent();
		String str=js.executeScript("return document.title").toString();
		System.out.println(str);
		return driver;
	}
	
	
	
}
