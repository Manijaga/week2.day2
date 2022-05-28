package week2.day2;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {

	public static void main(String[] args) throws IOException {
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();

		// Click on this image to go home page
		driver.findElement(By.xpath("(//label[text()='Click on this image to go home page']/following::img)[1]"))
				.click();
		driver.get("http://leafground.com/pages/Image.html");

		// Am I Broken Image? ---
		String imgSearch = driver
				.findElement(By.xpath("(//label[text()='Click on this image to go home page']/following::img)[2]"))
				.getAttribute("src");
		URL url = new URL(imgSearch);
		URLConnection urlConnection = url.openConnection();
		HttpURLConnection httpURLConnection  = (HttpURLConnection) urlConnection;
		httpURLConnection.connect();
		//System.out.println(httpURLConnection.getResponseCode());
		if (httpURLConnection.getResponseCode() != 200) {
				System.out.println("Yes, This image is broken");	
		}
		httpURLConnection.disconnect();
		

		// Click me using Keyboard or Mouse
		Actions action = new Actions(driver);
		WebElement elementToClick = driver
				.findElement(By.xpath("(//label[text()='Click on this image to go home page']/following::img)[3]"));
		action.click(elementToClick).build().perform();
	}

}
