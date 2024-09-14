package CommonFunctions;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	public static WebDriver driver;
	
	public BaseTest(){
		capability_setup();
		driver.manage().window().maximize();
	}
	
	public void capability_setup() {
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
	}
}
