package ampeg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class EdgeTests {

	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String EDGE_MAC_DRIVER_PATH = "/src/test/resources/mac/msedgedriver";
	private CharSequence userName = "vadim";

	@Test
	public void canLoginTest() {

		System.setProperty("webdriver.edge.driver", USER_DIR + EDGE_MAC_DRIVER_PATH);
		EdgeOptions options = new EdgeOptions(); 
		WebDriver driver = new EdgeDriver(options);

		driver.get("https://ampeg.com/index.html");
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']"))
		.click();
		driver.findElement(By.cssSelector("input[placeholder='Username']"))
		.sendKeys(userName );
		driver.findElement(By.cssSelector("button[type='submit']"))
		.click();

		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://ampeg.com/account/login.html");

		driver.close();
		driver.quit();
	}

	@Test
	public void cannotLoginWithEmptyPassword() {
		
		System.setProperty("webdriver.edge.driver", USER_DIR + EDGE_MAC_DRIVER_PATH);
		EdgeOptions options = new EdgeOptions(); 
		WebDriver driver = new EdgeDriver(options);
		driver.get("https://ampeg.com/index.html");
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']"))
		.click();
		driver.findElement(By.cssSelector("input[placeholder='Username']"))
		.sendKeys(userName);
		driver.findElement(By.cssSelector("button[type='submit']"))
		.click();

		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://ampeg.com/account/login.html");

		driver.close();
		driver.quit();

	}
}
