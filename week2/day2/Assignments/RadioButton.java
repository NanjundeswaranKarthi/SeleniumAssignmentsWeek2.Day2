package week2.day2.Assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButton {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/radio.xhtml");

		// Your most favorite browser
		driver.findElement(By.xpath("//*[@id=\"j_idt87:console1\"]/tbody/tr/td[1]/div/div[2]")).click();


		//Find the default select radio button

		WebElement check = driver.findElement(By.id("j_idt87:console2:0")); 
		boolean status =check.isSelected(); 
		System.out.println(status);

		WebElement check2 = driver.findElement(By.id("j_idt87:console2:1"));
		boolean status2 = check2.isSelected(); 
		System.out.println(status2);


		WebElement check3 = driver.findElement(By.xpath("(//*[@checked='checked'])[4]"));
		boolean status3 = check3.isSelected();
		System.out.println(status3);
		if(status3==true) {
			System.out.println("default select radio button is Safari");
		}
		
		WebElement check4 = driver.findElement(By.xpath("//*[@id=\"j_idt87:console2\"]/tbody/tr/td[4]/div/div[2]")); 
		boolean status4 = check4.isSelected(); 
		System.out.println(status4);
		
		//Select the age group (only if not selected)
		Thread.sleep(2000);
		WebElement findElement = driver.findElement(By.xpath("//div[@id='j_idt87:age']/div[1]/div[1]/div[1]/div[2]/span[1]"));
		findElement.click();

	}

}
