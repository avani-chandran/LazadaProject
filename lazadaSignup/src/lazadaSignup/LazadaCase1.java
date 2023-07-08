package lazadaSignup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LazadaCase1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("Lazada User Register Page Test");
				//System.setProperty("Webdriver.chrome.driver","C:\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				driver.get("https://member.lazada.com.ph/user/register?spm=a2o4l.home.header.d6.239eca18BS6t");


				WebElement dropdown1 = driver.findElement(By.xpath("//span[contains(text(),'Month')]"));
				dropdown1.click();
				WebElement dropdownValue = driver.findElement(By.cssSelector("li[value='6']"));
				//WebElement dropdownValue = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[6]"));
				dropdownValue.click();
				
				WebElement dropdown2 = driver.findElement(By.xpath("//span[contains(text(),'Day')]"));
				dropdown2.click();
//				WebElement dropdownValue1 = driver.findElement(By.cssSelector("li[value='12']"));
				WebElement dropdownValue1 = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[12]"));
				dropdownValue1.click();
				
				WebElement dropdown3 = driver.findElement(By.xpath("//span[contains(text(),'Year')]"));
				dropdown3.click();
				WebElement dropdownValue2 = driver.findElement(By.cssSelector("li[value='2023']"));
				//WebElement dropdownValue2 = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[1]"));
				dropdownValue2.click();
				
				driver.quit();
				
				

	}

}
