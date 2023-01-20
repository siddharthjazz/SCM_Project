package practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefoxprac {

	public static void main(String[] args) {
		
		WebDriver driver=new FirefoxDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");

	}

}
