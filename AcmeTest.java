package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeTest {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://acme-test.uipath.com/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// Enter Email Id
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");
		// Enter the PWD
		driver.findElement(By.id("password")).sendKeys("leaf@12");
		// Click Login button
		driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
		// Get title and print the value
		System.out.println("Web Page Title Is - " + driver.getTitle());
		//Click Logout
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]"));
		
		driver.close();
		
		
	
		

	}

}
