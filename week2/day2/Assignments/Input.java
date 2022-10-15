package week2.day2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Input {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/input.xhtml");

		// Type your name
		driver.findElement(By.id("j_idt88:name")).sendKeys("karthi Nanjundeswaran");

		// Append Country to this City.
		driver.findElement(By.id("j_idt88:j_idt91")).sendKeys("Tamil Nadu");

		// Verify if text box is disabled
		WebElement boxIsDisabled = driver.findElement(By.xpath("//*[@class='grid formgrid'][3]"));
		boolean enabled = boxIsDisabled.isEnabled();
		System.out.println(enabled);

		// Clear the typed text.
		driver.findElement(By.id("j_idt88:j_idt95")).clear();

		// Retrieve the typed text.
		WebElement retrive = driver.findElement(By.id("j_idt88:j_idt97"));
		String text = retrive.getAttribute("value");
		System.out.println(text);

		// Type email and Tab. Confirm control moved to next element.
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("karnanjugee@gmail.com"+Keys.TAB);

		// Text Editor
		driver.findElement(By.xpath("(//*[@class='ql-size ql-picker'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-value='huge']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")).sendKeys("karthi Nanjundeswaran");

		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys(""+Keys.ENTER);
		WebElement findword = driver.findElement(By.xpath("//*[text()='Age is mandatory']"));
		String text1 = findword.getText();
		System.out.println(text1);
		if (text1.contains("Age is mandatory")) {
			System.out.println("error message confirm");
		}
		
		// Click and Confirm Label Position Changes
		WebElement labelPosition = driver.findElement(By.id("j_idt106:j_idt113"));
		Point location = labelPosition.getLocation();
		System.out.println(location);
		WebElement textfield = driver.findElement(By.id("j_idt106:float-input"));
		textfield.click();
		WebElement labelPosition2 = driver.findElement(By.id("j_idt106:j_idt113"));
		Point location1 = labelPosition2.getLocation();
		System.out.println(location1);
		if (labelPosition == labelPosition2) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}
		
		//Type your name and choose the third option
		driver.findElement(By.id("j_idt106:auto-complete_input")).sendKeys("karthi");
		List<WebElement> findElements = driver.findElements(By.xpath("//span[@role='listbox']//li"));
		
		int position=0;
		for (WebElement webElement : findElements) {
			System.out.println(webElement.getText());
			position++;
			if(position==3) {
				webElement.click();
				break;
			}
		
				
		}

		/*
		 * WebElement findElement =
		 * driver.findElement(By.id("j_idt106:j_idt116_input"));
		 * findElement.sendKeys("07/07/1994");
		 */
		//Type number and check the slider moves correctly.
		WebElement sliderpoint = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/div"));
		sliderpoint.getLocation();
		WebElement typeNumber = driver.findElement(By.id("j_idt106:slider"));
		typeNumber.sendKeys("30");
		WebElement sliderpoint2 = driver.findElement(By.xpath("(//*[@id='j_idt106:j_idt120']//div//following::span)[1]"));
		sliderpoint2.getLocation();
		//typeNumber.getLocation();
		if (sliderpoint != sliderpoint2) {
			System.out.println("moves correctly");
		}
		
		//Type number and check the slider moves correctly.(another step)
//		WebElement sliderpoint = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/div"));
//		String attribute = sliderpoint.getAttribute("style");
//		System.out.println("Slider rest state "+attribute);
//		
//		WebElement typeNumber = driver.findElement(By.id("j_idt106:slider"));
//		typeNumber.sendKeys("30");
//		
//		WebElement sliderpoint2 = driver.findElement(By.xpath("//*[@id='j_idt106:j_idt120']/div"));
//		String attribute1 = sliderpoint.getAttribute("style");
//		System.out.println("Slider moved state "+attribute1);
//		
//		if(attribute==attribute1){
//			System.out.println("moves wrongly");
//		}
//		else {
//			System.out.println("moves corectly");
//		}
		

	}

}
