package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;



public class BaseClass {
public static WebDriver driver;
public Logger logger;
public Properties p;

@BeforeClass(groups = {"Regression","Sanity","Master"})
@Parameters({"os","browser"})
public void setup(String os,String br) throws IOException {
	logger = LogManager.getLogger(this.getClass());
	FileReader file = new FileReader("C:\\Users\\shaik\\eclipse-workspace\\opencartv1\\src\\test\\resources\\config.properties");
	p=new Properties();
	p.load(file);
	
	switch(br.toLowerCase()) {
	case "chrome" : driver= new ChromeDriver(); break;
	case "edge" : driver= new EdgeDriver(); break;
	case "firefox" : driver= new FirefoxDriver(); break;
	default: System.out.println("invailed browser"); return;
	}
	
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	
	
	driver.get(p.getProperty("appURL"));
	driver.manage().window().maximize();
}
	@AfterClass(groups = {"Regression","Sanity","Master"})
	public void teardown() {
		driver.quit();
	}
	public String randomString() {
		@SuppressWarnings("deprecation")
		String generatedString =RandomStringUtils.randomAlphabetic(6);
		return generatedString;
		
	}
	public String randomInteger() {
		@SuppressWarnings("deprecation")
		String generatedInteger =RandomStringUtils.randomNumeric(10);
		return generatedInteger;
		
	}
	
	public String captureScreen(String tname) throws IOException {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs (OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname +"_" + timeStamp+".png";
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
		}
	
}
