package workingwithelements;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestImplicitWait 
{
public WebDriver driver ; 
	
	@BeforeClass
	public void setUp() 
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://cookbook.seleniumacademy.com/AjaxDemo.html");
	}
	
	@Test
	public void testImplicityWait() 
	{
		// set the implicit wait time to 20 Seconds
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.findElement(By.linkText("Page 4")).click();
		WebElement message = driver.findElement(By.id("page4")); 
		assertTrue(message.getText().contains("Nunc nibh tortor"));
	}
	
	
	@AfterClass
	public void tearDown() 
	{
		driver.quit();
	}

}
