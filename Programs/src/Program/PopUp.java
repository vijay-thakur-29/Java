package Program;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class PopUp {

	public static void main(String[] args) throws InterruptedException, IOException 
	{
		System.setProperty("webdriver.gecko.driver","/home/rw-dtp-004/Documents/Selenium/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.get("https://www.rightwave.com/rwi/whitepapers/");
		WebElement webElement = driver.findElement(By.xpath("//A[@id='fancybox-fourth-whitepaper']"));
		JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver;
		javaScriptExecutor.executeScript("arguments[0].click()", webElement);
		Thread.sleep(5000);
		//driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[name^='fancybox-frame']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@class,'fancybox-frame')]")));
		Thread.sleep(5000);
		driver.findElement(By.id("firstName")).sendKeys("Vijay_Test");
		driver.findElement(By.id("lastName")).sendKeys("Thakur_Test");
		driver.findElement(By.id("email")).sendKeys("vthakur@rightwave.com");
		driver.findElement(By.id("title")).sendKeys("Testing");
		driver.findElement(By.id("phone")).sendKeys("1234567890");
		driver.findElement(By.id("business")).sendKeys("Rightwave");
		Select select1 = new Select(driver.findElement(By.id("country")));
		select1.selectByVisibleText("India");
		driver.findElement(By.id("NONUS")).sendKeys("UP");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("/home/rw-dtp-004/Documents/form.png"));
		Thread.sleep(5000);
		driver.findElement(By.name("button")).click();

	}

}
