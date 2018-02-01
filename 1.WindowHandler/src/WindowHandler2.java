import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WindowHandler2 {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\ChromeDriver\\chromedriver.exe");
		DesiredCapabilities capabilites = new DesiredCapabilities().chrome();
		capabilites.setCapability("marionette", true);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//dynamic wait
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				
				driver.get("https://www.freecrm.com/index.html");
				driver.findElement(By.name("username")).sendKeys("naveenk");
				driver.findElement(By.name("password")).sendKeys("test@123");
				//driver.navigate().refresh();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@value='Login']")).click();
				Thread.sleep(5000);
				System.out.println(driver.getWindowHandle());
		
	}

}
