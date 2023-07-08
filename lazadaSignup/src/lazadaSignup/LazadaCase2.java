package lazadaSignup;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;

import com.beust.jcommander.Parameters;
public class LazadaCase2 {

	private WebDriver driver;
	   private String URL = "http://www.calculator.net";

//	   @SuppressWarnings("deprecation")
//	@Parameters("browser")
//	   @BeforeTest
	   public void launchapp(String browser) {

	      if (browser.equalsIgnoreCase("firefox")) {
	         System.out.println(" Executing on FireFox");
	         driver = new FirefoxDriver();
	         driver.get(URL);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         driver.manage().window().maximize();
	      } else if (browser.equalsIgnoreCase("chrome")) {
	         System.out.println(" Executing on CHROME");
	         System.out.println("Executing on IE");
	         System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
	         driver = new ChromeDriver();
	         driver.get(URL);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         driver.manage().window().maximize();
	      } else if (browser.equalsIgnoreCase("ie")) {
	         System.out.println("Executing on IE");
	         System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
	         driver = new InternetExplorerDriver();
	         driver.get(URL);
	         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	         driver.manage().window().maximize();
	      } else {
	         throw new IllegalArgumentException("The Browser Type is Undefined");
	      }
	   }

//	   @Test
	   public void calculatepercent() {
	      // Click on Math Calculators
	      driver.findElement(By.xpath(".//*[@id = 'menu']/div[3]/a")).click();

	      // Click on Percent Calculators
	      driver.findElement(By.xpath(".//*[@id = 'menu']/div[4]/div[3]/a")).click();

	      // Enter value 10 in the first number of the percent Calculator
	      driver.findElement(By.id("cpar1")).sendKeys("10");

	      // Enter value 50 in the second number of the percent Calculator
	      driver.findElement(By.id("cpar2")).sendKeys("50");

	      // Click Calculate Button
	      driver.findElement(By.xpath(".//*[@id = 'content']/table/tbody/tr/td[2]/input")).click();

	      // Get the Result Text based on its xpath
	      String result =
	         driver.findElement(By.xpath(".//*[@id = 'content']/p[2]/span/font/b")).getText();		 

	      // Print a Log In message to the screen
	      System.out.println(" The Result is " + result);

	      if(result.equals("5")) {
	         System.out.println(" The Result is Pass");
	      } else {
	         System.out.println(" The Result is Fail");
	      }
	   }

	   @AfterTest
	   public void closeBrowser() {
	      driver.close();
	   }
	}
