package seleniumPractices;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinkList {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\SeleniumDrivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com/");
		
		List<WebElement> listLink = driver.findElements(By.tagName("a"));
		System.out.println(listLink.size());
		
		for (int i = 0; i < listLink.size(); i++) {
			
			String linkName = listLink.get(i).getText();
			
			System.out.println(linkName);
			
			
			
			
			
			
			
		}

	}

}
