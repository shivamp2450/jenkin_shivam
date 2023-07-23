package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BookingPage extends WaitsMethod {

	WebDriver driver;
//	Page Factory

	public BookingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
//	Locators
	@FindBy(how = How.NAME, using="fromPort")
	private WebElement departure_city;
	
	@FindBy(how = How.NAME, using = "toPort")
	private WebElement destination_city;
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/form/div/input")
	private WebElement find_flights;
	
	
	@FindBy(how = How.XPATH, using = "/html/body/div[2]/table/tbody/tr[2]/td[1]/input")
	WebElement select_flight;
	@FindBy(how = How.XPATH, using = "//input[@id='inputName']")
	WebElement name;
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	WebElement Address;
	@FindBy(how = How.XPATH, using = "//input[@id='city']")
	WebElement city;
	@FindBy(how = How.XPATH, using = "//input[@id='state']")
	WebElement state;
	@FindBy(how = How.XPATH, using = "//input[@id='zipCode']")
	WebElement zip;
	@FindBy(how = How.NAME, using = "cardType")
	WebElement ct;
	@FindBy(how = How.XPATH, using = "//*[@id=\"creditCardNumber\"]")
	WebElement ccn ;
	@FindBy(how = How.XPATH, using = "//input[@id='creditCardMonth']")
	WebElement com;
	@FindBy(how = How.XPATH, using = "//input[@id='creditCardYear']")
	WebElement coy;
	@FindBy(how = How.XPATH, using = "//input[@id='nameOnCard']")
	WebElement cardname;
	@FindBy(how = How.XPATH, using = "//body/div[2]/form[1]/div[11]/div[1]/input[1]")
	WebElement sumbit;
	
	public void clickDepartureCity() throws InterruptedException {
		
		
		explicitWaitSelectDropDown(driver, departure_city, 2).selectByValue("Paris");;
		
	}
	
	public void clickDestinationCity() throws InterruptedException {
		
		explicitWaitSelectDropDown(driver, destination_city, 2).selectByValue("Rome");

	}
	
	public void clickFindFlights() throws InterruptedException {
		
		explicitWaitOnClick(driver, find_flights, 2);

	}
	
	public void chooseflight() throws InterruptedException {
	
		explicitWaitOnClick(driver, select_flight, 2);
	
	}
	public void Entername() throws InterruptedException {
		
		explicitWaitOnSendkeys(driver,name,2,"Shivam");
	}
	public void EnterAddress() throws InterruptedException {
		explicitWaitOnSendkeys(driver,Address,2,"Ningha");
	}
	public void EnterCity() throws InterruptedException {
		explicitWaitOnSendkeys(driver,city,2,"kanpur");
	}
	public void EnterState() throws InterruptedException {
		explicitWaitOnSendkeys(driver,state,2,"UP");
	}
	public void EnterZip() throws InterruptedException {
		explicitWaitOnSendkeys(driver,zip,2,"208005");

	}
	public void EnterCardType() throws InterruptedException {
		explicitWaitSelectDropDown(driver, ct, 2).selectByValue("visa");;

	}
	public void EnterCardNumber() throws InterruptedException {
		explicitWaitOnSendkeys(driver,ccn,2,"12345678575");

	}
	public void EnterCardMonth() throws InterruptedException {
		explicitWaitOnSendkeys(driver,com,2,"10");

	}
	public void EnterCardYear() throws InterruptedException {
		explicitWaitOnSendkeys(driver,coy,2,"kanpur");

	}
	public void EnterCardName() throws InterruptedException {
		explicitWaitOnSendkeys(driver,cardname,2,"Shivam pandey");

	}
	public void FinalSumbit() throws InterruptedException {
		explicitWaitOnClick(driver,sumbit,2);
	}
	
}
