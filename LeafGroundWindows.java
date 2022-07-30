package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundWindows {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Window.html");
		driver.manage().window().maximize();
		String mW=driver.getWindowHandle();
		System.out.println(mW);
		
		//Click button to open home page in New Window
		System.out.println("Scenario-Click button to open home page in New Window");
		driver.findElement(By.id("home")).click();
		Set<String> s=driver.getWindowHandles();
		System.out.println(s.size());
		List<String> l=new ArrayList<String>(s);
		String fw=l.get(1);
		System.out.println(fw);
		driver.switchTo().window(fw);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(mW);
		
		//Find the number of opened windows
		System.out.println("Scenario-Find the number of opened windows");
		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();
		Set<String> s2=driver.getWindowHandles();
		System.out.println("The Number of opened windows: "+s2.size());
		List<String> l2=new ArrayList<String>(s2);
		String fw1=l2.get(1);
		driver.switchTo().window(fw1);
		driver.close();
		String fw2=l2.get(2);
		driver.switchTo().window(fw2);
		driver.close();
		driver.switchTo().window(mW);
		
		//Close all except this window
		System.out.println("Scenario-Close all except this window");
		driver.findElement(By.xpath("//button[@id='color'][1]")).click();
		Set<String> s3=driver.getWindowHandles();
		//System.out.println("The Number of opened windows: "+s3.size());
		List<String> l3=new ArrayList<String>(s3);
		String fw3=l3.get(1);
		driver.switchTo().window(fw3);
		System.out.println(driver.getTitle());
		driver.close();
		String fw4=l3.get(2);
		driver.switchTo().window(fw4);
		System.out.println(driver.getTitle());
		driver.close();
		driver.switchTo().window(mW);
		
			
		//Wait for 2 new Windows to open
		System.out.println("Secnario-Wait for 2 new Windows to open");
		//Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[@id='color'])[2]")).click();
		
		Thread.sleep(5000);
		Set<String> s4=driver.getWindowHandles();
		//System.out.println("The Number of opened windows: "+s4.size());
		List<String> l4=new ArrayList<String>(s4);
		String fw5=l4.get(1);
		driver.switchTo().window(fw5);
		System.out.println(driver.getTitle());
		//driver.close();
		String fw6=l4.get(2);
		driver.switchTo().window(fw6);
		System.out.println(driver.getTitle());
		System.out.println("The two windows opened");
		////driver.close();
		//driver.switchTo().window(mW);
		
	}

}
