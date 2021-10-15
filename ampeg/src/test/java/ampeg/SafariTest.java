package ampeg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SafariTest {

	private static final String BASE_URL = "https://ampeg.com/index.html"; 
	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String SAFARI_MAC_DRIVER_PATH = "/src/test/resources/mac/safaridriver";
	private CharSequence userName = "vadim";
	private WebElement alertMessage = null;

	@Test
	public void canLoginTest() throws Exception {

		System.setProperty("webdriver.safari.driver", USER_DIR + SAFARI_MAC_DRIVER_PATH);
		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get(BASE_URL);
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']"))
		.click();
		driver.findElement(By.cssSelector("input[placeholder='Username']"))
		.sendKeys(userName );
		driver.findElement(By.cssSelector("button[type='submit']"))
		.click();	
		//driver.findElement(By.cssSelector("p:contains('Unable to login')"));
		
		driver.close();

	}

}
