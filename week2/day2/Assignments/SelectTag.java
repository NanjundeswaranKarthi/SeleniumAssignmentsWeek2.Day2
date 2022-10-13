package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectTag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//Which is your favorite UI Automation tool?
		driver.get("https://www.leafground.com/select.xhtml");
		WebElement favorite = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select select = new Select(favorite);
		select.selectByVisibleText("Selenium");
		
		//Choose your preferred country.
		WebElement country = driver.findElement(By.id("j_idt87:country_label"));
		country.click();
		driver.findElement(By.id("j_idt87:country_3")).click();
		
		//Confirm Cities belongs to Country is loaded
		Thread.sleep(3000);
		driver.findElement(By.id("j_idt87:city")).click();
		WebElement city = driver.findElement(By.id("j_idt87:city_items"));
		String text = city.getText();
		//System.out.println(text);
		if(text.contains(text)) {
			System.out.println("verified");
		}
		else {
			System.out.println("no");
		}
		driver.findElement(By.id("j_idt87:city_2")).click();
		
		//Choose the Course
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@role='button']")).click();
		driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
		
		driver.findElement(By.xpath("//*[@role='button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='JMeter']")).click();
		
		//Choose language randomly
		driver.findElement(By.id("j_idt87:lang")).click();
		driver.findElement(By.xpath("(//*[text()='English'])[2]")).click();
		
		Thread.sleep(2000);
		
		//Select 'Two' irrespective of the language chosen
		driver.findElement(By.id("j_idt87:value_label")).click();
		driver.findElement(By.xpath("(//*[text()='Two'])[2]")).click();
		
		
		
	}

}
