package ProductAddingManufacturer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Product_Adding_Manufacturer {

	public static void main(String[] args) throws IOException {
		//1.Steps to fetch common data
		FileInputStream fis=new FileInputStream(".//src//test//resources//CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		String BROWSER=p.getProperty("browser");
		System.out.println(URL);
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		
		WebElement get=driver.findElement(By.id("login:type"));
		Select s=new Select(get);
		s.selectByVisibleText("Manufacturer");
		
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
		driver.findElement(By.xpath("//a[text()='Add Products']")).click();
		driver.findElement(By.id("product:name")).sendKeys("Pastry");
		driver.findElement(By.id("product:price")).sendKeys("10");
		
		WebElement take=driver.findElement(By.id("product:unit"));
		Select x=new Select(take);
		x.selectByVisibleText("PCS");
		
		WebElement require=driver.findElement(By.id("product:category"));
		Select a=new Select(require);
		a.selectByVisibleText("Pastry");
		
		driver.findElement(By.xpath("//input[@value='1']")).click();
		

	}

}
