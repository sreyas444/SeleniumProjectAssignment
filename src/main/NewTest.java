package main;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class NewTest {
	public WebDriver driver;

	/*
	 * @Test public void scenario1() throws InterruptedException {
	 * Thread.sleep(3500); String title=driver.getTitle(); Boolean
	 * pagecheck=title.equalsIgnoreCase("Swag Labs"); assertTrue(pagecheck);
	 * driver.findElement(By.cssSelector("#user-name")).click();
	 * driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
	 * driver.findElement(By.xpath("//input[@id='password']")).click();
	 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(
	 * "secret_sauce"); driver.findElement(By.id("login-button")).click();
	 * Thread.sleep(2500); driver.findElement(By.xpath(
	 * "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	 * driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 * driver.findElement(By.cssSelector("#checkout")).click();
	 * driver.findElement(By.xpath("//input[@id='first-name']")).click();
	 * driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("abc");
	 * driver.findElement(By.xpath("//input[@id='last-name']")).click();
	 * driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("def");
	 * driver.findElement(By.xpath("//input[@id='postal-code']")).click();
	 * driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("400087")
	 * ; driver.findElement(By.id("continue")).click();
	 * driver.findElement(By.id("finish")).click(); String
	 * confirmationMsg=driver.findElement(By.xpath(
	 * "//div[@id='checkout_complete_container']/h2")).getText(); Boolean
	 * confirmMessage=confirmationMsg.equals("THANK YOU FOR YOUR ORDER");
	 * assertTrue(confirmMessage); Thread.sleep(3000); }
	 */
	/*
	 * @Test public void scenario2() throws InterruptedException {
	 * Thread.sleep(3500); String title=driver.getTitle(); Boolean
	 * pagecheck=title.equalsIgnoreCase("Swag Labs"); assertTrue(pagecheck);
	 * driver.findElement(By.cssSelector("#user-name")).click();
	 * driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
	 * driver.findElement(By.xpath("//input[@id='password']")).click();
	 * driver.findElement(By.xpath("//input[@id='password']")).sendKeys(
	 * "secret_sauce"); driver.findElement(By.id("login-button")).click();
	 * Thread.sleep(2500); driver.findElement(By.xpath(
	 * "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	 * driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 * Thread.sleep(2000);
	 * driver.findElement(By.xpath("//button[@id='remove-sauce-labs-bolt-t-shirt']")
	 * ).click(); Thread.sleep(2000);
	 * driver.findElement(By.id("continue-shopping")).click();
	 * driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"
	 * )).click();
	 * driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
	 * Thread.sleep(2000); driver.findElement(By.cssSelector("#checkout")).click();
	 * driver.findElement(By.xpath("//input[@id='first-name']")).click();
	 * driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("abc");
	 * driver.findElement(By.xpath("//input[@id='last-name']")).click();
	 * driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("def");
	 * driver.findElement(By.xpath("//input[@id='postal-code']")).click();
	 * driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("400087")
	 * ; driver.findElement(By.id("continue")).click();
	 * driver.findElement(By.id("finish")).click(); String
	 * confirmationMsg=driver.findElement(By.xpath(
	 * "//div[@id='checkout_complete_container']/h2")).getText(); Boolean
	 * confirmMessage=confirmationMsg.equals("THANK YOU FOR YOUR ORDER");
	 * assertTrue(confirmMessage); Thread.sleep(3000); }
	 */

	@Test
	public void scenario3() throws InterruptedException {
		homepageValidation();
		login();
		Select filterSort = new Select(driver.findElement(By.xpath("//select[@class='product_sort_container']")));
		filterSort.selectByVisibleText("Price (low to high)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#checkout")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).click();
		driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("abc");
		driver.findElement(By.xpath("//input[@id='last-name']")).click();
		driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("def");
		driver.findElement(By.xpath("//input[@id='postal-code']")).click();
		driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys("400087");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("finish")).click();
		String confirmationMsg = driver.findElement(By.xpath("//div[@id='checkout_complete_container']/h2")).getText();
		Boolean confirmMessage = confirmationMsg.equals("THANK YOU FOR YOUR ORDER");
		assertTrue(confirmMessage);
		Thread.sleep(3000);

	}

	public void homepageValidation() throws InterruptedException {
		Thread.sleep(3500);
		String title = driver.getTitle();
		Boolean pagecheck = title.equalsIgnoreCase("Swag Labs");
		assertTrue(pagecheck);
	}

	public void login() throws InterruptedException {
		driver.findElement(By.cssSelector("#user-name")).click();
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@id='password']")).click();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		Thread.sleep(2500);
	}

	@BeforeTest
	public void beforeTest() {
		String currentDir = System.getProperty("user.dir");
		String driverPath = currentDir + "\\src\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com");
		driver.manage().window().maximize();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
