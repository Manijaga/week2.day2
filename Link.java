package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		// Go to Home Page
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.get("http://leafground.com/pages/Link.html");

		// Find where am supposed to go without clicking me?
		System.out.println("You have to go to - " + driver
				.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));

		// Verify am I broken?
		driver.findElement(By.linkText("Verify am I broken?")).click();
		// System.out.println(driver.getTitle());
		if (driver.getTitle().equals("404 Not 404 Not Found")) {
			System.out.println("This wbe page is broken");
		} else {
			System.out.println("Page is not broken");
		}
		driver.get("http://leafground.com/pages/Link.html");

		// Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("//a[text()='Go to Home Page']")).click();
		driver.get("http://leafground.com/pages/Link.html");

		// How many links are available in this page?
		System.out.println("Total Hyper Link in this page is - " + driver.findElements(By.xpath("//div/a")).size());

	}

}
