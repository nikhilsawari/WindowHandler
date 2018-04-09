import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class newTrail {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\ChromeDriver\\chromedriver.exe");
		
		/*DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marionette", true);*/

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Alert alert =  driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		
		String alertText = alert.getText();
		
		alertText.equalsIgnoreCase("hey, this is a alert message");
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("   ")));
		
		Set<String> winHandles = driver.getWindowHandles();
		
		String parentWindowId = driver.getWindowHandle();
		String parentTitle = driver.getTitle();
		driver.findElement(By.xpath("   ")).click();
		String childwindowID = driver.getWindowHandle();
		String childTitle = driver.getTitle();
		
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		driver.switchTo().defaultContent();
		
		/*
		 * driver.switchTo().defaultContent();
		 * System.out.println(driver.getTitle());
		*/
		
		WebElement radio = driver.findElement(By.xpath("    "));
		boolean selectStatus = radio.isSelected();
		radio.isDisplayed();
		
		List<WebElement> frames = driver.findElement(By.tagName(iframe));
		System.out.println(frames.size());
		
		for(int i=0; i<frames.size(); i++){
			if(frames.get(i).getText().equalsIgnoreCase("mainpanle"))
			{
				driver.switchTo().frame("mainpanle");
			}
		}
		
	}

}
