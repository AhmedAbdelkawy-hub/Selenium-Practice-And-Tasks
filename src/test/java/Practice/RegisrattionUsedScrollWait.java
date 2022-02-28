package Practice;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegisrattionUsedScrollWait {
	public  WebDriver driver ;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/signup");
	}

	@Test
	public void assertRegistration() {

		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ahmed");
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Abdelkawy");
		driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("01119994052");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("elkawy8@gmail.com");
		driver.findElement(By.xpath("//input[@Placeholder='Password']")).sendKeys("123456789");
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("scrollBy(0,500)");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				driver.findElement(By.id("select2-account_type-container")));
		// wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("select2-account_type-container"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-account_type-container")));
		// action
		driver.findElement(By.id("select2-account_type-container")).click();
		// Wait
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//li[.='Supplier']"))));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[.='Supplier']")));
		// action
		driver.findElement(By.xpath("//li[.='Supplier']")).click();

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Assert
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://www.phptravels.net/login/signup");
	}
//	@AfterClass
//	public void tearDown() 
//	{
//		driver.quit();
//	}
}
