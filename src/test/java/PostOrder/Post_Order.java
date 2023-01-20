package PostOrder;

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

public class Post_Order {

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
		s.selectByVisibleText("Retailer");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.findElement(By.xpath("//a[text()='New Order']")).click();
		driver.findElement(By.id("2")).sendKeys("5");
		driver.findElement(By.id("btnSubmit")).click();
		String fetch=driver.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[1]")).getText();
		driver.findElement(By.xpath("(//tbody)[2]/tr[last()]/td[5]")).click();
		String derive=driver.findElement(By.xpath("(//tbody)[2]/tr[1]/td[2]")).getText();
		if(fetch.equals(derive)) {
			System.out.println("details are shown as per passed data");
		}
		else {
			System.out.println("details are not shown as per passed data");
		}
		
		
		
		
		
		
		

	}

}
