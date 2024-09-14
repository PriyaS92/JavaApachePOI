import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MakemyTrip_Application {

	WebDriver driver;
	WebDriverWait wait;
	WebElement search_button,close_dialog,from_city_button,to_city_button,
	departure_date,return_date,return_timing,departure_destination;
	JavascriptExecutor js;
	
	public void setup() {
		try {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("start-maximized");
			options.addArguments("--disable-web-security");
			options.addArguments("--disable-site-isolation-trials");
			options.addArguments("--disable-blink-features");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation" , "load-extension"));
			options.setExperimentalOption("useAutomationExtension", false);
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\git\\JavaApachePOI\\chromedriver.exe");
			driver = new ChromeDriver(options);
			driver.get("https://www.makemytrip.com");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void searchpage_validation() {
		try {
			close_dialog = driver.findElement(By.xpath("//span[@class='commonModal__close']"));
			close_dialog.click();
			driver.findElement(By.xpath("//li[@data-cy='roundTrip']/span")).click();
			from_city_button = driver.findElement(By.id("fromCity"));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(from_city_button));
			from_city_button.click();
			driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys("HYD");
			driver.findElement(By.xpath("//span[text()='Hyderabad']")).click();		
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			to_city_button = driver.findElement(By.id("toCity"));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(from_city_button));
			to_city_button.click();
			driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("MAA");
			driver.findElement(By.xpath("//span[text()='Chennai']")).click();		
			departure_date = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::p[text()='21'][1]"));
			departure_date.click();
			return_date = driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::p[text()='10'][2]"));			
			wait.until(ExpectedConditions.elementToBeClickable(return_date));	
			return_date.click();
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", driver.findElement(By.xpath("//div[@data-cy='flightTraveller']/label/span")));
			driver.findElement(By.xpath("//li[text()='Business']")).click();
			driver.findElement(By.xpath("//button[text()='APPLY']")).click();
			search_button = driver.findElement(By.xpath("//a[text()='Search']"));
			search_button.click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
			driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//span[@class='customArrow arrowUp']")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String source_destination = driver.findElement(By.xpath("//div[@class='flightDetails'][1]/p[1]")).getText();
			String destination_source = driver.findElement(By.xpath("//div[@class='flightDetails'][2]/p[1]")).getText();
			if(source_destination.contains("Hyderabad to")) {
				System.out.println(source_destination);
			}
			if(destination_source.contains("Chennai to")) {
				System.out.println(destination_source);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void teardown() {
		try {
			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MakemyTrip_Application mmt = new MakemyTrip_Application();
		mmt.setup();
		mmt.searchpage_validation();
		mmt.teardown();
	}

}
