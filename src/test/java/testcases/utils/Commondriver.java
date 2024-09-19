package testcases.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Commondriver {
	
	protected static WebDriverWait wait;
	protected static WebDriver driver;
	File file = new File(TestCaseConstants.PROPERTIES_PATH);

	
	
	
	@BeforeSuite
	public void beforeTest() throws IOException {
		
 		System.setProperty("webdriver.chrome.driver",TestCaseConstants.FILES_PATH + "chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		FileInputStream fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		driver.get(prop.getProperty("BASE_URL"));
    }
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
		}
	
	

	 

}
