package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

	public static void main(String[] args) {
		// open browser and navigate to TestLeaf login page
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// Login with valid user ID and PWD
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		// Lead Tab
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		// Find Lead using mobile #
		driver.findElement(By.xpath("//span[text()='Phone']/ancestor::a")).click();

		driver.findElement(By.name("phoneNumber")).sendKeys("8889991234"); // Enter valid Phone number
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		String leadId = driver
				.findElement(By.xpath("//span[text()='Lead List']/following::tbody/tr/td/div/a[@class='linktext'][1]"))
				.getText();
		System.out.println("First Lead is - " + leadId);
		driver.findElement(By.xpath("//span[text()='Lead List']/following::tbody/tr/td/div/a[@class='linktext'][1]"))
				.click();
		// Delete Lead
		driver.findElement(By.xpath("//a[text()='Delete']")).click();
		// find Lead
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		driver.findElement(By.name("id")).sendKeys(leadId);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();

		boolean norecords = driver.findElement(By.xpath("//div[text()='No records to display']")).isDisplayed();
		
		if (norecords == true) {
			System.out.println("Lead records is deleted successfully");
		} else {
			System.out.println("Lead records is exist");

		}
		driver.close();
		
	}

}
