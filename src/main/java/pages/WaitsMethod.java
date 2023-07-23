package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitsMethod {
	static WebDriver driver;
	
	/* 
	 * use driver wait and  click operation
	 *  */
	public void explicitWaitOnClick(WebDriver driver,WebElement elements,int waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,waitTimeInSeconds);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elements));
		element.click();
	}
	
	/* 
	 * use driver wait and  select drop-down operation
	 *  */
	public Select explicitWaitSelectDropDown(WebDriver driver,WebElement elements,int waitTimeInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver,waitTimeInSeconds);
		wait.until(ExpectedConditions.elementToBeClickable(elements));
		Select ele = new Select(elements);
		List<WebElement> departureOptions = ele.getOptions();
		for (WebElement option : departureOptions) {
			System.out.println(option.getText());
		}
		return ele;
	}
	
	/* 
	 * use driver wait and sendKeys operation.
	 *  */
	public static void explicitWaitOnSendkeys(WebDriver driver, WebElement elements, int waitTimeInSeconds,String value){
		WebDriverWait wait =new WebDriverWait(driver,waitTimeInSeconds);
		WebElement element=wait	.until(ExpectedConditions.elementToBeClickable(elements));
		element.click();
		element.clear();
		element.sendKeys(value);
		}
	
}
