package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {

//		1	Launch the browser
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

//		2	Enter the username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("DemoSalesManager");

//		3	Enter the password
		driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");

//		4	Click Login
		driver.findElement(By.className("decorativeSubmit")).click();

//		5	Click crm/sfa link
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();

//		6	Click Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();

//		7	Click Find leads
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();

//		8	Click on Email
		driver.findElement(By.xpath("//span[text()='Email']")).click();

//		9	Enter Email
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("manijaga1991@gmail.com");

//		10	Click find leads button
		driver.findElement(By.xpath("//button[text()='Find Leads'][1]")).click();
		
//		11	Capture name of First Resulting lead
		String fistName = driver
				.findElement(By.xpath("(//span[text()='Lead List']/following::tbody/tr/td[3]/div/a)[1]")).getText();
		String lastName = driver
				.findElement(By.xpath("(//span[text()='Lead List']/following::tbody/tr/td[4]/div/a)[1]")).getText();
		String leadName = fistName + " " + lastName;
		System.out.println("Lead Name Is - " + leadName);

//		12	Click First Resulting lead
		driver.findElement(By.xpath("(//span[text()='Lead List']/following::tbody/tr/td/div/a)[1]")).click();

//		13	Click Duplicate Lead
		driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();

//		14	Verify the title as 'Duplicate Lead'
		String webpageLead = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		String webTitle = driver.getTitle();
		// System.out.println(webTitle + webpageLead);

		if (webTitle.equals("Duplicate Lead | opentaps CRM") || webpageLead.equals("Duplicate Lead")) {
			System.out.println("You are sucessfully navaigated to Duplicate Lead web page");
		} else {
			System.out.println("Failed to load the Duplicate Lead web page");
		}

//		15	Click Create Lead
		driver.findElement(By.name("submitButton")).click();

//		16	Confirm the duplicated lead name is same as captured name
		String viewFistName = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		String viewLastName = driver.findElement(By.id("viewLead_lastName_sp")).getText();
		String viewLeadName = viewFistName + " " + viewLastName;
		if (viewLeadName.equals(leadName)) {
			System.out.println("Duplicate Lead Name");
		} else {
			System.out.println("Lead Name not exit in our portal");
		}

//		17	Close the browser (Do not log out)
		driver.close();

	}

}
