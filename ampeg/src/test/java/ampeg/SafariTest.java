package ampeg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class SafariTest {

	private static final String MAC_OS_X = "Mac OS X";
	private static final String USER_DIR = System.getProperty("user.dir");
	private static final String SAFARI_MAC_DRIVER_PATH = "/src/test/resources/mac/msedgedriver";
	private static final CharSequence userName = "xrustlex";
	private static final CharSequence password = "Vadim123";
	private static final String SAFARI_WIN_DRIVER_PATH = "/src/test/resources/mac/msedgedriver.exe";
	
	@Test
	public void simpleTest() throws Exception {

		System.setProperty("webdriver.chrome.driver", USER_DIR + SAFARI_WIN_DRIVER_PATH);

		if (System.getProperty("os.name").equals(MAC_OS_X))
			System.setProperty("webdriver.edge.driver", USER_DIR + SAFARI_MAC_DRIVER_PATH);

		WebDriver driver = new SafariDriver();
		driver.manage().window().maximize();
		driver.get("https://automationstepbystep.com/");
		Thread.sleep(1000);
		driver.get("https://www.youtube.com/");
		Thread.sleep(1000);
		driver.get("https://www.facebook.com/");
		Thread.sleep(1000);
		driver.get("https://vk.com/");
		Thread.sleep(1000);
		driver.close();
		driver.quit();

		System.out.println("\n-----------------------------------end of SAFARI test-----------------------------------\n");

	}
}
