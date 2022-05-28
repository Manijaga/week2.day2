package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

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

//		8	Enter first name
		driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Manigandan");

//		9	Click Find leads button
		driver.findElement(By.xpath("(//button[text()='Find Leads'])[1]")).click();

//		10 Click on first resulting lead
		driver.findElement(By.xpath("(//span[text()='Lead List']/following::tbody/tr/td/div/a)[1]")).click();

//		11 Verify title of the page
		String webTitle = driver.getTitle();
		//System.out.println(webTitle);

		if (webTitle.equals("View Lead | opentaps CRM")) {
			System.out.println("You are sucessfully navaigated to View Lead web page");
		} else {
			System.out.println("Failed to load the View Lead web page");
		}

//		12 Click Edit
		driver.findElement(By.xpath("//a[text()='Edit']")).click();

//		13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		String priorCompany = "Cognizant";
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(priorCompany);

//		14 Click Update
		driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();

//		15 Confirm the changed name appears
		String viewPriorCompany = driver.findElement(By.id("viewLead_companyName_sp")).getText();
		if (viewPriorCompany.contains(priorCompany)) {
			System.out.println("Company Information changed successfully updated ");
		} else {
			System.out.println("Faild to updat the Copany Name");
		}

//		16 Close the browser (Do not log out)	
		driver.close();

	}

}
