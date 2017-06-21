package samples;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SeleniumSample {

	public static void main(String[] args) {

		// Invoke browser
		WebDriver driver;
		//driver = new FirefoxDriver();
		//System.setProperty("webdriver.firefox.marionette", "C:\\Software\\SeleniumTestNGProject\\geckodriver.exe");
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Software\\SeleniumTestNGProject\\chromedriver.exe");
		
		/*
		 * Wait Implicit wait - used to set the default waiting time throughout
		 * the program Explicit wait - used to set the waiting time for a
		 * particular instance only
		 */

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String baseUrl = "http://newtours.demoaut.com";

		// launch Firefox and direct it to the Base URL
		driver.get(baseUrl);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));

		// if(userName.isEnabled()){
		userName.sendKeys("admin");
		// }

		/*
		 * locating Elements By.className By.cssSelector By.id By.linkText
		 * By.name By.partialLinkText By.tagName By.xpath
		 */

		// get locators for password and login
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("mercury");

		driver.findElement(By.name("login")).click();

		String expectedTitle = "Find a Flight: Mercury Tours:";
		String actualTitle = "";

		// get the actual value of the title
		actualTitle = driver.getTitle();

		/*
		 * getTitle() getPageSource() getCurrentUrl() getText()
		 */

		// Storing Title name in the String variable
		String title = driver.getTitle();

		// Storing Title length in the Int variable
		int titleLength = driver.getTitle().length();

		// Printing Title & Title length in the Console window
		System.out.println("Title of the page is : " + title);
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
		driver.navigate().to("http://newtours.demoaut.com/mercuryreservation.php");
		System.out.println("Title of the page is : " + driver.getTitle());

		/*
		 * Navigate commands navigate().to() navigate().refresh()
		 * navigate().back() navigate().forward()
		 */

		// select fromPort dropdown
		Select fromPortDropdown = new Select(driver.findElement(By.name("fromPort")));
		// fromPortDropdown.selectByVisibleText("New York ");
		// fromPortDropdown.selectByIndex(1);
		fromPortDropdown.selectByValue("New York");

		// select a radio button
		driver.findElement(By.xpath("//input[@value='Business']")).click();

		// click continue button
		driver.findElement(By.xpath("//input[@name='findFlights']")).click();

		// verify Depart city
		String expectedDepartCity = "New York to Acapulco";
		WebElement actualDepartCity = driver.findElement(By.xpath("//font[contains(.,'New York')]"));
		System.out.println("Actual DepartCity is : " + actualDepartCity.getText().trim());
		System.out.println("Expected DepartCity is : " + expectedDepartCity);
		Assert.assertEquals(actualDepartCity.getText().trim(), expectedDepartCity);

		// click continue button
		driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();

		// Input text in the textbox
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

		/*
		 * close Browser Window close() - closes the current window quit() -
		 * closes all the windows that WebDriver has opened
		 */
		driver.close();

		// exit the program explicitly
		System.exit(0);
	}
}
