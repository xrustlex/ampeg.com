package ampeg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginAndLogOutTest {
	
	private CharSequence userName = "xrustlex";
	private CharSequence password = "Vadim123";

	@Test
	void canLoginAndLogout() {

		String userDir = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/mac/chromedriver");
		WebDriver driver = new ChromeDriver();

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

/*
		driver.findElement(By.cssSelector("input#l_email")).sendKeys(email);		
		driver.findElement(By.cssSelector("input#l_user")).sendKeys(userName);	
		driver.findElement(By.cssSelector("input#l_first")).sendKeys(firstName);
		driver.findElement(By.cssSelector("input#l_last")).sendKeys(lastName);
		driver.findElement(By.cssSelector("input#l_pass")).sendKeys(password);
		driver.findElement(By.cssSelector("input#l_pass_repeat")).sendKeys(password);
		driver.findElement(By.cssSelector("input[class='btn btn-success']")).click();
*/
		//assertTrue(driver.getCurrentUrl() == "https://ampeg.com/account/");

	}
}
