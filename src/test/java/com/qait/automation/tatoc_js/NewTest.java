package com.qait.automation.tatoc_js;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;

public class NewTest {
	WebDriver driver;
	App app;
	Gridgate grid;
	Frame1 frame;
	Drag drag;
	Popup pop;
	Cookie_generate cookie;
	
  @Test
  public void teststep1() {
	  driver=app.step1basic();
	 Assert.assertEquals(driver.getTitle(),"Grid Gate - Basic Course - T.A.T.O.C");
	 grid=new Gridgate(driver);
	 
  }
  @Test(dependsOnMethods= {"teststep1"})
  public void teststep2()
  {
	  driver=grid.step2gridgate();
	  Assert.assertEquals(driver.getTitle(),"Frame Dungeon - Basic Course - T.A.T.O.C");
	  frame=new Frame1(driver);  
  }
  
  @Test(dependsOnMethods= {"teststep2"})
  public void teststep3()
  {
	driver=frame.step3frame();
	Assert.assertEquals(driver.getTitle(),"Drag - Basic Course - T.A.T.O.C");
	drag=new Drag(driver);
	
  }
  @Test(dependsOnMethods= {"teststep3"})
  public void teststep4()
  {
	 driver= drag.step4drag();
	 Assert.assertEquals(driver.getTitle(),"Windows - Basic Course - T.A.T.O.C");
	 pop=new Popup(driver);
  }
  @Test(dependsOnMethods= {"teststep4"})
  public void teststep5()
  {
	  driver=pop.step5popup();
	  Assert.assertEquals(driver.getTitle(),"Cookie Handling - Basic Course - T.A.T.O.C");
	  cookie=new Cookie_generate(driver);
  }
  
  @Test(dependsOnMethods= {"teststep5"})
  public void teststep6()
  {
	  cookie.generate_token();
	  
  }

  @BeforeClass
  public void before()
  {
	  driver=new ChromeDriver();
	  driver.get("http://10.0.1.86/tatoc");
	  app=new App(driver);
	  
  }
}
