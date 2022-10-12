package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.leafground.com/checkbox.xhtml");
		
		//Basic Checkbox
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89']//div[2]")).click();
		
		//Notification
		driver.findElement(By.xpath("//div[@id='j_idt87:j_idt91']//div[2]")).click();
		
		//Choose your favorite language(s)
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget'])[1]")).click();
		driver.findElement(By.xpath("(//div[@class='ui-chkbox ui-widget'])[2]")).click();
		
		//Tri State Checkbox
		driver.findElement(By.id("j_idt87:ajaxTriState")).click();
		
		//Toggle Switch
		driver.findElement(By.id("j_idt87:j_idt100")).click();
		
		
		//Select Multiple
		driver.findElement(By.xpath("//*[@data-label=\"Cities\"]")).click();
		driver.findElement(By.xpath("(//*[@role='group']//li//div[1])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-item-value='Barcelona']//div[2]")).click();
		driver.findElement(By.xpath("//*[@data-label=\"Cities\"]")).click();
		
		//Verify if check box is disabled
		WebElement checkBoxIsDisabled = driver.findElement(By.id("j_idt87:j_idt102"));
		boolean enabled = checkBoxIsDisabled.isEnabled();
		System.out.println(enabled);

	}

}
