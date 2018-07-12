package com.qait.automation.tatoc_js;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Popup {
	WebDriver driver;
	JavascriptExecutor js;
	public Popup(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	
	public WebDriver step5popup()
	{
		WebElement element=(WebElement) js.executeScript("return document.querySelector('.page > a:nth-child(4)')");
		js.executeScript("arguments[0].click();",element);
		String main=driver.getWindowHandle();
		System.out.println("Current : "+main);
		java.util.Set<String> sub= driver.getWindowHandles();
		Iterator<String> i1=sub.iterator();
		while(i1.hasNext())
		{
			String child=i1.next();
			if(!main.equalsIgnoreCase(child))			
	            {    		
	                    driver.switchTo().window(child);
	                    
	                    ((WebElement) js.executeScript("return document.querySelector('#name')")).sendKeys("vijay");                			
	                    js.executeScript("arguments[0].click();",js.executeScript("return document.querySelector('#submit')"));
	                   // driver.findElement(By.id("submit")).click();				
	            }		
		}
		System.out.println("Size : "+driver.getWindowHandles().size());
		driver.switchTo().window(main);
		System.out.println("Current : "+driver.getWindowHandle());
	    js.executeScript("arguments[0].click();",js.executeScript("return document.querySelector('.page > a:nth-child(6)')"));
		return driver;
	}
    

}
