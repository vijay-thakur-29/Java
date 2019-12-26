package Program;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadPropFile 
{
    static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException 
	{
	Properties prop=new Properties();	
	FileInputStream ip=new FileInputStream("/home/rw-dtp-004/Documents/workspace/MouseOver/src/Program/config");
	prop.load(ip);
	System.out.println(prop.getProperty("name"));
	System.out.println(prop.getProperty("age"));
	String URL=prop.getProperty("url");
	System.out.println(prop.getProperty(URL));
	String browsername=prop.getProperty("browser");
	System.out.println(prop.getProperty("browsername"));
	if(browsername.equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver","/home/rw-dtp-004/Documents/Selenium/geckodriver");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();
		Thread.sleep(5000);
		driver.get(URL);
		driver.close();
	}
		
	}

}
