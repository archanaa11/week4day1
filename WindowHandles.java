package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		/*1.Launch the browser
2.Load the url as " https://login.salesforce.com/ "
3.Enter the username as " ramkumar.ramaiah@testleaf.com "
4. Enter the password as " Password$123 "
5.click on the login button
6.click on the learn more option in the Mobile publisher
7.Switch to the next window using Windowhandles.
8.click on the confirm button in the redirecting page
9.Get the title
10.Get back to the parent window
11.close the browser*/
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));		
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(5000);
		/*Alert a=driver.switchTo().alert();
		System.out.println(a.getText());
		a.dismiss();*/
		String fw=driver.getWindowHandle();
		System.out.println(fw);
		driver.findElement(By.xpath("(//button[@class='slds-button slds-button--neutral navButton newWindow uiButton'])[1]")).click();
		Set<String> wH=driver.getWindowHandles();
		System.out.println("No.windows "+wH.size());
		
		List<String> list1=new ArrayList<String>(wH);
		String sw=list1.get(1);
		System.out.println(sw);
		
		driver.switchTo().window(sw);
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		System.out.println(driver.getTitle());
		driver.switchTo().window(fw);
		driver.close();
		
		
		
		 
		

	}

}
