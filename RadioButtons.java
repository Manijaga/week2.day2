package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtons {

	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leafground.com/pages/radio.html");
		driver.manage().window().maximize();

		// Are you enjoying the classes? - Yes
		driver.findElement(By.id("yes")).click();

		// Find default selected radio button
		int checkcout = driver.findElements(By.name("news")).size();
		// String[] check = (driver.findElement(By.xpath("//label[text()='Find default
		// selected radio button']/parent::div")).getText()).split(" ");

		for (int i = 0; i <= checkcout; i++) {
			if ((driver.findElements(By.name("news")).get(i).isSelected()) == true) {
				System.out.println(
						"The selected Value Is " + driver.findElements(By.name("news")).get(i).getAttribute("Value"));
				break;
			}
		}

		// Select your age group (Only if choice wasn't selected)

		int age = 45;

		if (age > 0 && age <= 21) {
			boolean chckboxOne = driver
					.findElement(By.xpath("(//label[contains(text(),'Select your age group')]/following::input)[1]"))
					.isSelected();
			if (chckboxOne == false) {
				driver.findElement(By.xpath("(//label[contains(text(),'Select your age group')]/following::input)[1]"))
						.click();
			}

		} else {
			if (age > 20 && age <= 40) {
				boolean chckboxTwo = driver
						.findElement(
								By.xpath("(//label[contains(text(),'Select your age group')]/following::input)[2]"))
						.isSelected();
				if (chckboxTwo == false) {
					driver.findElement(
							By.xpath("(//label[contains(text(),'Select your age group')]/following::input)[2]"))
							.click();
				}
			} else {
				if (age > 40) {
					boolean chckboxThree = driver
							.findElement(
									By.xpath("(//label[contains(text(),'Select your age group')]/following::input)[3]"))
							.isSelected();
					
					if (chckboxThree == false) {
						driver.findElement(
								By.xpath("(//label[contains(text(),'Select your age group')]/following::input)[3]"))
								.click();
					}
				}
			}
		}

	}

}
