package usinggenericmethods;

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

public class New_Order_Module {

	public static void main(String[] args) throws Throwable {
		
		ExcelUtility eu = new ExcelUtility();
		FileUtility fu = new FileUtility();
		DatabaseUtility du = new DatabaseUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();
		int randomNum = ju.getRandomNo();
		String url = fu.readDataFromPropertyFile("url");
		String username =fu.readDataFromPropertyFile("username");
		String password = fu.readDataFromPropertyFile("password");
		String browser=fu.readDataFromPropertyFile("browser");
		
		WebDriver driver=null;
		if(browser.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new ChromeDriver();
		}
		 wu.waitForPageLaod(driver);
		 driver.get(url);
		 driver.findElement(By.id("login:username")).sendKeys("admin");
		 driver.findElement(By.id("login:password")).sendKeys("admin123");
		 WebElement login = driver.findElement(By.id("login:type"));
		 Select a=new Select(login);
		 a.selectByVisibleText("Retailer");
		 driver.findElement(By.xpath("//input[@value='Login']")).click();
		 driver.findElement(By.xpath("//a[text()='New Order']")).click();
		 driver.findElement(By.id("1")).sendKeys("10");
		 driver.findElement(By.id("btnSubmit")).click();
		 
		}
		
		
		

	}


