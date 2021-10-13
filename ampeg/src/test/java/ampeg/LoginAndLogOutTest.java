package ampeg;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

class LoginAndLogOutTest {

	private final String OS 			 = System.getProperty("os.name");
	private final String MAC_OS_X 		 = "Mac OS X";
	private final String USER_DIR 		 = System.getProperty("user.dir");
	private final String MAC_DRIVER_PATH = "/src/test/resources/mac/chromedriver";
	private final String WIN_DRIVER_PATH = "/src/test/resources/win/chromedriver.exe";
	private final CharSequence userName  = "xrustlex";
	private final CharSequence password  = "Vadim123";
	private RemoteWebDriver driver	  	 = null;

	@Test
	public void canLoginAndLogout() {

		System.out.print("Starting canLoginAndLogout test on " + System.getProperty("os.name"));
		System.setProperty("webdriver.chrome.driver", USER_DIR + WIN_DRIVER_PATH);
		if (System.getProperty("os.name").equals(MAC_OS_X))	System.setProperty("webdriver.chrome.driver", USER_DIR + MAC_DRIVER_PATH);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ampeg.com/index.html");
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user loggedinprofile']")).click();
		driver.findElement(By.cssSelector("a[href='?action=logout']")).click();

		assertEquals(driver.getCurrentUrl(), "https://ampeg.com/index.html");

		driver.close();
		driver.quit();

	}

	@Test
	public void cannotLoginWithoutPassword() {

		System.out.print("Starting canLoginAndLogout test on " + OS);
		System.setProperty("webdriver.chrome.driver", USER_DIR + WIN_DRIVER_PATH);
		if (System.getProperty("os.name").equals(MAC_OS_X))	System.setProperty("webdriver.chrome.driver", USER_DIR + MAC_DRIVER_PATH);

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ampeg.com/index.html");
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys(userName);
		driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys(password);
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user loggedinprofile']")).click();
		driver.findElement(By.cssSelector("a[href='?action=logout']")).click();

		assertEquals(driver.getCurrentUrl(), "https://ampeg.com/index.html");

		driver.close();
		driver.quit();

	}
}





