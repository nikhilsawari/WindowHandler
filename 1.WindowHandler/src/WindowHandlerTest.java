import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandlerTest {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\ChromeDriver\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("marrionete", true);

		
		WebDriver driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    driver.manage().window().maximize();    
	    driver.get("http://www.popuptest.com/goodpopups.html");
	    
	    WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Good PopUp #2']")));
		
		driver.findElement(By.xpath("//a[text()='Good PopUp #2']")).click();
		
		Thread.sleep(10000);
		
		
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		
		String parentWndowID = it.next();
		System.out.println("Parent window ID: "+ parentWndowID);
		
		String childWindowID = it.next();
		System.out.println("Child window ID: " + childWindowID);
		
		driver.switchTo().window(childWindowID);
		System.out.println("child popup window title: "+ driver.getTitle());
		driver.close();
		
		driver.switchTo().window(parentWndowID);
		System.out.println("parent window title: "+ driver.getTitle());
		driver.close();
	}

}

/*
//Create object of WebDriverWait class
WebDriverWait wait=new WebDriverWait(driver,20);

//Wait till the element is not visible
WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("ur xpath here")));*/

