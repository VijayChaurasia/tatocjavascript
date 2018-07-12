package com.qait.automation.tatoc_js;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Cookie_generate {
	WebDriver driver;
	JavascriptExecutor js;
	public Cookie_generate(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	public void generate_token()
	{
		//driver.findElement(By.linkText("Generate Token")).click();
		js.executeScript("arguments[0].click();",js.executeScript("return document.querySelector('.page > a:nth-child(8)')"));
		WebElement token=(WebElement) js.executeScript("return document.querySelector('#token')");
		
		String Token = token.getText();
		 System.out.println(Token);
		 String substring1=Token.substring(7);
		 Cookie name = new Cookie("Token", substring1);
		 driver.manage().addCookie(name);
         driver.findElement(By.linkText("Proceed")).click(); 
         Assert.assertEquals("http://10.0.1.86/tatoc/end", driver.getCurrentUrl());
	}
	

}
