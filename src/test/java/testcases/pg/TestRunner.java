package testcases.pg;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import testcases.utils.Commondriver;

public class TestRunner extends Commondriver {
	
	
	//Verify Home page
	@Test(priority = 0)
	public void validateTile() {
		
		try {
			
			driver.findElement(By.xpath("//a[@id='cookie-accept']")).click();
			Reporter.log("Click on Accept cookies button", true);
			String actualTitle = driver.getTitle();		
			String expectedTitle = "Property Management Software | Entrata";
			assertEquals(expectedTitle,actualTitle);
			Reporter.log("Title verification successful", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
			
	}
	
	
	//Handle dynamim dropdown element
	@Test(priority = 1)
	public void handleDynamicElement() {
		
		try {
			
			WebElement product = driver.findElement(By.xpath("//div[@id='w-dropdown-toggle-7']"));
			Actions act = new Actions(driver);
			act.moveToElement(product).perform();
			Reporter.log("Hover over to the Product field", true);
			driver.findElement(By.xpath("(//nav[@id='w-dropdown-list-7']//descendant::a[.='General Accounting'])[2]")).click();
			Reporter.log("Clicked on General Accounting field", true);
			//to verify general accounting page opened successfully or not
			String actualTitle = driver.getTitle();	
			String expectedTitle = "General Accounting by Entrata | Accounting tools and financial reporting";
			if (actualTitle.equals(expectedTitle)) {
				Reporter.log("General Accounting page opened successfuly", true);
			}
			else {
				Assert.fail("General Accounting page not opened");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}

	}
	
	
	//Scroll to  specific element
	@Test(priority = 2)
	public void moveToForm() { 
		
		try {
			
			driver.findElement(By.xpath("//a[@class='brand w-nav-brand']")).click();
			WebDriverWait wt = new WebDriverWait(driver, 100);
			wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='brand w-nav-brand w--current']")));
			WebElement location = driver.findElement(By.xpath("//input[@id='FirstName']"));
			Point axis = location.getLocation();
			int xaxis = axis.getX();
			int yaxis = axis.getY();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy("+xaxis+","+yaxis+")");
			Thread.sleep(5000);
			Reporter.log("Window scrollled upto the form of the page", true);
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	
}
	
	
}

