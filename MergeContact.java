package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * //Pseudo Code
		 * 
		 * 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		 * 
		 * 2. Enter UserName and Password Using Id Locator
		 * 
		 * 3. Click on Login Button using Class Locator
		 * 
		 * 4. Click on CRM/SFA Link
		 * 
		 * 5. Click on contacts Button
		 * 	
		 * 6. Click on Merge Contacts using Xpath Locator
		 * 
		 * 7. Click on Widget of From Contact
		 * 
		 * 8. Click on First Resulting Contact
		 * 
		 * 9. Click on Widget of To Contact
		 * 
		 * 10. Click on Second Resulting Contact
		 * 
		 * 11. Click on Merge button using Xpath Locator
		 * 
		 * 12. Accept the Alert
		 * 
		 * 13. Verify the title of the page
		 */
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		driver.findElement(By.id("password")).sendKeys("crmsfa");

		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		String windowH=driver.getWindowHandle();
		System.out.println(windowH);
		driver.findElement(By.xpath("(//span[text()='From Contact']//following::img)[1]")).click();
		Set<String> w=driver.getWindowHandles();
		List<String> list1=new ArrayList<String>(w);
		String sw=list1.get(1);
		System.out.println("From contact window:"+sw);

		driver.switchTo().window(sw);
		driver.findElement(By.xpath("//a[@class='linktext'][1]")).click();

		driver.switchTo().window(windowH);
		driver.findElement(By.xpath("(//span[text()='From Contact']//following::img)[2]")).click();
		Set<String> tw=driver.getWindowHandles();
		List<String> list2=new ArrayList<String>(tw);
		String tw1=list2.get(1);
		System.out.println("To Contact window:"+tw1);

		driver.switchTo().window(tw1);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());

		driver.findElement(By.xpath("(//a[@class='linktext'])[5]")).click();
		driver.switchTo().window(windowH);
		driver.findElement(By.linkText("Merge")).click();
		Alert a=driver.switchTo().alert();
		System.out.println("The Alert Text is "+a.getText());
		a.accept();
		String title=driver.getTitle();
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("View")) {
			System.out.println("The page landed correctly on the View Contacts page "+title);}
		else {
			System.out.println("The page is not landed correctly on the View Contacts page "+title );}





	}

}
