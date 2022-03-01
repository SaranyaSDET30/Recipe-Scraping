package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubLinksObjects {
	WebDriver driver = null;
	public	SubLinksObjects(WebDriver driver){
		this.driver = driver;
	}
	By health_in_menu = new By.ByXPath(("//a[text()='Health']"));
	By blood_pressure_in_health = new By.ByXPath("//a[text()='High Blood Pressure']");
	public WebElement getHealthInMenu() {
		
		return driver.findElement(health_in_menu);
	}
       
	public WebElement getBloodPressureInHealth() {
		
		return driver.findElement(blood_pressure_in_health);
	}
//y//m

}
