package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

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
		// Create a contract
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Create Contact']")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Manigandan");
		driver.findElement(By.id("lastNameField")).sendKeys("Kanniyappan");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Mani");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("gandan");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("Mathematics");
		driver.findElement(By.id("createContactForm_description")).sendKeys("Manual Testing");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("manijaga1991@gmail.com");
		// Select State
		Select selectState = new Select(driver.findElement(By.id("createContactForm_generalStateProvinceGeoId")));
		selectState.selectByVisibleText("New York");
		driver.findElement(By.name("submitButton")).click();
		// Edit the contract form
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("Important Note");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		// Get Page title
		System.out.println(" Current Page Title is - " + driver.getTitle());
		driver.close();

	}

}
