package week2.day2.Assignments;

import java.time.Duration;

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
		driver.findElement(By.id("j_idt88:j_idt99")).sendKeys("karnanjugee@gmail.com" + Keys.TAB);

		// Text Editor
		driver.findElement(By.xpath("(//*[@class='ql-size ql-picker'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@data-value='huge']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")).sendKeys("karthi Nanjundeswaran");

		driver.findElement(By.id("j_idt106:thisform:age")).sendKeys("" + Keys.ENTER);
		WebElement findword = driver.findElement(By.xpath("//*[text()='Age is mandatory']"));
		String text1 = findword.getText();
		System.out.println(text1);
		if (text1.contains("Age is mandatory")) {
			System.out.println("error message confirm");
		}

		WebElement labelPosition = driver.findElement(By.id("j_idt106:float-input"));
		Point location = labelPosition.getLocation();
		System.out.println(location);
		labelPosition.click();
		if (labelPosition == location) {
			System.out.println("same");
		} else {
			System.out.println("not same");
		}

		/*
		 * WebElement findElement =
		 * driver.findElement(By.id("j_idt106:j_idt116_input"));
		 * findElement.sendKeys("07/07/1994");
		 */

		WebElement sliderpoint = driver.findElement(By.xpath("//*[@id=\"j_idt106:j_idt120\"]/span"));
		sliderpoint.getLocation();
		WebElement typeNumber = driver.findElement(By.id("j_idt106:slider"));
		typeNumber.sendKeys("30");
		//typeNumber.getLocation();
		if (sliderpoint == sliderpoint) {
			System.out.println("moves correctly");
		}

	}

}
