package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();

		// Select the languages that you know?
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[1]"))
				.click();
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[2]"))
				.click();
		driver.findElement(By.xpath("(//label[text()='Select the languages that you know?']/following::input)[3]"))
				.click();

		// Select the languages that you know?
		boolean checkboxSelection = driver
				.findElement(By.xpath("(//label[text()='Confirm Selenium is checked']/following::input)[1]"))
				.isSelected();
		if (checkboxSelection == true) {
			System.out.println("Selenium is checked");
		} else {
			System.out.println("Selenium is Unchecked");
		}
		// DeSelect only checked
		for (int i = 1; i < 3; i++) {
			if ((driver
					.findElement(By.xpath("(//label[text()='DeSelect only checked']/following::input)" + "[" + i + "]"))
					.isSelected()) == true) {
				driver.findElement(
						By.xpath("(//label[text()='DeSelect only checked']/following::input)" + "[" + i + "]")).click();
				break;
			}
		}

		// Select all below checkboxes
		int checkcout = driver
				.findElements(By.xpath("//label[contains(text(),'Select all below checkboxes')]/following::input"))
				.size();

		//System.out.println(checkcout);
		for (int i = 0; i < checkcout; i++) {
			driver.findElements(By.xpath("(//label[contains(text(),'Select all below checkboxes')]/following::input)"))
					.get(i).click();
		}
	}
}
