package com.PruebaTecnica.PruebaTecnicaAnderson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class webtest {

	private WebDriver driver;
	
	@Before
    public void setUp(){
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
     driver =  new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.gadgetsnow.com/compare-laptops");
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

    }
	@Test
	public void comparacion() 
	{
		
		Actions action = new Actions(driver);

		WebElement element = driver.findElement(By.xpath("(//input[@placeholder='Add Device'])[1]"));
		element.sendKeys("Lenovo E41-80");
		action.doubleClick(element);
		driver.findElement(By.xpath("/html/body/div[7]/ul/li[1]/p")).click();
		
		
		WebElement element2 = driver.findElement(By.xpath("(//input[@placeholder='Add Device'])[2]"));
		element2.sendKeys("Lenovo B40-80");
		action.doubleClick(element2);
		driver.findElement(By.xpath("/html/body/div[8]/ul/li[1]/p")).click();
		
		//btn
		driver.findElement(By.className("bl_btn")).click();
		
		String table = driver.findElement(By.xpath("//table/tbody/tr[3]/td/table")).getText();
	
		
		PrintStream resultSUMMARY;
		try {
			resultSUMMARY = new PrintStream(new File ("C:\\Users\\lenovo\\Desktop\\pruebaTecnica\\PruebaTecnicaAnderson\\src\\test\\resources/ResultSUMMARY.txt"));
			System.setOut(resultSUMMARY);
			} catch (FileNotFoundException e) 
				{
					System.out.println(e);
				}
		System.out.println(table);
	}
	
	@After
    public void tearDown(){
    driver.quit();
    }
	
}
