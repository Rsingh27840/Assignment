package Seleniumliveproject;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class assignment2 {
	public void main(String[] args) {
		// TODO Auto-generated method stub
		String actual[] = { "English", "Dutch" };
		String expdrop [] = new String[10];
		String exp;
		String act = "A welcome email has been sent. Please check your email. ";
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		SoftAssert sof = new SoftAssert();	
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		WebElement dropdown = driver.findElement(By.xpath("//div[@id=\"language\"]/div[1]"));
		expdrop[0] = dropdown.getText();
		dropdown.click();
		WebElement drop = driver.findElement(By.xpath("//div[@id=\"language\"]/input[1]"));
		drop.sendKeys("Dutch");
		drop.sendKeys(Keys.ENTER);
		expdrop[1]= dropdown.getText();
		dropdown.click();
		drop.sendKeys("English");
		drop.sendKeys(Keys.ENTER);
		for ( int i = 0; i<2;i++) {
		sof.assertEquals(actual[i], expdrop[i], ""+actual[i]+"is present");
		}
		
		driver.findElement(By.id("name")).sendKeys("Rahul Singh");
		driver.findElement(By.id("orgName")).sendKeys("Rahul");
		driver.findElement(By.id("singUpEmail")).sendKeys("Singrahul214403@gmail.com");
		driver.findElement(By.xpath("//span[@class ='black-color ng-binding']")).click();
		driver.findElement(By.xpath("//button[text()='Get Started']")).click();
		 exp = driver.findElement(By.xpath("//span[text() =' A welcome email has been sent. Please check your email. ']")).getText();
		 sof.assertEquals(act, exp, "Email has been recieved");
		 driver.close();
		
				
		

	}

}

