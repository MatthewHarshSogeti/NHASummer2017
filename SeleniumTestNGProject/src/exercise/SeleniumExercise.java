package exercise;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SeleniumExercise {

	public static void main(String[] args) {

        // Invoke browser
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Software\\SeleniumTestNGProject\\chromedriver.exe");
		driver = new ChromeDriver();
    	       
        /* Wait
        Implicit wait - used to set the default waiting time throughout the program
        Explicit wait - used to set the waiting time for a particular instance only
        */
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        String baseUrl = "http://newtours.demoaut.com";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
 
        // launch Firefox and direct it to the Base URL
        
        
        //enter username in the textbox
        WebElement userName = driver.findElement(By.name(""));
        
       
       /* locating Elements
        By.className
        By.cssSelector
        By.id
        By.linkText
        By.name
        By.partialLinkText
        By.tagName
        By.xpath
      */
        
        
        /* 
         * WebElement password = driver.findElement----;
           password.----("mercury");
        */
        
        //click login button
        //driver.-----.-----;
 
        // get the actual value of the title
        
        
        /*
         getTitle()
         getPageSource()
         getCurrentUrl()
         getText()
         
         */
        
         // Storing Title name in the String variable
     	  // String title = driver.-----;
      
     	// Storing Title length in the Int variable
     	   //int titleLength = 
      
     	// Printing Title & Title length in the Console window
     	   //System.out.println("Title of the page is : " + title);
     	   //System.out.println("Length of the title is : "+ titleLength);
              
 
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
  
        
        List<WebElement> linkElements = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: "+linkElements.size());
        
        /*for(){
        	//;
        }*/
	    
        //Click on Car Rentals link
        //WebElement carRentals = driver.findElement(By.xpath(---));
                      
       /* Navigate commands
        navigate().to()
        navigate().refresh()
        navigate().back()
        navigate().forward()
      */
        
        // Navigate to Flight Reservations page
       
        
        // select city fromPort dropdown
        
        
        //select a radio button
        
        
        //click continue button
        
 
        //verify Depart city
        
       // Assert.assertEquals(actualDepartCity, expectedDepartCity);
        
       //click continue button
        
        
        //Input text in the textbox
                
       //Input last name in the textbox
        
        
      //Input Credit card number
        
        
      //click secure Purchase button
        
        
        //Assert text itinerary has been booked
        
        
        //Navigate back to Home
        
        
        /* close Browser Window
           close() - closes the current window
         * quit() - closes all the windows that WebDriver has opened
        */
        driver.close();
        
        // exit the program explicitly
        System.exit(0);
      
	}
}