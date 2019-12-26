package Program;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Mouse {

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","/home/rw-dtp-004/Documents/Selenium/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		driver.get("http://secure.rightwave.net:8080/revopstest/login.htm");
		driver.findElement(By.id("headerMenu-Get-Started")).click();
		Thread.sleep(5000);
		WebElement element = driver.findElement(By.xpath("//DIV[@class='noPadding JoinUsFormCreateAccount']"));

	     Actions builder = new Actions(driver);

	     Action mouseOver = builder.moveToElement(element).build();

	     String bgColor = element.getCssValue("background-color");

	     System.out.println("Before hover: " + bgColor);   
	     

	     mouseOver.perform(); 
	     Thread.sleep(5000);

	     bgColor = element.getCssValue("background-color");

	     System.out.println("After hover: " + bgColor);

	}

}
