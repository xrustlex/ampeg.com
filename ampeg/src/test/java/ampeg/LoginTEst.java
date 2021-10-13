package ampeg;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class LoginTEst {

	@Test
	void canClickOnCreateAccount() {

		String userDir = System.getProperty("user.dir");		
		System.setProperty("webdriver.chrome.driver", userDir + "/src/test/resources/mac/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://ampeg.com/index.html");
		WebElement accountLoginIcon = driver.findElement(By.cssSelector("span[class='header-button-account glyphicon glyphicon-user ']"));
		accountLoginIcon.click();

		WebElement createAccountButton = driver.findElement(By.cssSelector("button[class='btn-signin btn btn-default']"));
		createAccountButton.click();
		String createAccountUrl = "https://ampeg.com/account/create.html";
		String currentUrl = driver.getCurrentUrl();

		assertEquals(currentUrl, createAccountUrl);

		driver.close();
		driver.quit();

	}
}
