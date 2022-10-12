package week2.day2.Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.leafground.com/link.xhtml;jsessionid=node010nx464jtc8vzxsmrg4fp0yu9138.node0");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Take me to dashboard
		driver.findElement(By.linkText("Go to Dashboard")).click();
		driver.navigate().back();
		
		//Find my destination
		WebElement WhereToGo = driver.findElement(By.linkText("Find the URL without clicking me."));
		String Value = WhereToGo.getAttribute("href");
		System.out.println(Value);
		
		//Am I broken link?
		WebElement brokenPage = driver.findElement(By.linkText("Broken?"));
		brokenPage.click();
		String title = driver.getTitle();
		System.out.println(title);
		if(title.contains("Error 404")) {
			System.out.println("Tittle is Broken");
			}
		else {
			System.out.println("not broken");
		}
		driver.navigate().back();

		//Count Links
		List<WebElement> howManyLinks = driver.findElements(By.tagName("a"));
		int size = howManyLinks.size();
		System.out.println(size);
	}

}
