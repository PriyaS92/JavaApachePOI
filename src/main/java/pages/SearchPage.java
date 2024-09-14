package pages;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonFunctions.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;

public class SearchPage extends BaseTest{
	@FindBy(xpath="//span[@class='commonModal__close']")
	public WebElement close_dialog;
	@FindBy(xpath="//li[@data-cy='roundTrip']/span")
	public WebElement from_trip_dropdown;
	@FindBy(id="fromCity")
	public WebElement from_city_button;
	@FindBy(xpath="//input[@placeholder='From']")
	public WebElement from_trip;
	@FindBy(xpath="//span[text()='Hyderabad']")
	public WebElement from_trip_text;
	@FindBy(id="toCity")
	public WebElement to_city_button;
	@FindBy(xpath="//input[@placeholder='To']")
	public WebElement to_trip;
	@FindBy(xpath="//span[text()='Chennai']")
	public WebElement to_trip_text;
	@FindBy(xpath="//div[@data-cy='flightTraveller']/label/span")
	public WebElement flight;
	@FindBy(xpath="//li[text()='Business']")
	public WebElement flightclass;
	@FindBy(xpath="//button[text()='APPLY']")
	public WebElement apply_button;
	@FindBy(xpath="//a[text()='Search']")
	public WebElement search_button;
	@FindBy(xpath="//button[text()='OKAY, GOT IT!']")
	public WebElement alert;
	@FindBy(xpath="//span[@class='customArrow arrowUp']")
	public WebElement banner_arrow;
	@FindBy(xpath="//div[@class='flightDetails'][1]/p[1]")
	public WebElement source_trip;
	@FindBy(xpath="//div[@class='flightDetails'][2]/p[1]")
	public WebElement dest_trip;
			
	public WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public SearchPage(){
		this.driver = BaseTest.driver;
		PageFactory.initElements(driver, this);
	}
	
	public void login_application() {
		BaseTest.driver.get("https://www.makemytrip.com");
		BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		close_dialog.click();
	}
	
	public void ticket_booking(String from,String to,String from_date,String return_date){
		try {
			from_trip_dropdown.click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(from_city_button));
			from_city_button.click();
			from_trip.sendKeys(from);
			from_trip_text.click();
			BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.elementToBeClickable(to_city_button));
			to_city_button.click();
			to_trip.sendKeys(to);
			to_trip_text.click();
			WebElement departure_date = BaseTest.driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::p[text()='"+from_date+"'][1]"));
			departure_date.click();
			WebElement returndate = BaseTest.driver.findElement(By.xpath("//div[@class='DayPicker-Months']/descendant::p[text()='"+return_date+"'][2]"));			
			wait.until(ExpectedConditions.elementToBeClickable(returndate));	
			returndate.click();
			js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click()", flight);
			flightclass.click();
			apply_button.click();
			search_button.click();
			BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		  }
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void search_page_validation(String from_place,String to_place) {
		try {
			alert.click();
			BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			banner_arrow.click();
			BaseTest.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			String source_destination = source_trip.getText();
			String destination_source = dest_trip.getText();
			if(source_destination.contains(from_place)) {
				System.out.println(source_destination);
			}
			if(destination_source.contains(to_place)) {
				System.out.println(destination_source);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
