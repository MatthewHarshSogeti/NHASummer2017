package samples;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * NGTestsSuite class, collection of tests
 * 
 * @author mharsh
 *
 */
public class NGTestSuite {

	// Class variables
	public WebDriver driver;
	public String testUrl = "http://newtours.demoaut.com/";

	/**
	 * openApplication method, driver gets URL and maximizes the browser
	 */
	@BeforeClass
	public void openApplication() {

		// Open the application url
		driver.get(testUrl);

		// maximize the browser window
		driver.manage().window().maximize();
	}
	
	/**
	 * signIn method, tests sign in
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2)
	public void signIn() throws InterruptedException {

		// enter a valid username in the textbox
		WebElement username = driver.findElement(By.name("userName"));
		username.clear();
		username.sendKeys("admin");

		// enter a valid password in the password textbox
		WebElement password = driver.findElement(By.name("password"));
		password.clear();
		password.sendKeys("mercury");

		// click on the Sign in button
		WebElement SignInButton = driver.findElement(By.name("login"));
		SignInButton.click();

		// Sleep for rendering
		Thread.sleep(1000);
	}

	/**
	 * verifyTitle method, test verifies title is as expected
	 * 
	 * @throws InterruptedException
	 */
	@Test(groups = { "priority=1" })
	public void verifyTitle() throws InterruptedException {
		// declare and initialize the variable to store the expected title of
		// the webpage.
		String expectedTitle = "Welcome: Mercury Tours";

		// fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();

		// Storing Title length in the Int variable
		int titleLength = driver.getTitle().length();

		// Printing Title & Title length in the Console window
		System.out.println("Title of the page is : " + actualTitle);
		System.out.println("Length of the title is : " + titleLength);

		/*
		 * compare the actual title of the page with the expected one and print
		 * the result as "Passed" or "Failed"
		 */
		if (actualTitle.contentEquals(expectedTitle)) {
			System.out.println("Test Passed!");
		} else {
			System.out.println("Test Failed");
		}
		
		// Sleep for rendering
		Thread.sleep(1000);
	}

	/**
	 * verifyLinkElements method, test verifies that link elements have been verified
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 3)
	public void verifyLinkElements() throws InterruptedException {

		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		// List<WebElement> linkElements =
		// driver.findElements(By.partialLinkText("mercury"));
		// List<WebElement> linkElements = driver.findElements(By.xpath(""));
		System.out.println("Number of links: " + linkElements.size());

		for (int i = 0; i < linkElements.size(); i++) {
			System.out.println(linkElements.get(i).getText());
		}

		WebElement carRentals = driver.findElement(By.xpath("//a[text()='Car Rentals']"));
		System.out.println(carRentals.getText());
		carRentals.click();
		System.out.println("Title of the page is : " + driver.getTitle());
		driver.navigate().back();
		System.out.println("Title of the page is : " + driver.getTitle());
		driver.navigate().forward();
		System.out.println("Title of the page is : " + driver.getTitle());
		driver.navigate().to("http://newtours.demoaut.com/mercurycruise.php");
		System.out.println("Title of the page is : " + driver.getTitle());
		driver.navigate().back();

		// Sleep for rendering 
		Thread.sleep(1000);
	}

	/**
	 * flightDetails method, test selects a destination, flight class and clicks find flights 
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void flightDetails() throws InterruptedException {

		driver.navigate().to("http://newtours.demoaut.com/mercuryreservation.php");
		System.out.println("Title of the page is : " + driver.getTitle());

		// select fromPort dropdown
		Select fromPortDropdown = new Select(driver.findElement(By.name("fromPort")));
		// fromPortDropdown.selectByVisibleText("New York ");
		// fromPortDropdown.selectByIndex(1);
		fromPortDropdown.selectByValue("New York");

		// select a radio button
		driver.findElement(By.xpath("//input[@value='Business']")).click();

		// click continue button
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();

		// Sleep for rendering
		Thread.sleep(1000);
	}

	/**
	 * verifyDepartCity method, test verifies city departed and reserves slights
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 6)
	public void verifyDepartCity() throws InterruptedException {

		// verify Depart city
		String expectedDepartCity = "New York to Acapulco";
		WebElement actualDepartCity = driver.findElement(By.xpath("//font[contains(.,'New York')]"));
		System.out.println("Actual DepartCity is : " + actualDepartCity.getText().trim());
		System.out.println("Expected DepartCity is : " + expectedDepartCity);
		Assert.assertEquals(actualDepartCity.getText().trim(), expectedDepartCity);

		// click continue button
		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		
		// Sleep for rendering
		Thread.sleep(1000);
	}

	/**
	 * securePurchase method, tests inputs full name, credit card and clicks purchase
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 7)
	public void securePurchase() throws InterruptedException {

		// Input first name in the textbox
		WebElement firstName = driver.findElement(By.xpath("//input[@name='passFirst0']"));
		firstName.sendKeys("NHA");

		// Input last name in the textbox
		WebElement lastName = driver.findElement(By.xpath("//input[@name='passLast0']"));
		lastName.sendKeys("Member");

		// Input Credit card number
		WebElement ccNumber = driver.findElement(By.xpath("//input[@name='creditnumber']"));
		ccNumber.sendKeys("123456");

		// click secure Purchase button
		driver.findElement(By.xpath("//input[@name='buyFlights']")).click();
		
		// Sleep for rendering
		Thread.sleep(1000);
	}

	/**
	 * flightConfirmation method, tests itinerary was booked and navigates to homepage
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 8)
	public void flightConfirmation() throws InterruptedException {

		// Assert text itinerary has been booked
		String expectedItineraryText = "Your itinerary has been booked!";
		WebElement actualItineraryText = driver
				.findElement(By.xpath("//td//font[contains(text(),'itinerary has been booked')]"));
		System.out.println("actualItineraryText is : " + actualItineraryText.getText().trim());
		System.out.println("expectedItineraryText is : " + expectedItineraryText);
		Assert.assertEquals(actualItineraryText.getText().trim(), expectedItineraryText);

		// Navigate back to Home
		driver.navigate().to("http://newtours.demoaut.com/mercurywelcome.php");
		System.out.println("Title of the page is : " + driver.getTitle());

		// Sleep for rendering
		Thread.sleep(1000);
	}

	/**
	 * launchBrowser method, launches browser depending on driver/property used
	 */
	@BeforeSuite
	public void launchBrowser() {
		driver = new FirefoxDriver();
		System.setProperty("webdriver.firefox.marionette",
				"C:\\Users\\mharsh\\Downloads\\SeleniumTestNGProject\\geckodriver.exe");
	}

	/**
	 * closeBrowser method, closes browser under test
	 */
	@AfterSuite
	public void closeBrowser() {
		driver.quit();
	}
}