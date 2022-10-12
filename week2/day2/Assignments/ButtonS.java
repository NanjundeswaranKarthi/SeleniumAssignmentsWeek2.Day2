package week2.day2.Assignments;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.graphbuilder.curve.Point;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ButtonS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/button.xhtml");
		
		//Click and Confirm title.
		driver.findElement(By.xpath("//*[text()='Click']")).click();
		String title = driver.getTitle();
		driver.navigate().back();
		if(title.contains("Dashboard")) {
			System.out.println("Verified");
		}
		
		//Confirm if the button is disabled.
		WebElement disabled = driver.findElement(By.id("j_idt88:j_idt92"));
		boolean isDisabled = disabled.isEnabled();
		System.out.println(isDisabled);
		
		
		//Find the position of the Submit button
		WebElement position = driver.findElement(By.id("j_idt88:j_idt94"));
		org.openqa.selenium.Point location = position.getLocation();
		System.out.println(location);
		
		//Find the Save button color
		WebElement findcolour = driver.findElement(By.id("j_idt88:j_idt96"));
		System.out.println(findcolour.getCssValue("background"));
		
		
		//Find the height and width of this button
		WebElement heightAndwidth = driver.findElement(By.id("j_idt88:j_idt98"));
		int height = heightAndwidth.getSize().getHeight();
		int width = heightAndwidth.getSize().getWidth();
		System.out.println("height is"+height);
		System.out.println("widgth is"+width);
		
		//Mouse over and confirm the color changed
		WebElement findcolourChange = driver.findElement(By.id("j_idt88:j_idt100"));
		String firstColour = findcolourChange.getCssValue("background-color");
		System.out.println(firstColour);
		
		Actions action = new Actions(driver);
		action.moveToElement(findcolourChange).build().perform();
		WebElement findcolourChange2 = driver.findElement(By.id("j_idt88:j_idt100"));
		String secondcolour = findcolourChange2.getCssValue("background-color");
		System.out.println(secondcolour);
		if(firstColour==secondcolour) {
			System.out.println("not changed");
		}
		else {
			System.out.println("changed");
		}
		
		//Click Image Button and Click on any hidden button
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();
		driver.findElement(By.id("j_idt88:j_idt102:imageBtn")).click();

	}

}
