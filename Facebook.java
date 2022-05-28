package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {

	public static void main(String[] args) {
		System.setProperty("webdriver.edge.driver", "C:\\Eclipse\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
		// Open Facebook Page
		driver.get("https://en-gb.facebook.com");
		driver.manage().window().maximize();
		// Adding a 90 Seconds wait for all the lines
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		// Sing up facebook with name , phnone #....
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		driver.findElement(By.name("firstname")).sendKeys("Leanne");
		driver.findElement(By.name("lastname")).sendKeys("Helman");
		driver.findElement(By.name("reg_email__")).sendKeys("123456789");
		driver.findElement(By.id("password_step_input")).sendKeys("Leanne@1234");
		Select leaneDate = new Select(driver.findElement(By.id("day")));
		leaneDate.selectByVisibleText("1");
		Select leaneMonth = new Select(driver.findElement(By.id("month")));
		leaneMonth.selectByVisibleText("Nov");
		Select leaneYear = new Select(driver.findElement(By.id("year")));
		leaneYear.selectByValue("1991");
		driver.findElement(By.xpath("//label[text()='Female']/following-sibling::input")).click();

	}

}
