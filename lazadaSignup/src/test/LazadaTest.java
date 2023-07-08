package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class LazadaTest {

	public static WebDriver driver;

  @Parameters("browser")

  @BeforeClass


  public void beforeTest(String browser) {


  if(browser.equalsIgnoreCase("chrome")) {
	 
	  driver = new ChromeDriver();	  

  }else if (browser.equalsIgnoreCase("ie")) { 


      driver = new InternetExplorerDriver();

  } 


  driver.get("https://member.lazada.com.ph/user/register?spm=a2o4l.home.header.d6.239eca18BS6t"); 

  }

 
  @Test 
  public void birthday() throws InterruptedException {

	  WebElement dropdown1 = driver.findElement(By.xpath("//span[contains(text(),'Month')]"));
		dropdown1.click();
		WebElement dropdownValue = driver.findElement(By.cssSelector("li[value='6']"));
		dropdownValue.click();
		
		WebElement dropdown2 = driver.findElement(By.xpath("//span[contains(text(),'Day')]"));
		dropdown2.click();
		WebElement dropdownValue1 = driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/ul[1]/li[12]"));
		dropdownValue1.click();
		
		WebElement dropdown3 = driver.findElement(By.xpath("//span[contains(text(),'Year')]"));
		dropdown3.click();
		WebElement dropdownValue2 = driver.findElement(By.cssSelector("li[value='2023']"));
		dropdownValue2.click();

	}  
//  public void signup() throws InterruptedException {
//	  	File file =    new File("C:\\Users\\Arjun\\eclipse-workspace\\lazadaProject\\TestData\\LazadaTestData.xlsx");
//		FileInputStream inputStream = new FileInputStream(file);
//		XSSFWorkbook wb=new XSSFWorkbook(inputStream);
//		XSSFSheet sheet=wb.getSheet("LAZADA_USER_DATA");
//		int i;
//		int rowCount=i;
////		int rowCount=((Sheet) wb).getLastRowNum()-((Sheet) wb).getLastRowNum();
@Test
  public void ReadData() throws IOException
  {
      // Import excel sheet.
      File src=new File("C:\\Users\\Arjun\\eclipse-workspace\\lazadaSignup\\TestData\\LazadaTestData.xls");
       
      // Load the file.
      FileInputStream finput = new FileInputStream(src);
       
      // Load he workbook.
     HSSFWorkbook workbook = new HSSFWorkbook(finput);
       
      // Load the sheet in which data is stored.
      HSSFSheet sheet = workbook.getSheetAt(0);
       

      int lt;
	for (int i = 1; i & amp; lt = sheet.getLastRowNum(); i++) {
          HSSFCell cell = sheet.getRow(i).getCell(1);
//          cell.setCellType(Cell.CELL_TYPE_STRING);
         driver.findElement(By.xpath("//input[@placeholder='First Last']")).sendKeys(cell.getStringCellValue());
           
          cell = sheet.getRow(i).getCell(2);
//          cell.setCellType(Cell.CELL_TYPE_STRING);
          driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]")).sendKeys(cell.getStringCellValue());
          
          cell = sheet.getRow(i).getCell(3);
//        cell.setCellType(Cell.CELL_TYPE_STRING);
          driver.findElement(By.xpath("//input[@placeholder='Please enter your phone number']")).sendKeys(cell.getStringCellValue());
            
        WebElement checkBox = driver.findElement(By.xpath("//input[@id='enableSmsNewsletter']"));
  		checkBox.click();
  		WebElement signupButton = driver.findElement(By.xpath("//button[normalize-space()='SIGN UP']"));
  		signupButton.click();
         }
   } 
  
 
//	public void signUp() throws InterruptedException {		
//		WebElement fullnameField = driver.findElement(By.xpath("//input[@placeholder='First Last']"));
//		WebElement passwordField = driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[3]/input[1]"));
//		WebElement phoneField = driver.findElement(By.xpath("//input[@placeholder='Please enter your phone number']"));
//		
//		{
//		
//		int rowCount;
//		for(int i=1;i<=rowCount;i++) {
//			fullnameField.sendKeys(ExcelWSheet.getRow(i).getCell(0).getStringCellValue());
//			passwordField.sendKeys(ExcelWSheet.getRow(i).getCell(1).getStringCellValue());
//			phoneField.sendKeys(ExcelWSheet.getRow(i).getCell(2).getStringCellValue());
//				
//		WebElement checkBox = driver.findElement(By.xpath("//input[@id='enableSmsNewsletter']"));
//		checkBox.click();
//		WebElement signupButton = driver.findElement(By.xpath("//button[normalize-space()='SIGN UP']"));
//		signupButton.click();
//		}
//		}


  @AfterClass 
  public void afterTest() {

		driver.quit();

	}

}