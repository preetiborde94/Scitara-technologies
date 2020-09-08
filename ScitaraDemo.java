package testcasesPkg;

import java.awt.Button;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import libraryPkg.BrowserInfo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScitaraDemo 
{
	String productName;
	static WebDriver driver;
	By UserName = By.id("user-name");
	By Password = By.id("password");
	By Login = By.id("login-button");
	String UName = "standard_user";
	String Pwd = "secret_sauce";	
	
	@BeforeTest	
	public void BrowserLaunch()
	{		
		driver = BrowserInfo.OpenBrowser("Chrome", "https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	}
	@Test(priority =1)
	public void applicationlogin() throws InterruptedException
	{
		driver.findElement(UserName).sendKeys(UName);
		driver.findElement(Password).sendKeys(Pwd);
		driver.findElement(Login).click();
		
	}
	
	
	/*@Test(priority=2)
	public void Shoppingcart() throws InterruptedException
	{
		WebElement CartField = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", CartField);
		 Thread.sleep(5000);
	
				
	}*/

	
	
	@Test(priority=3)
	public void Productlist() throws InterruptedException
	
	{
	    try 
	    {
			//driver.findElement(By.className("btn_secondary")).click();			
			List<WebElement> myList = driver.findElements(By.xpath("//div[contains(@class,'inventory_item_name')]"));
			List<WebElement> myListCart = driver.findElements(By.xpath("//*[@id='inventory_container']/descendant::button"));
			List<String> productNameList =new ArrayList<>();
			for(int i=0; i<= myList.size(); i++)
			{
				productName = myList.get(i).getText();
				//productName = driver.findElement(By.xpath("(//div[contains(@class,'inventory_item_name')])["+  i  +"]")).getText();
				if(productName.contains("Shirt"))
				{
					//myListCart.get(i).getText();
					myListCart.get(i).click();
					
				}				
			}
		} catch (Exception e) 
	    {
			e.getMessage();
	    }
	    
	}
	
	 @AfterTest
	    public void checkout() throws InterruptedException
	    {
		 WebElement CartField = driver.findElement(By.xpath("//*[@id='shopping_cart_container']/a"));
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
		 executor.executeScript("arguments[0].click();", CartField);
		 
         boolean removebuttonpresence = driver.findElement(By.xpath("//button[contains(text(),'REMOVE')]")).isDisplayed();
		 
		 if (removebuttonpresence==true)
			 
         {
              System.out.println("Cart Is not empty");
         }
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//a[contains(text(),'CHECKOUT')]")).click();
		 
	    }
				    
}

		
	
	

		
	
	
	

	




			
			
			
		
	
	  



			
			


		
