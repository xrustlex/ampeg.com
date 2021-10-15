package ampeg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class SafariTest {

	private static final String MAC_OS_X = "Mac OS X";
	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String SAFARI_MAC_DRIVER_PATH = "/src/test/resources/mac/msedgedriver";
	private static final CharSequence userName = "xrustlex";
	private static final CharSequence password = "Vadim123";
	private static final String SAFARI_WIN_DRIVER_PATH = "/src/test/resources/mac/msedgedriver.exe";
	
	@Test
	public void canLoginTest() throws Exception {

		System.setProperty("webdriver.chrome.driver", USER_DIR + SAFARI_WIN_DRIVER_PATH);

		if (System.getProperty("os.name").equals(MAC_OS_X))
			System.setProperty("webdriver.edge.driver", USER_DIR + SAFARI_MAC_DRIVER_PATH);

		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://ampeg.com/index.html");
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']"))
		.click();
		driver.findElement(By.cssSelector("input[placeholder='Username']"))
		.sendKeys(userName);
		driver.findElement(By.cssSelector("input[placeholder='Password']"))
		.sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']"))
		.click();
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user loggedinprofile']"))
		.click();
		driver.findElement(By.cssSelector("a[href='?action=logout']")).click();

		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://ampeg.com/index.html");

		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']"))
		.click();
		driver.findElement(By.cssSelector("input[placeholder='Username']"))
		.sendKeys(userName);
		driver.findElement(By.cssSelector("button[type='submit']"))
		.click();

		AssertJUnit.assertEquals(driver.getCurrentUrl(), "https://ampeg.com/account/login.html");

		driver.close();
		driver.quit();

		System.out.println("\n-----------------------------------end of SAFARI test-----------------------------------\n");

	}
}
