package new_order;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class CheckDataflow {

	public static void main(String[] args) throws Throwable{
		//1.steps to fetch common data
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL=p.getProperty("url");
		String USERNAME=p.getProperty("username");
		String PASSWORD=p.getProperty("password");
		String BROWSER=p.getProperty("browser");
		System.out.println(URL);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement get=driver.findElement(By.id("login:type"));
		Select s=new Select(get);
		s.selectByVisibleText("Retailer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[text()='New Order']")).click();
		driver.findElement(By.id("1")).sendKeys("5");
		driver.findElement(By.id("btnSubmit")).click();
		driver.findElement(By.xpath("(//input[@class='submit_button'])[1]")).click();
		driver.findElement(By.id("login:username")).sendKeys("admin");
		driver.findElement(By.id("login:password")).sendKeys("admin123");
		WebElement fetch=driver.findElement(By.id("login:type"));
		Select sel=new Select(fetch);
		sel.selectByVisibleText("Admin");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Orders']")).click();
		
		
		
		
		
		
		

	}

}
