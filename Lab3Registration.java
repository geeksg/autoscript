package com.web.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Lab3Registration 
{
	public static void main(String[] args) throws InterruptedException
	{
		//Opening the browser and accessing the website
		WebDriver driver=new FirefoxDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Verifying page title
		boolean title = driver.getTitle().contains("Your Store");
		if(title)
		{
			System.out.println("Page title matches");
		}
		else
		{
			System.out.println("Page title not matches");
		}
		
		//Verifying Register
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(5000);
		boolean heading = driver.getTitle().contains("Register");
		if(heading)
		{
			System.out.println("Register page title matches");
		}
		else
		{
			System.out.println("Register page title not matches");
		}
		
		driver.findElement(By.xpath(".//*[@id='content']/form/div/div/input[2]")).click();
		Thread.sleep(5000);
		String alt = driver.findElement(By.xpath("//*[@id='account-register']/div[1]")).getText();
		Thread.sleep(5000);
		if(alt.equals("Warning: You must agree to the Privacy Policy!"))
		{
			System.out.println("Same alert text");
		}
		else
		{
			System.out.println("Alert message not matches");
		}
		
		//Personal details verfication
		driver.findElement(By.id("input-firstname")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.xpath(".//*[@id='content']/form/div/div/input[2]")).click();
		Thread.sleep(2000);
		String Fname = driver.findElement(By.xpath(".//*[@id='account']/div[2]/div/div")).getText();
		if(Fname.equals("First Name must be between 1 and 32 characters!"))
		{
			System.out.println("First name error message matches");
		}
		else
		{
			System.out.println("First name Error message not matches");
		}
		driver.findElement(By.id("input-lastname")).sendKeys("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		driver.findElement(By.xpath(".//*[@id='content']/form/div/div/input[2]")).click();
		Thread.sleep(2000);
		String Lname = driver.findElement(By.xpath(".//*[@id='account']/div[3]/div/div")).getText();
		if(Lname.equals("Last Name must be between 1 and 32 characters!"))
		{
			System.out.println("Last name Error message matches");
		}
		else
		{
			System.out.println("Last name Error message not matches");
		}
		driver.findElement(By.id("input-email")).sendKeys("hari586@gmail.com");
		driver.findElement(By.name("telephone")).sendKeys("98564215486");
		driver.findElement(By.id("input-firstname")).clear();
		driver.findElement(By.id("input-firstname")).sendKeys("Harish");
		driver.findElement(By.id("input-lastname")).clear();
		driver.findElement(By.id("input-lastname")).sendKeys("Kiran");
		
		//Password details
		driver.findElement(By.name("password")).sendKeys("Hari#123");
		Thread.sleep(5000);
		driver.findElement(By.name("confirm")).sendKeys("Hari#123");
		
		//News letter and Account creation Verification
		WebElement radio1 =driver.findElement(By.cssSelector("input[name=newsletter]"));
		radio1.click();
		//driver.findElement(By.cssSelector("input[name=newsletter]")).click();
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")).click();
		String message = driver.findElement(By.xpath(".//*[@id='content']/h1")).getText();
		if(message.equals("Your Account Has Been Created!"))
		{
			System.out.println("Message is verified");
		}
		else
		{
			System.out.println("Message not matches");
		}
		driver.findElement(By.linkText("Order History")).click();
		driver.findElement(By.linkText("Address Book")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//*[@id='content']/div/div[2]/a")).click();
		
		//Entering Address details
		driver.findElement(By.id("input-firstname")).sendKeys("Hari");
		driver.findElement(By.id("input-lastname")).sendKeys("Kiran");
		driver.findElement(By.name("address_1")).sendKeys("No.2 First street");
		driver.findElement(By.id("input-city")).sendKeys("Chennai");
		Thread.sleep(2000);
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("India");
		Select State = new Select(driver.findElement(By.name("zone_id")));
		State.selectByVisibleText("Tamil Nadu");
		driver.findElement(By.cssSelector("input[type=submit]")).click();
		Thread.sleep(5000);
		driver.close();	//Closing the application
	}
}

