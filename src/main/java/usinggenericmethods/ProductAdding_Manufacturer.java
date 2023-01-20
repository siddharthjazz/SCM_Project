package usinggenericmethods;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.scm.GenericUtilities.DatabaseUtility;
import com.scm.GenericUtilities.ExcelUtility;
import com.scm.GenericUtilities.FileUtility;
import com.scm.GenericUtilities.JavaUtility;
import com.scm.GenericUtilities.WebDriverUtility;

public class ProductAdding_Manufacturer {

	public static void main(String[] args) throws Throwable {
		DatabaseUtility du=new DatabaseUtility();
		ExcelUtility eu=new ExcelUtility();
        FileUtility fu=new FileUtility();
        JavaUtility ju=new JavaUtility();
        WebDriverUtility wu=new WebDriverUtility();
        
        int getrandomNum=ju.getRandomNo();
        
        String url=fu.readDataFromPropertyFile("url");
        String browser=fu.readDataFromPropertyFile("browser");
        String username=fu.readDataFromPropertyFile("username");
        String password=fu.readDataFromPropertyFile("password");
        
        WebDriver driver=null;
        if(browser.equals("chrome")) {
        	driver=new ChromeDriver();
        }
        else if(browser.equals("firefox")) {
        	driver=new FirefoxDriver();
        }
        else {
        	driver=new ChromeDriver();
        }
       wu.waitForPageLaod(driver);
       driver.get(url);
       driver.findElement(By.id("login:username")).sendKeys(username);
       driver.findElement(By.id("login:password")).sendKeys(password);
       WebElement login=driver.findElement(By.id("login:type"));
       Select a=new Select(login);
       a.selectByVisibleText("Manufacturer");
       driver.findElement(By.xpath("//input[@value='Login']")).click();
       driver.findElement(By.xpath("//a[text()='Add Products']")).click();
       driver.findElement(By.id("product:name")).sendKeys("Wafer");
       driver.findElement(By.id("product:price")).sendKeys("5");
       WebElement unit=driver.findElement(By.id("product:unit"));
       Select b=new Select(unit);
       b.selectByVisibleText("PCS");
       WebElement category=driver.findElement(By.id("product:category"));
       Select c=new Select(category);
       c.selectByVisibleText("Pastry");
       driver.findElement(By.xpath("//input[@value='1']")).click();
       driver.findElement(By.id("product:description")).sendKeys("Bakery item");
       driver.findElement(By.xpath("//input[@value='Add Product']")).click();
       wu.acceptAlert(driver);
       driver.findElement(By.xpath("//a[text()='Products']")).click();
       String fetch=driver.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
       String text="Wafer";
       if(fetch.equals(text)) {
    	   System.out.println("product name is in the list");
       }
       else {
    	   System.out.println("product name is not in the list");
       }
       driver.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[8]")).click();
       driver.findElement(By.xpath("//input[@value='1']")).click();
       driver.findElement(By.xpath("//input[@value='Update Product']")).click();
       wu.acceptAlert(driver);
       String take=driver.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[3]")).getText();
       String newtext="Wafer";
       if(take.equals(newtext)) {
    	   System.out.println("Updated name is shown");
       }
       else {
    	   System.out.println("updated name is not shown");
       }
       driver.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[1]")).click();
       driver.findElement(By.xpath("//input[@value='Delete']")).click();
       wu.acceptAlert(driver);
       
       }
       
       
       
       
        }
        
        
	


