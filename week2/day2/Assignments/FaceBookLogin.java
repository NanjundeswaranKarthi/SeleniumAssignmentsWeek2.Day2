package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//load the URL
		driver.get("http://en-gb.facebook.com");
		//driver.manage().window().maximize();
		
		//click on Create New Account
		driver.findElement(By.linkText("Create New Account")).click();
		
		//Enter firstName
		driver.findElement(By.name("firstname")).sendKeys("karthi");
		
		//Enter lastName
		driver.findElement(By.name("lastname")).sendKeys("Nanjundeswaran");
		
		//Enter mobileNumber
		driver.findElement(By.name("reg_email__")).sendKeys("004298732176420");	
		
		WebElement date = driver.findElement(By.name("birthday_day"));
		Select birthdate = new Select(date);
		birthdate.selectByValue("7");
		
		WebElement month = driver.findElement(By.id("month"));
		Select birthMonth = new Select(month);
		birthMonth.selectByValue("7");
		
		WebElement year = driver.findElement(By.id("year"));
		Select birthyear = new Select(year);
		birthyear.selectByValue("1947");
		
		
		driver.findElement(By.xpath("(//*[@name='sex'])[2]")).click();
		
		
		
		
	}

}
